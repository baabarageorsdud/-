# 区块链存证 MVP 开发文档

> 本文档描述"基于微信小程序的学历学位认证系统"中，以太坊链上存证模块的最小可用实现（MVP）。

---

## 1. 设计原则：链上只存 hash，不存隐私明文

链上存证的核心原则是：**原始数据留在链下（MySQL），链上只记录关键字段的摘要（hash）**。

具体做法：

1. 将认证申请的关键字段拼接成 canonical string：
   ```
   requestId|userId|schoolId|degree|major|graduationYear|timestamp
   ```
2. 对 canonical string 做 **SHA-256**，得到 32 字节摘要。
3. 将摘要（bytes32）连同 requestId、备注写入 Solidity 合约。

**为什么这样做？**

| 考虑点 | 说明 |
|--------|------|
| 隐私保护 | 身份证号、姓名等敏感信息不上链，防止隐私泄露 |
| Gas 成本 | bytes32 存储远比任意长字符串便宜 |
| 可验真 | 验证方只需重新计算 hash 再与链上比对，无需读取明文 |
| 防篡改 | 链上 hash 一旦写入不可修改，业务数据若被篡改，hash 即不匹配 |

---

## 2. 项目结构

```
.
├── blockchain/                  # Hardhat 项目（Solidity 合约 + 脚本）
│   ├── contracts/
│   │   └── Attestation.sol      # 存证智能合约
│   ├── scripts/
│   │   ├── deploy.js            # 部署脚本
│   │   └── demo.js              # 演示脚本（写入 + 读取）
│   ├── hardhat.config.js
│   └── package.json
│
├── blockchain-demo/             # Spring Boot 最小演示服务（web3j）
│   ├── pom.xml
│   └── src/main/
│       ├── java/com/example/blockchain/
│       │   ├── BlockchainDemoApplication.java
│       │   ├── controller/AttestationController.java
│       │   ├── service/AttestationService.java
│       │   └── dto/
│       │       ├── AttestRequest.java
│       │       ├── AttestResponse.java
│       │       └── AttestationInfo.java
│       └── resources/
│           └── application.properties
│
└── docs/
    └── blockchain-mvp.md        # 本文档
```

---

## 3. 智能合约接口说明

合约文件：`blockchain/contracts/Attestation.sol`

### 3.1 状态变量

| 变量 | 类型 | 说明 |
|------|------|------|
| `owner` | `address` | 合约部署者，仅其可写入存证 |

### 3.2 写入函数

```solidity
function attest(uint256 requestId, bytes32 hash, string calldata meta) external onlyOwner
```

| 参数 | 类型 | 说明 |
|------|------|------|
| `requestId` | `uint256` | 认证申请唯一编号 |
| `hash` | `bytes32` | 关键字段摘要 |
| `meta` | `string` | 可选备注，如 `"degree:bachelor\|school:school_01"` |

### 3.3 查询函数

```solidity
function getAttestation(uint256 requestId) external view
    returns (bytes32 hash, uint256 timestamp, address issuer, string memory meta)
```

### 3.4 事件

```solidity
event Attested(uint256 indexed requestId, bytes32 indexed hash, uint256 timestamp, address indexed issuer);
```

### 3.5 权限说明

- 写入（`attest`）：仅 `owner` 可调用。
- 读取（`getAttestation`）：任何地址均可调用（`view` 函数，无 Gas 消耗）。
- 权限转移：`transferOwnership(address newOwner)`，仅 owner 可调用。

---

## 4. 快速开始

### 4.1 前置依赖

| 工具 | 版本要求 | 安装说明 |
|------|---------|---------|
| Node.js | ≥ 18 | https://nodejs.org |
| npm | ≥ 9 | 随 Node.js 一起安装 |
| Java | 17 | https://adoptium.net |
| Maven | ≥ 3.8 | https://maven.apache.org |

### 4.2 安装 Hardhat 依赖

```bash
cd blockchain
npm install
```

### 4.3 启动本地以太坊节点

```bash
# 在单独的终端窗口中运行（保持运行状态）
npm run chain
```

输出示例：
```
Started HTTP and WebSocket JSON-RPC server at http://127.0.0.1:8545/

Accounts
========
Account #0: 0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266 (10000 ETH)
Private Key: 0xac0974bec39a17e36ba4a6b4d238ff944bacb478cbed5efcae784d7bf4f2ff80
...
```

