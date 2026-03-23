// SPDX-License-Identifier: MIT
pragma solidity ^0.8.20;

/**
 * @title Attestation
 * @notice 学历学位认证链上存证合约
 * @dev 仅 owner 可写入，读取对所有人开放。
 *      链上只存证关键字段的 hash（bytes32），不存隐私明文。
 */
contract Attestation {
    address public owner;

    struct Record {
        bytes32 hash;       // 认证关键字段的摘要（SHA-256 或 keccak256）
        uint256 timestamp;  // 存证时间（Unix 秒）
        address issuer;     // 操作者地址
        string  meta;       // 可选备注（如 "degree:bachelor|school:XXX"）
    }

    // requestId（uint256） => 存证记录
    mapping(uint256 => Record) private _records;

    event Attested(
        uint256 indexed requestId,
        bytes32 indexed hash,
        uint256 timestamp,
        address indexed issuer
    );

    modifier onlyOwner() {
        require(msg.sender == owner, "Attestation: caller is not owner");
        _;
    }

    constructor() {
        owner = msg.sender;
    }

    /**
     * @notice 写入存证
     * @param requestId  认证申请唯一编号
     * @param hash       关键字段摘要（bytes32）
     * @param meta       可选备注字符串
     */
    function attest(
        uint256 requestId,
        bytes32 hash,
        string calldata meta
    ) external onlyOwner {
        require(hash != bytes32(0), "Attestation: hash must not be zero");
        _records[requestId] = Record({
            hash:      hash,
            timestamp: block.timestamp,
            issuer:    msg.sender,
            meta:      meta
        });
        emit Attested(requestId, hash, block.timestamp, msg.sender);
    }

    /**
     * @notice 查询存证
     * @param requestId  认证申请唯一编号
     * @return hash      存证 hash
     * @return timestamp 存证时间戳
     * @return issuer    操作者地址
     * @return meta      备注
     */
    function getAttestation(uint256 requestId)
        external
        view
        returns (
            bytes32 hash,
            uint256 timestamp,
            address issuer,
            string memory meta
        )
    {
        Record storage r = _records[requestId];
        return (r.hash, r.timestamp, r.issuer, r.meta);
    }

    /**
     * @notice 转移 owner 权限
     */
    function transferOwnership(address newOwner) external onlyOwner {
        require(newOwner != address(0), "Attestation: zero address");
        owner = newOwner;
    }
}
