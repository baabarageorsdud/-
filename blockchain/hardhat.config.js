require("@nomicfoundation/hardhat-toolbox");

/** @type import('hardhat/config').HardhatUserConfig */
module.exports = {
  solidity: "0.8.20",
  networks: {
    // 本地 Hardhat 节点（npm run chain 启动）
    localhost: {
      url: "http://127.0.0.1:8545",
    },
  },
};