> ⚠️ **安全提示**：以上私钥仅为 Hardhat 本地测试账户，**不得用于真实网络**。

### 4.4 编译合约

```bash
npm run compile
```

### 4.5 部署合约

```bash
npm run deploy
```

输出示例：
```
部署账户: 0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266
账户余额: 10000.0 ETH
✅ Attestation 合约已部署，地址: 0x5FbDB2315678afecb367f032d93F642f64180aa3
请将以下配置填入 blockchain-demo/src/main/resources/application.properties：
  blockchain.contract-address=0x5FbDB2315678afecb367f032d93F642f64180aa3
```

### 4.6 运行演示脚本（写入 + 读取）

```bash
CONTRACT_ADDRESS=0x5FbDB2315678afecb367f032d93F642f64180aa3 npm run demo
```

输出示例：
```
canonical string: 1001|user_42|school_01|bachelor|software_engineering|2025|1717171717
--- 写入存证 ---
requestId: 1001
hash: 0x3a9b...
✅ 交易已确认，txHash: 0xabc...

--- 查询存证 ---
hash:      0x3a9b...
timestamp: 2025-06-01T12:08:37.000Z
issuer:    0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266
meta:      degree:bachelor|school:school_01|year:2025

存证验真: ✅ hash 一致，验证通过
```

### 4.7 启动 Spring Boot 演示服务

```bash
# 先将合约地址填入 application.properties
cd blockchain-demo
mvn spring-boot:run
```

### 4.8 调用 REST API（curl 示例）

**写入存证：**
```bash
curl -X POST http://localhost:8080/api/attest \
  -H "Content-Type: application/json" \
  -d '{
    "requestId": 1001,
    "userId": "user_42",
    "schoolId": "school_01",
    "degree": "bachelor",
    "major": "software_engineering",
    "graduationYear": "2025"
  }'
```

响应：
```json
{
  "requestId": 1001,
  "txHash": "0xabc123...",
  "attestedHash": "0x3a9b...",
  "contractAddress": "0x5FbDB2315678afecb367f032d93F642f64180aa3"
}
```

**查询存证（验真）：**
```bash
curl http://localhost:8080/api/attest/1001
```

响应：
```json
{
  "requestId": 1001,
  "hash": "0x3a9b...",
  "timestamp": "2025-06-01T12:08:37Z",
  "issuer": "0xf39Fd6e51aad88F6F4ce6aB8827279cffFb92266",
  "meta": "degree:bachelor|school:school_01|year:2025"
}
```

---

## 5. 常见问题（FAQ）

### Q1：Gas 费用怎么控制？

- 本地 Hardhat 节点无需真实 ETH，Gas 费用为 0（测试环境）。
- 生产环境若使用以太坊主网，每次写入约消耗 50,000–100,000 gas，按 Gas Price 折算。
- 优化建议：将多条存证批量打包（batch attest）或采用 Layer2（如 Arbitrum、Optimism）以降低成本。

### Q2：权限如何管理？

- 当前实现：仅 `owner`（合约部署账户）可写入，读取完全开放。
- 扩展方案：添加 `mapping(address => bool) public issuers` + `setIssuer(address, bool)` 函数，支持多个授权地址写入。

### Q3：如何保护隐私？

- 链上只存 hash，不存明文。
- 验证方持有原始字段时可自行重算 hash 与链上比对。
- 敏感字段（身份证号、姓名）不参与 canonical string 或单独加密后再 hash。

### Q4：上链失败怎么办？

建议在 Spring Boot 后端实现**异步补偿**：
1. 写入 MySQL 时同时记录 `blockchain_status=PENDING`。
2. 定时任务轮询 `PENDING` 记录，重试上链。
3. 上链成功后更新 `blockchain_status=SUCCESS` 并存储 `tx_hash`。

### Q5：链上/链下数据一致性如何保证？

- MySQL 中的 `blockchain_hash` 字段与链上存证的 hash 保持一致。
- 任何时候可通过 `GET /api/attest/{requestId}` 重新从链上读取并比对。
- 若业务数据被篡改，重新计算 hash 后与链上不匹配，即可检测出问题。
