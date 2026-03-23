package com.example.blockchain.service;

import com.example.blockchain.dto.AttestRequest;
import com.example.blockchain.dto.AttestResponse;
import com.example.blockchain.dto.AttestationInfo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * 链上存证服务
 *
 * <p>职责：
 * <ol>
 *   <li>计算存证 hash：对关键字段组成的 canonical string 做 SHA-256，转为 bytes32。</li>
 *   <li>通过 web3j 调用合约 attest() 写入链上。</li>
 *   <li>通过 web3j 调用合约 getAttestation() 读取链上存证。</li>
 * </ol>
 */
@Service
public class AttestationService {

    private static final Logger log = Logger.getLogger(AttestationService.class.getName());

    // Attestation 合约 ABI 函数签名
    private static final String FUNC_ATTEST           = "attest";
    private static final String FUNC_GET_ATTESTATION  = "getAttestation";

    @Value("${blockchain.rpc-url}")
    private String rpcUrl;

    @Value("${blockchain.private-key}")
    private String privateKey;

    @Value("${blockchain.contract-address}")
    private String contractAddress;

    private Web3j          web3j;
    private Credentials    credentials;
    private ContractGasProvider gasProvider;

    @PostConstruct
    public void init() {
        web3j       = Web3j.build(new HttpService(rpcUrl));
        credentials = Credentials.create(privateKey);
        gasProvider = new DefaultGasProvider();
        log.info("Web3j 已连接：" + rpcUrl);
        log.info("合约地址：" + contractAddress);
    }

    // -------------------------------------------------------------------------
    // 公共接口
    // -------------------------------------------------------------------------

    /**
     * 计算存证 hash，并写入链上。
     */
    public AttestResponse attest(AttestRequest req) throws Exception {
        long ts = Instant.now().getEpochSecond();
        String canonical = buildCanonical(req, ts);
        byte[] hashBytes = sha256(canonical);

        log.info("canonical: " + canonical);
        log.info("hash(hex): " + bytesToHex(hashBytes));

        String txHash = sendAttest(req.getRequestId(), hashBytes,
                buildMeta(req));
        return new AttestResponse(
                req.getRequestId(),
                txHash,
                "0x" + bytesToHex(hashBytes),
                contractAddress
        );
    }

    /**
     * 从链上查询存证信息。
     */
    public AttestationInfo getAttestation(Long requestId) throws Exception {
        // 编码 getAttestation(uint256) 调用
        Function fn = new Function(
                FUNC_GET_ATTESTATION,
                List.of(new Uint256(BigInteger.valueOf(requestId))),
                Arrays.asList(
                        new TypeReference<Bytes32>() {},
                        new TypeReference<Uint256>() {},
                        new TypeReference<Address>() {},
                        new TypeReference<Utf8String>() {}
                )
        );

        String encodedFn = FunctionEncoder.encode(fn);
        Transaction callTx = Transaction.createEthCallTransaction(
                credentials.getAddress(), contractAddress, encodedFn);

        EthCall ethCall = web3j
                .ethCall(callTx, DefaultBlockParameterName.LATEST)
                .send();

        if (ethCall.hasError()) {
            throw new RuntimeException("eth_call 失败: " + ethCall.getError().getMessage());
        }

        List<Type> results = FunctionReturnDecoder.decode(
                ethCall.getValue(), fn.getOutputParameters());

        if (results.isEmpty()) {
            throw new RuntimeException("未找到 requestId=" + requestId + " 的存证记录");
        }

        byte[] hashBytes = (byte[]) results.get(0).getValue();
        BigInteger timestamp = (BigInteger) results.get(1).getValue();
        String issuer       = (String) results.get(2).getValue();
        String meta         = (String) results.get(3).getValue();

        String isoTs = timestamp.longValue() == 0
                ? "（未存证）"
                : Instant.ofEpochSecond(timestamp.longValue()).toString();

        return new AttestationInfo(
                requestId,
                "0x" + bytesToHex(hashBytes),
                isoTs,
                issuer,
                meta
        );
    }

    // -------------------------------------------------------------------------
    // 私有工具方法
    // -------------------------------------------------------------------------

    /** canonical string：requestId|userId|schoolId|degree|major|graduationYear|timestamp */
    private static String buildCanonical(AttestRequest req, long timestamp) {
        return String.join("|",
                String.valueOf(req.getRequestId()),
                req.getUserId(),
                req.getSchoolId(),
                req.getDegree(),
                req.getMajor(),
                req.getGraduationYear(),
                String.valueOf(timestamp)
        );
    }

    private static String buildMeta(AttestRequest req) {
        return "degree:" + req.getDegree()
                + "|school:" + req.getSchoolId()
                + "|year:" + req.getGraduationYear();
    }

    /** SHA-256 摘要，返回 32 字节 */
    private static byte[] sha256(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }

    /** 发送 attest 交易，返回 txHash */
    private String sendAttest(Long requestId, byte[] hashBytes, String meta) throws Exception {
        // SHA-256 总是输出恰好 32 字节；若非 32 字节则表明 hash 计算有误
        if (hashBytes.length != 32) {
            throw new IllegalStateException(
                    "hash 长度应为 32 字节（SHA-256 输出），实际为: " + hashBytes.length);
        }
        byte[] padded = hashBytes;

        Function fn = new Function(
                FUNC_ATTEST,
                Arrays.asList(
                        new Uint256(BigInteger.valueOf(requestId)),
                        new Bytes32(padded),
                        new Utf8String(meta)
                ),
                List.of()
        );

        String encodedFn = FunctionEncoder.encode(fn);

        RawTransactionManager txManager = new RawTransactionManager(
                web3j, credentials, getChainId());

        EthSendTransaction response = txManager.sendTransaction(
                gasProvider.getGasPrice(FUNC_ATTEST),
                gasProvider.getGasLimit(FUNC_ATTEST),
                contractAddress,
                encodedFn,
                BigInteger.ZERO
        );

        if (response.hasError()) {
            throw new RuntimeException("发送交易失败: " + response.getError().getMessage());
        }

        String txHash = response.getTransactionHash();
        log.info("交易已发送，txHash: " + txHash);
        return txHash;
    }

    /** 获取当前节点 chainId（Hardhat 本地链默认 31337） */
    private long getChainId() throws Exception {
        return web3j.ethChainId().send().getChainId().longValue();
    }

    /** byte[] → 十六进制字符串 */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
