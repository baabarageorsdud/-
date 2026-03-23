/**
 * 部署 Attestation 合约到本地 Hardhat 节点
 *
 * 运行前请先启动本地链：
 *   npm run chain   （另开终端）
 *
 * 部署命令：
 *   npm run deploy
 *
 * 部署成功后会打印合约地址，请将其填入 Spring Boot 的 application.properties
 */
const { ethers } = require("hardhat");

async function main() {
  const [deployer] = await ethers.getSigners();
  console.log("部署账户:", deployer.address);

  const balance = await ethers.provider.getBalance(deployer.address);
  console.log("账户余额:", ethers.formatEther(balance), "ETH");

  const Attestation = await ethers.getContractFactory("Attestation");
  const contract = await Attestation.deploy();
  await contract.waitForDeployment();

  const address = await contract.getAddress();
  console.log("✅ Attestation 合约已部署，地址:", address);
  console.log("请将以下配置填入 blockchain-demo/src/main/resources/application.properties：");
  console.log(`  blockchain.contract-address=${address}`);
}

main().catch((err) => {
  console.error(err);
  process.exit(1);
});
