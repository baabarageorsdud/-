/**
 * 演示脚本：写入一条存证，再读取并打印结果
 *
 * 前置条件：
 *   1. 本地链已启动（npm run chain）
 *   2. 合约已部署（npm run deploy），并将合约地址填入下方 CONTRACT_ADDRESS
 *
 * 运行：
 *   CONTRACT_ADDRESS=0x... npm run demo
 *   或直接修改本文件中的 CONTRACT_ADDRESS 常量
 */
const { ethers } = require("hardhat");
const crypto = require("crypto");

// ---- 配置区 ----
// 若通过环境变量传入，则优先使用环境变量
const CONTRACT_ADDRESS = process.env.CONTRACT_ADDRESS || "";
// ----------------

/** 模拟 Spring Boot 后端的 hash 计算逻辑：对 canonical string 做 SHA-256 */
function computeHash(fields) {
  const canonical = [
    fields.requestId,
    fields.userId,
    fields.schoolId,
    fields.degree,
    fields.major,
    fields.graduationYear,
    fields.timestamp,
  ].join("|");

  console.log("canonical string:", canonical);
  // SHA-256 总是输出 32 字节（64 个十六进制字符），直接用作 bytes32
  const sha256 = crypto.createHash("sha256").update(canonical).digest("hex");
  return "0x" + sha256;
}

async function main() {
  if (!CONTRACT_ADDRESS) {
    console.error("❌ 请先设置 CONTRACT_ADDRESS 环境变量，或在脚本中直接填写合约地址。");
    console.error("   示例：CONTRACT_ADDRESS=0xYourAddress npm run demo");
    process.exit(1);
  }

  const [owner] = await ethers.getSigners();
  console.log("当前账户:", owner.address);

  const Attestation = await ethers.getContractAt("Attestation", CONTRACT_ADDRESS);

  // ---- 样例数据 ----
  const sampleFields = {
    requestId:      "1001",
    userId:         "user_42",
    schoolId:       "school_01",
    degree:         "bachelor",
    major:          "software_engineering",
    graduationYear: "2025",
    timestamp:      String(Math.floor(Date.now() / 1000)),
  };

  const hashHex = computeHash(sampleFields);
  const requestId = 1001;
  const meta = `degree:${sampleFields.degree}|school:${sampleFields.schoolId}|year:${sampleFields.graduationYear}`;

  console.log("\n--- 写入存证 ---");
  console.log("requestId:", requestId);
  console.log("hash:", hashHex);
  console.log("meta:", meta);

  const tx = await Attestation.attest(requestId, hashHex, meta);
  const receipt = await tx.wait();
  console.log("✅ 交易已确认，txHash:", receipt.hash);

  console.log("\n--- 查询存证 ---");
  const [storedHash, storedTs, storedIssuer, storedMeta] =
    await Attestation.getAttestation(requestId);

  console.log("hash:     ", storedHash);
  console.log("timestamp:", new Date(Number(storedTs) * 1000).toISOString());
  console.log("issuer:   ", storedIssuer);
  console.log("meta:     ", storedMeta);

  const match = storedHash.toLowerCase() === hashHex.toLowerCase();
  console.log("\n存证验真:", match ? "✅ hash 一致，验证通过" : "❌ hash 不一致，验证失败");
}

main().catch((err) => {
  console.error(err);
  process.exit(1);
});
