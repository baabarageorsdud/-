

# 基于微信小程序的学历学位认证系统

> **区块链存证说明**：本仓库已实现**以太坊链上存证最小可用版（MVP）**，包含：
> - Solidity 智能合约（`blockchain/contracts/Attestation.sol`）
> - Hardhat 本地开发环境（一键启动本地链、部署、演示）
> - Spring Boot + web3j 存证演示服务（`blockchain-demo/`）
>
> 区块链实现方案：本地以太坊（Hardhat）+ Solidity 0.8 合约 + Spring Boot（web3j 4.x）  
> **链上只存关键字段的 SHA-256 hash，不存隐私明文**。  
> 详细说明见 [`docs/blockchain-mvp.md`](docs/blockchain-mvp.md)  
> 复试材料见 [`docs/复试材料-6页版.md`](docs/复试材料-6页版.md)

---

## 仓库结构

```
.
├── blockchain/              # Hardhat 项目（Solidity 合约 + 部署/演示脚本）
├── blockchain-demo/         # Spring Boot 区块链存证演示服务
├── docs/
│   ├── blockchain-mvp.md    # 区块链存证 MVP 开发文档
│   └── 复试材料-6页版.md    # 复试材料（可导出为 Word）
└── README.md
```

---

毕业设计(论文)
题  目：	基于微信小程序的学历学位认证系统
	开发与设计


学生姓名	曹芝群
学    号	202102050101
专业班级	软件工程2101
二级学院	信息工程学院
指导教师（职称）	冯志林（教授）




2025 年 6 月  



诚信承诺书

本人谨此承诺，本人所写毕业设计（论文）均由本人独立撰写，无任何抄袭行为。凡涉及他人的观点材料，均作了注释。如出现抄袭或侵犯他人知识产权的情况，愿承担由此引起的任何责任，并接受相应的处分。


      学生签名：
年   月   日


基于微信小程序的学历学位认证系统
【摘要】在数字化时代的背景下，学历学位认证作为一种重要的社会认证手段，传统的认证方式逐渐暴露出效率低、便捷性差等问题。随着移动互联网和云技术的快速发展，基于微信小程序的学历学位认证系统应运而生。该系统旨在提供一种无需安装额外应用、跨平台且易于分享的学历学位认证解决方案，简化用户操作流程，提高认证效率，适应现代用户的多场景需求。
本系统的后端采用SpringBoot框架，结合MyBatis进行数据库操作，基于SpringMVC设计模式实现前后端分离架构，确保系统的高效与稳定。数据库选用MySQL，满足大规模数据存储和查询需求。在前端方面，系统通过微信小程序提供简洁而高效的UI设计，方便用户进行学历学位证书的上传、查询与验证。
	
【关键词】  微信小程序，SpringBoot，MyBatis，SpringMVC，MySQL

Degree Certification System based on WeChat Mini Program
【Abstract】In the context of the digital era, degree certification has become an important social validation method. However, traditional certification methods have revealed issues such as low efficiency and poor convenience. With the rapid development of mobile internet and cloud technologies, a degree certification system based on WeChat Mini Programs has emerged. The system aims to provide a degree certification solution that does not require additional app installation, is cross-platform, and easy to share. It simplifies the user operation process, improves certification efficiency, and adapts to the multi-scenario needs of modern users.
   The backend of this system uses the SpringBoot framework, combined with MyBatis for database operations, and follows the SpringMVC design pattern to achieve a front-end and back-end separation architecture, ensuring system efficiency and stability. MySQL is used as the database to meet the needs of large-scale data storage and queries. On the front end, the system uses a WeChat Mini Program to provide a simple and efficient UI design, allowing users to upload, query, and verify degree certificates.

【Key Words】  WeChat Mini Program，SpringBoot，MyBatis，SpringMVC，MySQL


目 录
1 绪 论	1
1.1 论文研究背景与意义	1
1.2 国内外研究现状	2
1.3 研究主要内容	2
2 相关技术简介	4
2.1微信小程序	4
2.2 SpringBoot + MyBatis架构	4
2.3 SpringMVC设计模式	5
2.4 MySQL	5
2.5 以太坊区块链	6
3 学历学位认证系统需求分析	7
3.1 学历学位认证系统概述	7
3.2 学历学位认证系统功能性需求分析	7
3.3 学历学位认证系统非功能性需求分析	15
3.4 学历学位认证系统数据结构需求分析	16
4 学历学位认证系统设计	17
4.1 学历学位认证系统架构设计	17
4.2 学历学位认证系统功能结构设计	19
4.3 学历学位认证系统数据库设计	19
4.3.1 数据库设计概述	20
4.3.2 数据库表结构设计	20
4.4 学历学位认证系统对象模型设计	22
5 学历学位认证系统实现	23
5.1 用户端功能模块实现	23
5.1.1 用户注册功能实现	23
5.1.2 用户登录功能实现	26
5.1.3 我的页面功能实现	29
5.1.4 提交学历学位认证信息功能	35
5.1.5 首页功能	41
5.1.6 认证记录详细信息功能	46
5.1.7 搜索申请信息功能	52
5.1.8 编辑资料功能实现	55
5.1.9 更多公告功能实现	57
6 学历学位认证系统测试	60
6.1 用户端功能模块测试	60
6.2 展望	62
结 论	64
参考文献	65
致 谢	67


图目录
图2.1数据库语言市场占有率	5
图3.1系统用例图	8
图3.2用户微信一键登录系统流程图	9
图3.3用户普通登录系统流程图	9
图3.4用户注册系统流程图	10
图3.5用户搜索流程图	11
图3.6学历学位认证申请流程图	12
图3.7删除学历学位认证申请流程图	13
图3.8区块查询流程图	14
图3.9编辑资料流程图	15
图3.10系统E-R图	16
图4.1 学历学位认证系统架构图	17
图4.2 用户端功能模块图	19
图4.3 系统实体类图	22
图5.1 用户注册页面	23
图5.2 用户登录页面	26
图5.3 微信一键登录页面	26
图5.4 我的页面	30
图5.5 学历学位认证页面	36
图5.6 首页页面	42
图5.7 认证记录详细信息页面	46
图5.8 搜索申请信息页面	53
图5.9 编辑资料页面	55
图5.10 更多公告页面	57

表目录
表3.1 用户登录用例描述	7
表3.2 用户注册用例描述	9
表3.3 搜索用例描述	9
表3.4 提交学历学位认证申请用例描述	10
表3.5 删除学历学位认证申请用例描述	11
表3.6 区块查询用例描述	12
表3.7 编辑资料用例描述	13
表4.1 用户信息表（Users）	20
表4.2 学校信息表（Schools）	20
表4.3 认证申请信息表（Authentication_Requests）	20
表4.4 区块链记录表（Blockchain_Records）	21
表6.1硬件测试环境	57
表6.2软件测试环境	57
表6.3小程序功能黑盒测试设计表	57

1 绪 论
1.1 论文研究背景与意义
随着社会经济的快速发展和全球化的加速推进，学历和学位的认证在现代社会中变得愈加重要。传统的学历学位认证方式通常依赖于人工审核、纸质证书以及现场验证等手段，这些方式不仅耗时费力，而且容易受到人为因素的影响[1]。随着信息技术的迅猛发展，传统认证方式逐渐暴露出效率低、便捷性差以及信息不透明等问题。与此同时，微信小程序作为一种新型的互联网应用，因其便捷、无需下载安装以及广泛的用户基础，迅速在各行各业中得到应用[2]。将微信小程序与学历学位认证相结合，能够有效提升认证效率，满足日益增长的个性化需求，并优化认证成本，因此基于微信小程序的学历学位认证系统的研究和应用具有极高的现实价值和社会意义。
基于微信小程序的学历学位认证系统能够大幅提升认证效率。传统的学历认证通常需要耗费大量的时间和人力，尤其是在人工审核和资料处理的过程中，容易受到工作量过大或人为疏漏的影响。而通过微信小程序，可以实现自动化的数据查询和证书验证，不仅节省了传统认证模式中所需的繁琐程序，还能快速完成认证任务。这种自动化和便捷性使得系统在大规模用户认证中表现出强大的效率优势，能够大大降低工作成本，提高工作效率[3]。
此外，基于微信小程序的认证系统还能够增强信息的安全性和透明度。利用区块链等先进技术，可以确保认证信息的真实性、完整性和不可篡改性。通过区块链技术，每一笔认证记录都将被加密并保存到区块链中，保证数据的安全性与真实性[4]。大数据分析与云计算技术的结合，可以对大量的认证信息进行智能化管理，提升数据处理的精度和可靠性。透明的认证过程和实时更新的认证信息，有助于提高社会对学历认证系统的信任度，减少信息篡改的可能性。
微信小程序的便利性为用户带来了极大的体验优化，极大地改善了传统学历认证过程中复杂和冗长的步骤。用户无需到现场排队等待，也无需携带大量纸质证书，只需通过手机操作，即可随时随地查询和认证学历学位信息。这种便捷的体验满足了现代社会对高效、低门槛服务的需求，特别是在工作繁忙或地理位置偏远的用户中，具有极高的实用性和吸引力。随着用户需求的多样化和服务的个性化，微信小程序的认证系统能够根据不同用户的具体情况，提供量身定制的服务。
综上所述，基于微信小程序的学历学位认证系统不仅为学历认证提供了创新性的解决方案，还在提升认证效率、安全性、透明度和用户体验方面具有显著优势。通过数字化和智能化技术的应用，推动了学历认证行业的现代化，促进了教育领域的信息化进程。随着全球化的进一步发展，这种基于微信小程序的认证模式将能够在全球范围内得到更广泛的应用，对提高社会诚信度、推动教育公平以及促进教育领域的数字转型具有深远的意义。
1.2 国内外研究现状
近年来，国内外对学历学位认证系统的研究主要集中在提高认证效率、准确性与信息安全等方面。在国内，学历学位认证系统的研究侧重于信息技术的应用，尤其是数字化、区块链技术、二维码和数字证书等手段的结合[5]。例如，中国教育部推出的“中国高等教育学生信息网”（学信网）已成为国内主要的学历认证平台。此外，数据共享与隐私保护也成为关注的重点，研究者正在探索如何在确保个人隐私的基础上，实现各高校与认证机构之间的信息互通。自动化和智能化认证的提升，特别是人工智能、大数据等技术的运用，也为提高学历认证的效率与准确度提供了新的解决方案。
在国外，学历学位认证的研究更多地集中于区块链技术的应用，区块链去中心化与不可篡改的特性为学历认证提供了更加可靠的保障，确保了学历信息的真实性和安全性。同时，国际化学历认证体系的构建也是国外研究的重要方向，特别是在如何简化不同国家和地区之间学历认证的过程，以及如何在各国教育体制差异下实现学历的统一评估和认证。人工智能与自动化认证平台在发达国家的应用，也为提升认证流程的效率和减少人工干预提供了技术支持。
综上所述，国内外的学历学位认证研究均在探索如何利用新兴技术提高认证系统的智能化水平，并致力于解决跨国认证与数据共享的问题。未来，随着技术的不断进步，学历学位认证系统将更加智能化、全球化，并在保障安全性的基础上实现更高效的认证流程。
1.3 研究主要内容
传统的学历学位认证模式常受到地区、机构以及认证流程的影响，导致用户在认证过程中面临繁琐的手续、长时间的等待以及对各类文档的传输和管理的不便。当前，虽然已有一些在线学历认证平台，但大多数平台依赖于传统的网页形式或需要下载特定的APP，限制了用户的便捷性和使用体验，随着微信的普及和小程序的发展，微信小程序为用户提供了无需下载和安装的便捷服务，且可以在微信这一超大用户群体中实现无缝对接。因此，越来越多的开发者开始利用微信小程序开发各类服务，微信庞大的用户基础为此类服务的推广和使用提供了巨大机会。
在此背景下，本文提出了基于微信小程序的学历学位认证系统的构想。该系统旨在通过微信小程序平台为用户提供一个简单、高效的学历学位认证解决方案。用户无需额外安装其他应用程序，即可通过微信小程序实现学历信息的查询、认证申请及结果查询等功能，避免了繁琐的纸质材料传递和多平台操作的困扰。
本研究设计并实现了一个基于微信小程序的学历学位认证系统，旨在简化认证流程、提高数据安全性，并优化用户体验。通过结合区块链技术，保证数据的不可篡改性，提升认证信息的真实性与可靠性。具体来说，区块链技术作为该系统的核心部分，确保了学历学位认证数据在存储和传输过程中的不可篡改性，从而提高了数据的安全性和可信度。每一笔学历认证数据都以区块的形式进行记录，确保信息不被篡改或伪造。
2 相关技术简介
学历学位认证系统结合了SpringBoot、MyBatis、微信小程序、MySQL和以太坊区块链等多种现代技术，为用户提供高效、安全的学历学位认证服务。后端采用SpringBoot框架构建，简化了开发过程并支持微服务架构，MyBatis则用于高效的数据库操作。数据存储方面使用MySQL，确保了系统的高效数据查询与处理。同时，前端通过微信小程序为用户提供简便的操作界面，用户无需额外下载应用即可实现学历证书的查询与认证。此外，系统集成了以太坊区块链技术，用于确保学历证书信息的不可篡改性和可信度，增加了认证的透明性与安全性。通过采用SpringMVC设计模式，系统实现了良好的模块化和可扩展性，确保了业务逻辑、数据访问和用户界面的清晰分离。
2.1微信小程序
微信小程序，这一轻量级的应用程序是在微信平台上运行的。用户无需进行下载安装，只需通过扫码或搜索功能即可轻松访问。并且当用户不再使用时直接关闭即可，不必卸载软件，实现了用完即走的理念[6]。这种应用程序不仅拥有独立的操作界面和完备的功能，还能够为用户提供一种接近于传统应用程序的交互体验。小程序巧妙地融合了传统网页的便捷访问性和原生应用的稳定性，展现出了快速启动、内存占用小等诸多优势，从而极大地提升了用户的使用体验。
微信小程序主要由三部分组成：使用WXML+WXSS作为小程序的界面层，主要用于实现小程序的静态页面和样式，其中WXML是类似于web中的HTML都是标记性语言，WXSS类似于web中的CSS作为样式语言，使用JavaScript实现交互和业务逻辑作为小程序的逻辑层，使用JSON文件作为小程序的配置文件[7]。
2.2 SpringBoot + MyBatis架构
SpringBoot是一个开源的Java开发框架，它简化了Spring应用程序的配置，支持快速开发和自动化配置。SpringBoot提供了一个开箱即用的开发环境，消除了繁琐的XML配置，使得开发者能够专注于业务逻辑的实现。它可以轻松集成其他框架和技术，如MyBatis和SpringMVC，从而提升系统的灵活性和可维护性。SpringBoot在系统中扮演着后端核心角色，处理所有的业务逻辑和请求。
MyBatis是一个持久层框架，用于简化数据库操作。与Hibernate相比，MyBatis允许开发者手动编写SQL语句，这样可以更好地控制查询效率和性能。它通过映射文件将Java对象与数据库记录进行关联，在与数据库交互时提供了更高的灵活性和性能优化空间。在系统中，MyBatis与SpringBoot结合使用，确保了数据的高效访问与处理。 
2.3 SpringMVC设计模式
SpringMVC是一种基于请求-响应模式的Web框架，它遵循经典的MVC（模型-视图-控制器）设计模式。SpringMVC通过分离模型（Model）、视图（View）和控制器（Controller）来管理复杂的Web应用程序，从而提高了代码的可维护性和可扩展性。控制器接收用户请求，并根据需求调用相关业务逻辑，最终将结果展示给用户。这种解耦的设计使得系统的各个模块可以独立开发和维护。
在本系统中，SpringMVC的应用使得后端的业务逻辑与用户界面高度分离，前端开发者无需关心后端业务实现细节，只需要根据接口文档调用API即可。SpringMVC还支持多种视图解析技术，能够为用户提供灵活的界面渲染方式，从而提高了前端用户体验。
2.4 MySQL
MySQL的数据库市场占有率排名第二，几年来一直保持平稳，如图2.1所示：

图2.1数据库语言市场占有率
MySQL是一个广泛使用的开源关系型数据库管理系统，它因其高性能、稳定性和易于使用的特点而成为许多应用的首选数据库。MySQL支持SQL标准，能够执行复杂的查询，并且提供了丰富的数据类型和查询优化功能，确保系统能够高效处理各种业务数据。在学历学位认证系统中，MySQL负责存储和管理大量的学历信息和认证记录，提供快速、稳定的数据查询和操作能力[8]。
通过使用MySQL，系统能够确保数据的完整性和一致性，并提供强大的事务处理能力。此外，MySQL也支持分布式存储和扩展，能够随着系统需求的增加进行横向扩展，保证系统的可扩展性和高可用性。
2.5 以太坊区块链
以太坊是一种开源的区块链平台，它为开发去中心化应用（DApps）提供了强大的支持。与比特币等区块链平台相比，以太坊不仅支持加密货币交易，还能够执行智能合约，提供去中心化的应用环境。在学历学位认证系统中，利用以太坊区块链技术可以确保学历证书信息的不可篡改性和透明性。每个学历证书在区块链上都有唯一的记录，任何尝试篡改或伪造证书的行为都会被系统自动记录[9]。
通过区块链技术，系统可以提供一种信任机制，消除了中介和人为操作的风险，确保学历信息的真实性和安全性。区块链的去中心化特性使得学历认证过程更加透明、公正，提升了用户对系统的信任度。随着区块链技术的发展，学历认证系统能够进一步提升数据的可信度，并确保其信息的长期安全存储。




























3 学历学位认证系统需求分析
在软件开发的全过程中，系统需求分析是极为关键的环节，它能够清晰界定所开发软件产品的功能范畴，并明确系统应当实现的具体操作。本章在深入分析用户需求以及当前市场上其他在线存储系统的特点后，对本学历学位认证系统进行了全面的需求分析。这个分析主要从系统概述、功能性需求、非功能性需求以及数据结构等多个维度进行了详尽的剖析和细化。
3.1 学历学位认证系统概述
本学历学位认证系统是一个基于SpringBoot、MyBatis、MySQL、微信小程序和以太坊区块链技术构建的综合平台，旨在为用户提供便捷、可信的学历证书查询与认证服务。本系统不仅通过传统的数据库管理学历数据，还利用区块链技术确保学历信息的不可篡改性和透明性。通过微信小程序，用户能够轻松进行学历证书查询与认证，系统同时保证了数据的安全性和操作的高效性。
3.2 学历学位认证系统功能性需求分析
本学历学位认证系统中的角色为用户、高校管理员、超级管理员。本节将运用文字阐述、用例描述和用例图等多种方式，对系统中的角色进行全面的需求分析。便于更精准地设计和开发系统，深入理解系统的需求和功能。
用户是系统的主要使用者，负责学历查询和证书认证。系统为用户提供简便的操作界面，确保其能够轻松获取所需信息和进行认证。用户端主要包括注册与登录、查询学历信息、提交学历学位认证申请、查看认证申请的相关信息、管理个人信息等模块。当用户首次使用小程序时用户可以选择使用微信登录或者手动输入信息注册到学历学位认证系统中。
高校管理员是系统中主要负责学历学位认证申请审核的角色。每个高校都设置管理员，系统根据学历学位认证申请的学校id分配该申请的审核任务，由高校管理员进行审核。
超级管理员是系统的最高权限角色，拥有系统所有功能的操作权限，负责系统的全局配置和高级管理。超级管理员能够进行系统的配置、管理角色和权限、查看详细的操作日志等。
系统用例图如图3.1所示。

图3.1系统用例图
1）用户登录用例场景分析。用户可以使用已有账户登录到小程序中。用户登录用例描述如表3.1所示，流程如图3.2-3.3所示。
表3.1 用户登录用例描述
用例名称	用户登录
参与者	用户、后台服务器、小程序端界面、数据库
前置条件	用户已经注册，用户信息已保存，数据库已经连接
主事件流	1. 进入小程序端登录界面
5. 验证通过后进入首页。
6. 用例结束
可选流程1	2. 用户在账号、密码输入框中输入个人账号、密码
3. 单击“完成”按钮
4. 系统向自己数据库和第三方的数据库验证用户信息
可选流程2	2. 用户点击微信一键登录
3. 弹出是否获取用户信息提示框
4. 用户同意获取信息
后置条件	登录成功的用户可以使用小程序端界面提供的各项服务功能。

图3.2用户微信一键登录系统流程图

图3.3用户普通登录系统流程图

2）用户注册用例场景分析。用户输入信息注册到学历学位认证系统中。用户注册用例描述如表3.2所示，流程如图3.4所示。
表3.2 用户注册用例描述
用例名称	用户注册
参与者	用户、后台服务器、小程序端界面、数据库
前置条件	用户未注册，用户信息不重复，数据库已经连接，填入信息正确
主事件流	1. 进入小程序端注册界面
2. 用户在输入框中输入个人账号、密码、二次密码、手机号和邮箱
3. 单击“完成”按钮
4. 系统向自己数据库和第三方的数据库验证用户信息，验证成功后添加用户信息
5. 验证通过后进入小程序端首页
6. 用例结束 
后置条件	注册成功的用户可以使用小程序端界面提供的各项服务功能。

图3.4用户注册系统流程图
3）搜索用例场景分析。用户可以输入姓名或身份证号查询认证进度。用户搜索用例描述如表3.3所示，流程如图3.5所示。
表3.3 搜索用例描述
用例名称	用户搜索
参与者	用户、小程序端界面
前置条件	用户登入到小程序中
主事件流	1. 用户点击顶部搜索栏
2. 输入姓名或身份证号
3. 系统根据输入信息，匹配认证信息
4. 将相关认证信息展示给用户
5. 用例结束 
后置条件	用户获取到搜索结果

图3.5用户搜索流程图
4）提交学历学位认证申请用例场景分析。用户可以提交相关信息进行学历学位认证申请，申请信息会存储到数据库中交由管理员审核。提交学历学位认证申请用例描述如表3.4所示，流程如图3.6所示。
表3.4 提交学历学位认证申请用例描述
用例名称	用户提交学历学位认证申请
参与者	用户、后台服务器、小程序端界面、数据库
前置条件	用户已登录
主事件流	1. 用户输入基本信息
2. 用户输入学历信息
3. 用户上传证书材料
4. 点击“提交申请”按钮
5. 用户的学历学位申请信息存入数据库
6. 信息上链，生成哈希值
7. 用例完成
后置条件	用户可以在该页面完成学历学位认证申请的提交

图3.6学历学位认证申请流程图
5）删除学历学位认证申请用例场景分析。用户可以删除学历学位认证申请。删除学历学位认证申请用例描述如表3.5所示，流程如图3.7所示。
表3.5 删除学历学位认证申请用例描述
用例名称	用户删除学历学位认证申请
参与者	用户、后台服务器、微信小程序端界面、数据库
前置条件	用户已登录
主事件流	1. 用户选择要删除的学历学位认证申请
2. 点击“删除”按钮
3. 弹出提示框，提示是否删除文件
4. 用户选择否，学历学位认证申请保留
5. 用户选择是，学历学位认证申请删除，并刷新页面
6. 信息上链，生成哈希值
7. 用例完成
后置条件	用户可以在该页面将学历学位认证申请删除

图3.7删除学历学位认证申请流程图
6）区块查询用例场景分析。用户通过哈希值进行区块查询。区块查询用例描述如表3.6所示，流程如图3.8所示。
表3.6 区块查询用例描述
用例名称	区块查询
参与者	用户、后台服务器、小程序端界面、数据库
前置条件	用户已登录，进入区块查询界面
主事件流	1. 进入区块查询页面，输入要查询的区块哈希或认证编号
2. 点击“查询”按钮
3. 弹出区块链存证信息页面
4. 点击“关闭”按钮，完成信息查询
5. 用例结束 
后置条件	用户可以在区块查询页面查询区块链存证信息

图3.8区块查询流程图
7）编辑资料用例场景分析。在个人信息界面用户可以编辑个人资料，可以修改昵称、手机号、邮箱信息。编辑资料用例描述如表3.7所示，流程如图3.9所示。
表3.7 编辑资料用例描述
用例名称	编辑资料
参与者	用户、后台服务器、小程序端界面、数据库
前置条件	用户已登录，进入个人信息页面
主事件流	1.点击“编辑信息”按钮
2.编辑昵称、手机号、邮箱信息
5. 点击“保存”按钮，同步信息至数据库
6. 用例结束
可选流程3	3. 点击“取消”按钮
4. 返回个人信息页面
后置条件	用户可以在个人信息页面查看修改后的信息

图3.9编辑资料流程图
3.3 学历学位认证系统非功能性需求分析
非功能性需求在系统设计中至关重要，因为它们决定了系统的整体表现、可维护性、安全性和用户体验。与功能性需求关注系统实现的“做什么”不同，非功能性需求关注系统如何“做得更好”，如响应速度、可扩展性、可用性、性能、可靠性等。这些需求确保系统在高负载、复杂环境或长期使用中的稳定性和效率，避免了因性能瓶颈或安全漏洞而导致的系统崩溃或数据泄露。因此，非功能性需求的满足是系统长期成功和用户满意度的关键。
系统非功能性需求分析包括以下三点：
（1）在设计学历学位认证系统时，非功能性需求的分析至关重要，特别是与以太坊区块链的结合。首先，系统需要具有高可用性和高容错性，以确保在任何情况下，用户的认证请求能够顺利提交并得到处理。以太坊区块链能够提供去中心化和分布式的数据存储，使得认证数据在全球范围内可用且持久，这有效避免了单点故障的风险。
（2）系统需要具备高性能，能够在高并发的情况下快速响应用户的认证请求。区块链的智能合约和加密机制虽然提供了数据的安全性，但由于区块链网络的交易处理时间，系统需要合理优化认证过程。以太坊的Layer 2解决方案（如Optimistic Rollups）可作为提高性能的有效手段，减少交易的确认时间，确保系统在高峰期的稳定运行[10]。
（3）安全性是学历学位认证系统的核心要求。通过将认证请求和结果信息上链，所有数据能够得到不可篡改的记录，防止伪造和篡改，提升认证的可信度。同时，利用以太坊的公私钥加密机制，可以确保用户身份信息的隐私保护和认证过程的安全性[11]。系统应实现合适的访问控制和数据加密措施，以确保只有授权用户可以访问或修改敏感数据。
3.4 学历学位认证系统数据结构需求分析
本系统确保数据库架构的合理性，首先对系统的数据结构进行深入分析。根据上文对用户端功能的需求分析，将对系统所需的实体进行详细的分析，包括它们的属性、彼此之间的关系以及行为模式等。分析结果将以实体-关系（E-R）图来直观展现，为之后的数据结构设计奠定基础。学历学位认证系统E-R图如图3.10所示。

图3.10系统E-R图


4 学历学位认证系统设计
通过对学历学位认证系统的功能性需求、非功能性需求以及数据结构需求的详细分析。本章将对学历学位认证系统进行全面的设计，主要分为系统架构设计、系统功能结构设计、系统数据结构设计以及系统对象模型设计四个模块。
4.1 学历学位认证系统架构设计
学历学位认证系统采用了现代化的技术架构，结合了MySQL、MyBatis、Spring Boot、Spring MVC、微信小程序和以太坊区块链等技术。系统的前端通过微信小程序与用户进行交互，提供便捷的用户体验。后端使用Spring Boot和Spring MVC框架，负责请求处理和业务逻辑的管理。数据层采用MyBatis与MySQL数据库进行高效的数据存取和管理[12]。系统还结合了以太坊区块链技术，通过智能合约确保关键数据的不可篡改性和透明性，提升了数据的安全性与一致性。整体架构充分利用了这些技术的优势，保证了系统的高效性、可扩展性和安全性。学历学位认证系统架构图如图4.1所示。

图4.1 学历学位认证系统架构图
本系统的架构设计是一个典型的Web应用架构，结合了当下流行的分层架构体系和区块链技术，分层架构体系是指将软件系统划分成多个层次，每个层次实现特定的功能，各层次之间通过规定的接口进行通信。如下几点是本系统的架构设计：
（1）访问层
学历学位认证系统的前端是微信小程序端。用户可以进入小程序进行学历学位认证的申请以及查看。管理员可以通过微信小程序对收到的学历学位认证申请进行审批、管理及统计。
（2）视图层
视图层的作用主要是为用户提供直观、易用的界面展示，以便用户能够方便地查看和理解数据。一个优秀的视图层设计应当能够实现动态交互、良好的界面设计以及丰富的功能。微信小程序界面一个完整的页面由4个文件组成，分别以js，json，wxml，wxss为后缀，其中js文件负责页面的逻辑结构，微信小程序在逻辑层将数据进行处理然后发送给视图层，同时接受视图层的事件反馈，json文件用于配置小程序的全局设置和页面的设置，它控制小程序的路由、窗口表现、样式、网络请求等，wxml文件用于描述小程序的结构，它是小程序的标记语言，定义了页面的结构和内容，wxss文件用于描述页面的样式，定义了页面的布局、颜色、字体等外观样式。
（3）交互层
交互层采用了微信官方提供的wx.request API 对后端服务器发起异步请求获取数据并展示给前端用户。wx.request 是微信小程序中用于发起网络请求的 API，可以用来与服务器进行数据交换。通过 wx.request，开发者可以发送 GET、POST 等请求，获取数据或提交数据到服务器，它支持设置请求头、请求方式、参数传递、响应处理等功能，并能够处理请求成功和失败的回调，可以用于实现数据加载、表单提交等功能。
（4）控制层
在采用了 MVC（Model-View-Controller）设计模式的项目中，Controller 层负责处理用户的输入请求，并决定如何响应这些请求[13]。Controller 层连接 View（视图层） 和 Model（模型层），接受用户输入并更新模型或视图。Controller层调用模型的业务逻辑，并根据模型的更新来刷新视图，主要用于接收用户的操作，然后通过调用模型层来处理数据，最终决定更新视图层的内容或展示信息。
（5）业务逻辑层
在采用了 MVC（Model-View-Controller）设计模式的项目中，Service 层位于 Controller 层和 Model 层之间，负责封装业务逻辑。Service 层提供了对外的接口供 Controller 层调用，以处理业务逻辑、数据验证、事务管理等复杂操作。Service 层处理的是一些具体的业务规则和逻辑计算，Controller 层调用 Service 层来实现特定功能，Service 层将结果返回给 Controller层，然后Controller层更新视图。
（6）区块链层
区块链层利用VMware虚拟机的隔离环境搭建了以太坊区块链，使用Ubuntu作为操作系统支持以太坊节点的运行，并将Solidity编写的智能合约被部署在以太坊网络上，通过Webase平台进行管理和监控[14]。这种架构保证了区块链应用的高效、安全和可管理性，同时利用以太坊的去中心化特性和Webase的便利性来简化开发和运营流程。
4.2 学历学位认证系统功能结构设计
基于对学历学位认证系统的需求分析，设计了系统中用户端的功能模块。用户端功能模块图如图4.2所示。

图4.2 用户端功能模块图
a)用户登录：用户可以使用账号密码登录或者微信一键登录。
b)用户注册：用户可以在注册页面输入个人信息注册账户。
c)创建学历学位认证申请：用户可以填写相关信息提交学历学位认证申请。
d)修改学历学位认证申请：用户可以修改已提交未审核的学历学位认证申请的内容。
e)删除学历学位认证申请：用户可以删除学历学位认证申请。
f)搜索学历学位认证申请：用户可以填写相关信息搜索学历学位认证申请。
g)区块存证：用户可以根据区块哈希值搜索区块存证信息。
4.3 学历学位认证系统数据库设计
学历学位认证系统数据库设计包括数据库设计概述、数据库表结构设计。良好的数据库设计可以给系统带来明确的数据统计与详细分析。
4.3.1 数据库设计概述
本系统使用MySQL作为数据库管理系统是非常合适的。MySQL具备高性能、支持高并发、高一致性和数据完整性，能够处理大量的认证请求和结果存储。作为关系型数据库，它能够有效管理学校、用户和认证请求之间的关系，确保数据一致性并降低冗余[15]。MySQL还提供灵活的扩展性和高可用性，支持主从复制、自动故障转移等功能，确保系统的稳定性和数据安全性。此外，MySQL具有成熟的生态系统、广泛的社区支持和高安全性，是一个经济实惠且可靠的选择。
4.3.2 数据库表结构设计
设计一个好的数据库表结构能够确保数据的准确性、一致性和安全性，提高系统的性能和可扩展性，从而有效地支持业务流程，降低维护成本[16]。
数据库表结构设计关键步骤如下：
（1）需求分析：通过深入调查处理对象，在设计数据库表之前，首先要对系统的需求进行详细分析，明确系统需要存储哪些数据，数据之间的关系是什么，业务流程是怎样的，与项目相关的各个方面（如用户、认证请求、学历信息等）都要充分理解，确保数据表的设计能够完整、准确地支持业务需求。 
（2）实体设计：首先，根据需求分析，确定系统中需要的实体（如用户、学校、认证请求等）。每个实体通常对应数据库中的一张表，每个实体都应具备明确的属性，确定实体、实体之间的联系以及实体类型，最终形成E-R图。
（3）设计表结构：首先进行字段选择，确定每张表的字段，包括每个字段的数据类型、长度等。然后对字段进行命名，字段名称应具备一定的语义，能够清晰地表达字段的含义。最后对字段进行约束：根据需求确定字段的约束条件，如“NOT NULL”（不能为空）、“UNIQUE”（唯一）等。
（4）确定主键和外键：首先，每张表都应该有一个唯一标识的主键，确保数据的唯一性和表的完整性，其次确定表与表之间的关联关系，并通过外键来实现，外键约束有助于维护数据的完整性和一致性，避免无效的引用。
（5）运行与维护：试运行后，如果数据库通过基本测试，则代表了数据库开发基本完成，同时对数据库设计实施维护和修改操作，是一个长期任务。
在数据库设计中，其他需要考虑的因素如下三点：
（1）数据冗余和一致性：在设计数据库时，尽量避免冗余数据的出现，以减少存储空间的浪费和数据维护的复杂度。冗余数据不仅会导致存储空间的浪费，还可能引发数据一致性问题[17]。同时，数据一致性也是一个关键问题，设计时需要确保不同表之间的关系能够保证数据的准确性和一致性。

（2）安全性：设计时要考虑数据库的安全性，如用户权限管理、访问控制策略等，确保只有授权用户可以访问敏感数据。
（3）跨平台兼容性：如果数据库需要在多个平台上运行，那么在设计时要考虑到数据库的跨平台兼容性问题。
下面列出本系统数据库设计的主要数据表结构。
用户信息表结构如表4.1所示。
表4.1 用户信息表（Users）
序号	字段	描述	类型和长度	键引用	是否为空	默认值
1	user_id	用户id	INT	主键	否	无
2	username	登录名	VARCHAR(255)		否	无
3	password	用户密码	VARCHAR(255)		否	无
4	email	用户邮箱	VARCHAR(255)		否	无
5	phone	用户电话	VARCHAR(255)		否	无
6	avatar_url	用户头像的URL	VARCHAR(255)		是	无
7	registration_time	注册时间	TIMESTAMP		是	当前时间
8	last_login_time	最后一次登录时间	TIMESTAMP		是	无
9	status	用户状态	ENUM		否	‘active’
学校信息表结构如表4.2所示。
表4.2 学校信息表（Schools）
序号	字段	描述	类型和长度	键引用	是否为空	默认值
1	school_id	学校id	INT	主键	否	无
2	name	学校名称	VARCHAR(255)		否	无
3	address	学校地址	VARCHAR(255)		否	无
4	contact_info	联系信息	VARCHAR(255)		否	无
5	major_list	专业列表	TEXT		是	无
6	created_at	创建时间	TIMESTAMP		是	当前时间
认证申请信息表结构如表4.3所示。
表4.3 认证申请信息表（Authentication_Requests）
序号	字段	描述	类型和长度	键引用	是否为空	默认值
1	request_id	认证请求id	INT	主键	否	无
2	user_id	用户id	INT	外键	否	无
3	school_id	学校id	INT	外键	否	无
4	degree	学位类型	VARCHAR(100)		是	无
5	major	专业	VARCHAR(100)		是	无
6	graduation_year	毕业年份	INT		是	无
7	certificate_url	学历证书文件	VARCHAR(255)		是	无
8	transcript_url	成绩单文件	VARCHAR(255)		是	无
9	status	认证请求状态	ENUM		否	无
10	blockchain_hash	区块链哈希值	VARCHAR(255)		是	无
11	submission_time	请求提交时间	TIMESTAMP		是	当前时间
区块链记录表结构如表4.4所示。
表4.4 区块链记录表（Blockchain_Records）
序号	字段	描述	类型和长度	键引用	是否为空	默认值
1	record_id	记录id	INT	主键	否	无
2	record_hash	区块链哈希	VARCHAR(255)		是	无
3	record_type	记录类型	ENUM		否	无
4	record_details	详细信息	TEXT		是	无
5	record_time	记录时间	TIMESTAMP		是	无
4.4 学历学位认证系统对象模型设计
在软件系统的设计与开发过程中，UML图表中的系统类图发挥着至关重要的作用[18]。通过详尽地展示系统中各类之间的结构联系及其在系统内的功能角色，它极大地助力了开发者对系统设计、开发和测试的全面规划。根据第三章学历学位认证系统的数据结构分析设计系统的实体类图如图4.3所示。

图4.3 系统实体类图


5 学历学位认证系统实现
经过系统详细设计之后，本章的核心内容是讲解系统设计方案如何被转化为实际运行的程序代码。在这一过程中，需要将系统设计方案的各个组成部分逐一细化为具体的代码，随后进行必要的调试和测试工作，以确保系统能够符合预期的功能设定，并满足性能上的各项标准[19]。
5.1 用户端功能模块实现
用户功能模块分为：注册模块、登录模块、学历学位认证模块、区块存证模块。
5.1.1 用户注册功能实现
系统提供了用户注册功能，以便新用户能够轻松加入到小程序中。当用户首次进入小程序时，可以点击进入注册页面，简洁明了的界面设计使得用户能够一步到位地完成注册流程。用户只需按照提示，输入账号、密码、用户名、手机号以及邮箱，这些信息将被安全地传输到后台系统。用户注册页面如图5.1所示。

图5.1 用户注册页面
注册页面设计代码如下：
 <view class="container">
  <view class="register-box">
    <view class="title">用户注册</view>
    
    <view class="register-form">
      <input class="input" placeholder="请输入用户名" bindinput="handleInput" data-field="username" value="{{username}}" />
      <input class="input" placeholder="请输入密码" password="true" bindinput="handleInput" data-field="password" value="{{password}}" />
      <input class="input" placeholder="请确认密码" password="true" bindinput="handleInput" data-field="confirmPassword" value="{{confirmPassword}}" />
      <input class="input" placeholder="请输入邮箱" bindinput="handleInput" data-field="email" value="{{email}}" />
      <input class="input" placeholder="请输入手机号" bindinput="handleInput" data-field="phone" value="{{phone}}" />
      
      <button class="btn" bindtap="handleRegister">注册</button>
      <button class="btn" bindtap="handleBack">返回登录</button>
    </view>
  </view>
</view> 
这段代码包含了一个注册表单，其中包括五个输入框（用户名、密码、确认密码、邮箱和手机号），每个输入框都有对应的占位符和数据绑定，通过 bindinput事件来实时更新数据。用户点击“注册”按钮时，会触发 handleRegister方法进行注册操作；点击“返回登录”按钮时，会触发 handleBack方法返回登录页面。整体结构简洁，适用于基本的用户注册功能。
注册页面核心代码如下：
Page({
  data: {
    username: '',
    password: '',
    confirmPassword: '',
    email: '',
    phone: ''  },
  // 处理注册
  async handleRegister() {
    // 表单验证
    if (!this.data.username || !this.data.password || !this.data.confirmPassword) {
      wx.showToast({
        title: '请填写完整信息',
        icon: 'none'
      })
      return
    }
    if (this.data.password !== this.data.confirmPassword) {
      wx.showToast({
        title: '两次输入的密码不一致',
        icon: 'none'
      })
      return
    }
    try {
      const requestData = {
        username: this.data.username.trim(),
        password: this.data.password,
        email: this.data.email ? this.data.email.trim() : '',
        phone: this.data.phone ? this.data.phone.trim() : ''
      }
      console.log('注册请求URL:', `${app.globalData.baseUrl}/api/user/register`)
      console.log('注册请求数据:', requestData)
      const res = await new Promise((resolve, reject) => {
        wx.request({
          url: `${app.globalData.baseUrl}/api/user/register`,
          method: 'POST',
          header: {
            'content-type': 'application/json'
          },
          data: requestData,
          success: (res) => {
            console.log('注册响应成功:', res)
            resolve(res)
          },
          fail: (err) => {
            console.error('注册请求失败:', err)
            reject(err)
          },
          complete: () => {
            console.log('注册请求完成')
          }
        })
      })
这段代码包含了处理用户输入、表单验证、发送注册请求、显示提示信息以及处理错误的功能。用户输入的信息（用户名、密码、确认密码、邮箱、手机号）会通过 handleInput方法更新到页面的 data中。注册时，handleRegister方法会先进行必要的验证，如检查必填项和密码是否一致。如果验证通过，程序会发送一个 POST 请求到指定的接口，提交用户数据，注册成功后会弹出提示并返回登录页面。如果出现错误，系统会显示相应的错误信息或网络错误提示。
5.1.2 用户登录功能实现
注册成功之后，用户可以在登录界面输入账号密码登录到小程序中，也可以选择点击下方的微信小图标进行微信快捷登录。用户登录页面如图5.2和图5.3所示。
 
图5.2 用户登录页面             图5.3 微信一键登录页面
登录页面设计代码如下：
<view class="container">
  <view class="login-box">
    <view class="title">学历认证系统</view>
    
    <!-- 账号密码登录 -->
    <view class="login-form" wx:if="{{loginType === 'account'}}">
      <input class="input" placeholder="请输入用户名" model:value="{{username}}" />
      <input class="input" placeholder="请输入密码" password="true" model:value="{{password}}" />
      <button class="btn" bindtap="handleLogin">登录</button>
      <button class="btn" bindtap="handleRegister">注册</button>
    </view>

    <!-- 微信登录 -->
    <view class="wechat-login" wx:if="{{loginType === 'wechat'}}">
      <button class="btn wechat-btn" open-type="getUserInfo" bindgetuserinfo="handleWechatLogin">
        微信一键登录
      </button>
    </view>

    <!-- 切换登录方式 -->
    <view class="switch-login">
      <text bindtap="switchLoginType">
        {{loginType === 'account' ? '使用微信登录' : '使用账号密码登录'}}
      </text>
    </view>
  </view>
</view> 
这段代码使用了wx:if来根据loginType的值动态切换登录方式。如果 loginType是'account'，则显示账号密码登录表单，包括用户名和密码输入框及登录和注册按钮；如果是'wechat'，则显示微信一键登录按钮。用户可以通过点击 switchLoginType切换登录方式，界面上的文字会根据当前登录方式进行相应的变化。整体界面采用了简单的布局，提供了两种登录方式的选择。
登录页面核心相关代码如下：
const app = getApp()

Page({
  data: {
    loginType: 'account', // 'account' 或 'wechat'
    username: '',
    password: ''
  },
  // 切换登录方式
  switchLoginType() {
    this.setData({
      loginType: this.data.loginType === 'account' ? 'wechat' : 'account'
    })
  },
  // 账号密码登录
  async handleLogin() {
    if (!this.data.username || !this.data.password) {
      wx.showToast({
        title: '请输入用户名和密码',
        icon: 'none'
      })
      return
    }
    try {
      const res = await wx.request({
        url: `${app.globalData.baseUrl}/api/user/login`,
        method: 'POST',
        data: {
          username: this.data.username,
          password: this.data.password
        }
      })
      if (res.data.success) {
        // 保存用户信息
        wx.setStorageSync('userInfo', res.data.user)
        wx.showToast({
          title: '登录成功',
          icon: 'success'
        })
        // 跳转到首页
        wx.switchTab({
          url: '/pages/index/index'
        })
      } else {
        wx.showToast({
          title: res.data.message || '登录失败',
          icon: 'none'
        })
      }
    } catch (error) {
      wx.showToast({
        title: '网络错误，请稍后重试',
        icon: 'none'
      })
    }
  },
  // 微信登录
  async handleWechatLogin(e) {
    if (e.detail.userInfo) {
      try {
        // 获取微信登录凭证
        const { code } = await wx.login()
        
        const res = await wx.request({
          url: `${app.globalData.baseUrl}/api/user/wechat-login`,
          method: 'POST',
          data: {
            code: code
          }
        })
        if (res.data) {
          // 保存用户信息
          wx.setStorageSync('userInfo', res.data)
          wx.showToast({
            title: '登录成功',
            icon: 'success'
          })
          // 跳转到首页
          wx.switchTab({
            url: '/pages/index/index'
          })
        }
      } catch (error) {
        wx.showToast({
          title: '登录失败，请稍后重试',
          icon: 'none'
        })
      }
    }
  },

  // 跳转到注册页面
  handleRegister() {
    wx.navigateTo({
      url: '/pages/register/register'
    })
  }
}) 
这段代码支持两种登录方式：账号密码登录和微信登录。用户可以通过点击按钮切换登录方式。账号密码登录时，检查用户输入的用户名和密码，发送请求到后台进行验证，成功后保存用户信息并跳转到首页；微信登录时，通过wx.login获取登录凭证并发送请求验证，验证成功后保存用户信息并跳转到首页。还提供了跳转到注册页面的功能。
5.1.3 我的页面功能实现
用户登录之后，首先进入的是我的页面，该页面会展示用户信息。图片页面如图5.4所示。

图5.4 我的页面
我的页面设计代码如下：
<view class="container">
  <!-- 用户信息卡片 -->
  <view class="user-card" bindtap="showProfileDetail">
    <view class="avatar-container">
      <image class="avatar" src="/images/default-avatar.png" />
    </view>
    <view class="user-info">
      <text class="nickname">张三</text>
      <text class="user-id">身份证：110101199003078888</text>
    </view>
  </view>
  <!-- 功能菜单 -->
  <view class="menu-list">
    <view class="menu-group">
      <view class="menu-item" bindtap="navigateToApplications">
        <text class="menu-icon">📝</text>
        <text>认证申请</text>
      </view>
      <view class="menu-item" bindtap="navigateToRecords">
        <text class="menu-icon">📋</text>
        <text>认证记录</text>
      </view>
    </view>
    <view class="menu-group">
      <view class="menu-item" bindtap="handleEditProfile">
        <text class="menu-icon">✏️</text>
        <text>编辑资料</text>
      </view>
      <view class="menu-item" bindtap="handleChangePassword">
        <text class="menu-icon">🔒</text>
        <text>修改密码</text>
      </view>
    </view>
  </view>
  <!-- 退出登录按钮 -->
  <view class="logout-btn" bindtap="handleLogout">
    退出登录
  </view>
  <!-- 编辑资料弹窗 -->
  <view wx:if="{{showEditProfile}}" class="modal-mask">
    <view class="modal-content">
      <view class="modal-header">编辑资料</view>
      <view class="modal-body">
        <input class="modal-input" placeholder="昵称" value="{{editProfile.nickName}}" bindinput="onEditNickName" />
        <input class="modal-input" placeholder="手机号" value="{{editProfile.phone}}" bindinput="onEditPhone" />
        <input class="modal-input" placeholder="邮箱" value="{{editProfile.email}}" bindinput="onEditEmail" />
      </view>
      <view class="modal-footer">
        <button class="modal-btn" bindtap="onSaveProfile">保存</button>
        <button class="modal-btn cancel" bindtap="onCancelEditProfile">取消</button>
      </view>
    </view>
  </view>
  <!-- 修改密码弹窗 -->
  <view wx:if="{{showChangePassword}}" class="modal-mask">
    <view class="modal-content">
      <view class="modal-header">修改密码</view>
      <view class="modal-body">
        <input class="modal-input" password placeholder="原密码" value="{{changePassword.oldPwd}}" bindinput="onEditOldPwd" />
        <input class="modal-input" password placeholder="新密码" value="{{changePassword.newPwd}}" bindinput="onEditNewPwd" />
        <input class="modal-input" password placeholder="确认新密码" value="{{changePassword.confirmPwd}}" bindinput="onEditConfirmPwd" />
      </view>
      <view class="modal-footer">
        <button class="modal-btn" bindtap="onSavePassword">保存</button>
        <button class="modal-btn cancel" bindtap="onCancelChangePassword">取消</button>
      </view>
    </view>
  </view>

  <!-- 个人信息弹窗 -->
  <view wx:if="{{showProfileDetail}}" class="modal-mask">
    <view class="modal-content">
      <view class="modal-header">个人信息</view>
      <view class="modal-body">
        <view class="profile-row"><text>昵称：</text><text>{{userInfo.nickName}}</text></view>
        <view class="profile-row"><text>手机号：</text><text>{{userInfo.phone}}</text></view>
        <view class="profile-row"><text>邮箱：</text><text>{{userInfo.email}}</text></view>
        <view class="profile-row"><text>身份证：</text><text>{{userInfo.idCard}}</text></view>
      </view>
      <view class="modal-footer">
        <button class="modal-btn" bindtap="onCloseProfileDetail">关闭</button>
      </view>
    </view>
  </view>
</view> 

这段代码定义了一个用户个人信息管理界面的结构，主要包括用户信息卡片、功能菜单、以及多个弹窗（如编辑资料、修改密码、查看个人信息等）。界面布局采用了多个view组件进行模块化，每个模块通过bindtap事件与相应的函数进行交互。用户可以查看和编辑个人信息、修改密码、查看认证申请记录等功能，界面交互流畅且方便操作。此外，利用wx:if条件渲染实现了弹窗的显示与隐藏，提高了页面的动态交互性，涉及到的函数包括：showProfileDetail（显示个人信息详情）、navigateToApplications（跳转到认证申请页面）、navigateToRecords（跳转到认证记录页面）、handleEditProfile（处理编辑资料操作）、handleChangePassword（处理修改密码操作）、handleLogout（处理退出登录操作）、onEditNickName（处理编辑昵称输入）、onEditPhone（处理编辑手机号输入）、onEditEmail（处理编辑邮箱输入）、onSaveProfile（保存编辑的个人资料）、onCancelEditProfile（取消编辑个人资料）、onEditOldPwd（处理输入的旧密码）、onEditNewPwd（处理输入的新密码）、onEditConfirmPwd（处理确认新密码输入）、onSavePassword（保存修改的密码）、onCancelChangePassword（取消修改密码操作）和onCloseProfileDetail（关闭个人信息详情弹窗）。
我的页面核心代码如下：
// 退出登录
  handleLogout: function() {
    wx.showModal({
      title: '提示',
      content: '确定要退出登录吗？',
      success: (res) => {
        if (res.confirm) {
          this.setData({
            userInfo: {},
            showEditProfile: false,
            showChangePassword: false,
            showProfileDetail: false
          })
          wx.showToast({
            title: '已退出登录',
            icon: 'success'
          })
          // 跳转到登录页（模拟）
          setTimeout(() => {
            wx.redirectTo({ url: '/pages/login/login' })
          }, 800)
        }
      }
    })
  },

  // 编辑资料
  handleEditProfile: function() {
    this.setData({
      showEditProfile: true,
      editProfile: {
        nickName: this.data.userInfo.nickName,
        phone: this.data.userInfo.phone,
        email: this.data.userInfo.email
      }
    })
  },
  onEditNickName(e) {
    this.setData({ 'editProfile.nickName': e.detail.value })
  },
  onEditPhone(e) {
    this.setData({ 'editProfile.phone': e.detail.value })
  },
  onEditEmail(e) {
    this.setData({ 'editProfile.email': e.detail.value })
  },
  onSaveProfile() {
    this.setData({
      userInfo: {
        ...this.data.userInfo,
        nickName: this.data.editProfile.nickName,
        phone: this.data.editProfile.phone,
        email: this.data.editProfile.email
      },
      showEditProfile: false
    })
    wx.showToast({ title: '保存成功', icon: 'success' })
  },
  onCancelEditProfile() {
    this.setData({ showEditProfile: false })
  },

  // 修改密码
  handleChangePassword: function() {
    this.setData({
      showChangePassword: true,
      changePassword: { oldPwd: '', newPwd: '', confirmPwd: '' }
    })
  },
  onEditOldPwd(e) {
    this.setData({ 'changePassword.oldPwd': e.detail.value })
  },
  onEditNewPwd(e) {
    this.setData({ 'changePassword.newPwd': e.detail.value })
  },
  onEditConfirmPwd(e) {
    this.setData({ 'changePassword.confirmPwd': e.detail.value })
  },
  onSavePassword() {
    const { oldPwd, newPwd, confirmPwd } = this.data.changePassword
    if (!oldPwd || !newPwd || !confirmPwd) {
      wx.showToast({ title: '请填写完整', icon: 'none' })
      return
    }
    if (newPwd !== confirmPwd) {
      wx.showToast({ title: '两次新密码不一致', icon: 'none' })
      return
    }
    this.setData({ showChangePassword: false })
    wx.showToast({ title: '修改成功', icon: 'success' })
  },
  onCancelChangePassword() {
    this.setData({ showChangePassword: false })
  },

  // 个人信息弹窗
  showProfileDetail() {
    this.setData({ showProfileDetail: true })
  },
  onCloseProfileDetail() {
    this.setData({ showProfileDetail: false })
  },

  // 认证申请
  navigateToApplications: function() {
    wx.navigateTo({ url: '/pages/applications/applications' })
  },
  // 认证记录
  navigateToRecords: function() {
    wx.navigateTo({ url: '/pages/applications/applications?tab=records' })
  }
这段代码实现了一个完整的用户个人信息管理模块，包括退出登录、编辑资料、修改密码、查看个人信息等功能。用户可以通过确认弹窗退出登录，退出后清空个人信息并跳转到登录页面；通过编辑资料界面修改昵称、电话和邮箱，保存修改或取消编辑；修改密码时，要求用户填写旧密码、新密码和确认密码，确保新密码一致并完成修改；此外，用户可以查看和关闭个人信息弹窗，并可跳转到认证申请和认证记录页面。所有操作通过setData更新状态，使用wx.showToast反馈操作结果，提供了一个流畅的用户体验。
5.1.4 提交学历学位认证信息功能
用户登录之后，可以进行学历学位认证信息的提交及查看，页面如图5.5(a)-(d)所示。
  
图(a) 学历学位认证页面       图(b) 学历学位认证页面
 
图(c) 学历学位认证页面        图(d) 学历学位认证页面
                            图5.5 学历学位认证页面
学历学位认证功能设计代码如下：
<view class="container">
  <view class="tab-header">
    <view class="tab-item {{activeTab === 'apply' ? 'active' : ''}}" bindtap="switchTab" data-tab="apply">
      <text>认证申请</text>
    </view>
    <view class="tab-item {{activeTab === 'records' ? 'active' : ''}}" bindtap="switchTab" data-tab="records">
      <text>认证记录</text>
    </view>
  </view>
  <!-- 认证申请表单 -->
  <view class="form-container" wx:if="{{activeTab === 'apply'}}">
    <view class="form-title">学历认证申请</view>
    <form bindsubmit="submitApplication">
      <view class="form-group">
        <view class="form-label">基本信息</view>
        
      </view>
      <view class="form-group">
        <view class="form-label">学历信息</view>
        <view class="form-item">
          <text class="label">学校名称</text>
          <input name="school" placeholder="请输入毕业院校" />
        </view>
        <view class="form-item">
          <text class="label">学历层次</text>
          <picker name="degree" mode="selector" range="{{degreeTypes}}" bindchange="bindDegreeChange">
            <view class="picker">{{degreeTypes[degreeIndex] || '请选择学历层次'}}</view>
          </picker>
        </view>
        <view class="form-item">
          <text class="label">专业名称</text>
          <input name="major" placeholder="请输入专业名称" />
        </view>
        <view class="form-item">
          <text class="label">入学时间</text>
          <picker name="enrollmentDate" mode="date" bindchange="bindEnrollmentDateChange">
            <view class="picker">{{enrollmentDate || '请选择入学时间'}}</view>
          </picker>
        </view>
        <view class="form-item">
          <text class="label">毕业时间</text>
          <picker name="graduationDate" mode="date" bindchange="bindGraduationDateChange">
            <view class="picker">{{graduationDate || '请选择毕业时间'}}</view>
          </picker>
        </view>
      </view>
      <view class="form-group">
        <view class="form-label">上传材料</view>
        <view class="upload-section">
          <view class="upload-item">
            <text class="label">毕业证书</text>
            <view class="upload-box" bindtap="uploadDiploma">
              <image wx:if="{{diplomaImage}}" src="{{diplomaImage}}" mode="aspectFill"></image>
              <text wx:else>点击上传</text>
            </view>
          </view>
          <view class="upload-item">
            <text class="label">学位证书</text>
            <view class="upload-box" bindtap="uploadDegree">
              <image wx:if="{{degreeImage}}" src="{{degreeImage}}" mode="aspectFill"></image>
              <text wx:else>点击上传</text>
            </view>
          </view>
        </view>
      </view>
      <button class="submit-btn" form-type="submit">提交申请</button>
    </form>
  </view>
  <!-- 认证记录列表 -->
  <view class="records-container" wx:if="{{activeTab === 'records'}}">
    <view class="record-list">
      <view class="record-item" wx:for="{{records}}" wx:key="id" bindtap="showRecordDetail" data-id="{{item.id}}">
        <view class="record-header">
          <text class="record-title">{{item.school}}</text>
          <text class="record-status {{item.status === '已认证' ? 'success' : item.status === '认证中' ? 'pending' : 'failed'}}">{{item.status}}</text>
        </view>
        <view class="record-info">
          <text class="info-item">{{item.degree}} - {{item.major}}</text>
          <text class="info-item">申请时间：{{item.applyTime}}</text>
        </view>
        <view class="record-footer">
          <text class="block-hash">区块链存证：{{item.blockHash}}</text>
        </view>
      </view>
    </view>
  </view>
  <!-- 记录详情弹窗 -->
  <view class="record-detail-modal" wx:if="{{showDetail}}">
    <view class="modal-mask" bindtap="hideRecordDetail"></view>
    <view class="modal-content">
      <view class="modal-header">
        <text class="modal-title">认证详情</text>
        <text class="modal-close" bindtap="hideRecordDetail">×</text>
      </view>
        </view>
        <view class="detail-item">
          <text class="detail-label">区块链存证</text>
          <text class="detail-value hash">{{currentRecord.blockHash}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">存证时间</text>
          <text class="detail-value">{{currentRecord.blockTime}}</text>
        </view>
      </view>
    </view>
  </view>
</view>
这段代码主要包括认证申请和记录查看。用户可以通过页面提交认证申请，上传毕业证书，并查看历史认证记录。动态数据绑定和事件处理允许用户切换学历层次、查看认证状态并更新界面样式。
学历学位认证页面核心代码如下：
// 学历层次选择器变化
  bindDegreeChange: function(e) {
    this.setData({
      degreeIndex: e.detail.value
    })
  },
  // 入学时间选择器变化
  bindEnrollmentDateChange: function(e) {
    this.setData({
      enrollmentDate: e.detail.value
    })
  },
  // 毕业时间选择器变化
  bindGraduationDateChange: function(e) {
    this.setData({
      graduationDate: e.detail.value
    })
  },
  // 上传毕业证书
  uploadDiploma: function() {
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album', 'camera'],
      success: (res) => {
        this.setData({
          diplomaImage: res.tempFilePaths[0]
        })
      }
    })
  },
  // 上传学位证书
  uploadDegree: function() {
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album', 'camera'],
      success: (res) => {
        this.setData({
          degreeImage: res.tempFilePaths[0]
        })
      }
    })
  },
// 提交申请
  submitApplication: function(e) {
    const formData = e.detail.value
    
    // 表单验证
    if (!formData.name || !formData.idCard || !formData.phone) {
      wx.showToast({
        title: '请填写完整基本信息',
        icon: 'none'
      })
      return
    }
    if (!formData.school || this.data.degreeIndex === null || !formData.major) {
      wx.showToast({
        title: '请填写完整学历信息',
        icon: 'none'
      })
      return
    }

    if (!this.data.enrollmentDate || !this.data.graduationDate) {
      wx.showToast({
        title: '请选择入学和毕业时间',
        icon: 'none'
      })
      return
    }

    if (!this.data.diplomaImage || !this.data.degreeImage) {
      wx.showToast({
        title: '请上传证书照片',
        icon: 'none'
      })
      return
    }

// 添加新记录
      const newRecord = {
        id: this.data.records.length + 1,
        name: formData.name,
        school: formData.school,
        degree: this.data.degreeTypes[this.data.degreeIndex],
        major: formData.major,
        applyTime: `${now.getFullYear()}-${String(now.getMonth() + 1).padStart(2, '0')}-${String(now.getDate()).padStart(2, '0')} ${String(now.getHours()).padStart(2, '0')}:${String(now.getMinutes()).padStart(2, '0')}`,
        status: '认证中',
        blockHash: blockHash,
        blockTime: `${now.getFullYear()}-${String(now.getMonth() + 1).padStart(2, '0')}-${String(now.getDate()).padStart(2, '0')} ${String(now.getHours()).padStart(2, '0')}:${String(now.getMinutes()).padStart(2, '0')}`
      }
这段代码通过选择学历层次、入学和毕业时间来收集用户的学历信息，并允许用户上传毕业证书和学位证书照片。在用户提交申请时，代码首先验证基本信息、学历信息、入学与毕业时间的完整性以及是否上传了必要的证书照片。如果所有验证通过，程序将生成一个包含用户信息和申请时间的新记录，并将其保存至数据库中，状态标记为“认证中”。
5.1.5 首页功能
用户点击底部导航首页，在首页。首页页面如图5.6(a)-(b)所示。
 
图(a) 首页页面                图(b) 首页页面
图5.6 首页页面
首页设计代码如下：
<view class="container">
  <!-- 搜索栏 -->
  <view class="search-bar">
    <view class="search-input">
      <text class="search-icon">🔍</text>
      <input 
        type="text" 
        placeholder="输入姓名或身份证号查询认证进度" 
        bindconfirm="onSearch"
      />
    </view>
  </view>
  <!-- 搜索结果弹窗，卡片列表可滚动 -->
  <view wx:if="{{showSearchResult}}" class="search-result-modal-mask">
    <view class="search-result-modal-content">
      <view class="modal-header">申请信息列表</view>
      <scroll-view scroll-y class="search-result-scroll-list">
        <view class="search-result-card" wx:for="{{searchResults}}" wx:key="id">
        </view>
      </scroll-view>
      <view class="search-result-footer">
        <button class="modal-btn" bindtap="onCloseSearchResult">关闭</button>
      </view>
    </view>
  </view>
  <!-- 轮播图 -->
  <swiper class="banner" indicator-dots autoplay circular>
    <swiper-item wx:for="{{banners}}" wx:key="id">
      <image src="{{item.imageUrl}}" mode="aspectFill" />
    </swiper-item>
  </swiper>
  <!-- 快捷功能区 -->
  <view class="quick-actions">
    <view 
      class="action-item" 
      wx:for="{{quickActions}}" 
      wx:key="id"
      data-url="{{item.url}}"
      bindtap="onActionClick"
    >
      <text class="action-icon">{{item.icon}}</text>
      <text>{{item.name}}</text>
    </view>
  </view>
  <!-- 公告板 -->
  <view class="notice-board">
    <view class="notice-header">
      <text class="notice-title">系统公告</text>
      <text class="notice-more" bindtap="onMoreNotices">查看更多</text>
    </view>
    <view class="notice-content">
      <view 
        class="notice-item" 
        wx:for="{{notices}}" 
        wx:key="id"
        data-id="{{item.id}}"
        bindtap="onNoticeClick"
      >
        <view class="notice-dot"></view>
        <text class="notice-text">{{item.title}}</text>
        <text class="notice-time">{{item.time}}</text>
      </view>
    </view>
  </view>
  <!-- 统计区域 -->
  <view class="stats-section">
    <view class="stats-header">
      <text class="stats-title">认证统计</text>
    </view>
    <view class="stats-content">
      <view class="stats-item">
        <text class="stats-num">{{stats.total}}</text>
        <text class="stats-label">总认证数</text>
      </view>
      <view class="stats-item">
        <text class="stats-num">{{stats.success}}</text>
        <text class="stats-label">认证成功</text>
      </view>
      <view class="stats-item">
        <text class="stats-num">{{stats.pending}}</text>
        <text class="stats-label">认证中</text>
      </view>
      <view class="stats-item">
        <text class="stats-num">{{stats.failed}}</text>
        <text class="stats-label">认证失败</text>
      </view>
    </view>
  </view>
  <!-- 最新认证 -->
  <view class="latest-section">
    <view class="section-header">
      <text class="section-title">最新认证</text>
      <text class="section-more" bindtap="onMoreLatest">查看更多</text>
    </view>
    <view class="latest-list">
      <view 
        class="latest-item" 
        wx:for="{{latestCertifications}}" 
        wx:key="id"
        data-id="{{item.id}}"
        bindtap="onCertificationClick"
      >
        <view class="latest-info">
          <text class="latest-name">{{item.name}}</text>
          <text class="latest-school">{{item.school}}</text>
        </view>
        <text class="latest-status {{item.status}}">
          {{item.status === 'success' ? '认证成功' : 
            item.status === 'pending' ? '认证中' : '认证失败'}}
        </text>
      </view>
    </view>
  </view>
</view> 
这段代码包含了多个功能模块。首先是一个搜索栏，用户可以输入姓名或身份证号进行认证进度查询，搜索结果会以弹窗的形式展示，其中包括了认证状态、学校、申请时间等信息。接着是一个轮播图模块，展示了广告或提示信息。紧接着是快捷功能区，包含多个操作按钮，点击后会跳转到对应的页面。公告板模块展示了系统的最新公告，并提供查看更多的功能。统计区域展示了认证的统计数据，包括总认证数、认证成功、认证中和认证失败的数量。最后，最新认证模块展示了最近完成的认证信息，并提供点击查看详情的功能。
首页核心代码如下：
// 快捷功能点击
  onActionClick(e) {
    const url = e.currentTarget.dataset.url
    wx.navigateTo({ url })
  },

  // 查看公告详情
  onNoticeClick(e) {
    const id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: `/pages/notices/detail?id=${id}`
    })
  },

  // 查看更多公告
  onMoreNotices() {
    wx.navigateTo({
      url: '/pages/notices/list'
    })
  },

  // 查看更多最新认证
  onMoreLatest() {
    wx.navigateTo({
      url: '/pages/applications/applications?tab=records'
    })
  },

  // 查看认证详情
  onCertificationClick(e) {
    const id = e.currentTarget.dataset.id
    wx.navigateTo({
      url: `/pages/applications/detail?id=${id}`
    })
  }
这段代码定义了多个页面跳转的事件处理函数onActionClick用于响应快捷功能区的点击事件，通过e.currentTarget.dataset.url获取目标页面的URL并进行跳转。onNoticeClick用于查看公告详情，通过获取公告的 id 并跳转到对应的公告详情页面。onMoreNotices用于跳转到公告列表页面，展示更多公告信息。onMoreLatest用于跳转到最新认证记录页面，显示更多的认证记录。onCertificationClick用于查看认证详情，通过 id 跳转到认证的详细页面。这些函数通过 wx.navigateTo实现了页面间的跳转。
5.1.6 认证记录详细信息功能
用户点击认证记录即可查看详细信息。认证记录详细信息页面如图5.7所示。

图5.7 认证记录详细信息页面
认证记录详细信息功能设计代码如下：
<!-- 记录详情弹窗 -->
  <view class="record-detail-modal" wx:if="{{showDetail}}">
    <view class="modal-mask" bindtap="hideRecordDetail"></view>
    <view class="modal-content">
      <view class="modal-header">
        <text class="modal-title">认证详情</text>
        <text class="modal-close" bindtap="hideRecordDetail">×</text>
      </view>
      <view class="modal-body">
        <view class="detail-item">
          <text class="detail-label">申请人</text>
          <text class="detail-value">{{currentRecord.name}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">学校</text>
          <text class="detail-value">{{currentRecord.school}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">学历</text>
          <text class="detail-value">{{currentRecord.degree}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">专业</text>
          <text class="detail-value">{{currentRecord.major}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">申请时间</text>
          <text class="detail-value">{{currentRecord.applyTime}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">认证状态</text>
          <text class="detail-value status {{currentRecord.status === '已认证' ? 'success' : currentRecord.status === '认证中' ? 'pending' : 'failed'}}">{{currentRecord.status}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">区块链存证</text>
          <text class="detail-value hash">{{currentRecord.blockHash}}</text>
        </view>
        <view class="detail-item">
          <text class="detail-label">存证时间</text>
          <text class="detail-value">{{currentRecord.blockTime}}</text>
        </view>
      </view>
这段代码定义了一个认证记录详情的弹窗界面，展示了包含认证记录详细信息的弹窗，弹窗会根据showDetail的值来控制是否显示。弹窗包含一个遮罩层，点击遮罩层会触发hideRecordDetail事件，隐藏弹窗。弹窗内容包括多个信息项，如申请人、学校、学历、专业、申请时间、认证状态（通过状态条件渲染样式）、区块链存证和存证时间。每个信息项由标签和对应的值组成，值从currentRecord中提取并显示。认证状态的显示样式根据其值动态变化。
区块链存证智能合约核心代码如下：
// SPDX-License-Identifier: MIT
pragma solidity ^0.4.25;

contract DegreeVerification {
    // 将申请信息拆分为基本信息和管理信息
    struct BasicInfo {
        string openid;
        string realName;
        string degreeType;
        string schoolName;
        string major;
        string degreeNumber;
    }
    struct ManagementInfo {
        uint256 applicationDate;
        string certificationStatus;
        string contactPhone;
        string email;
        string submissionDocumentUrl;
        string additionalInfo;
        uint256 createdAt;
        uint256 updatedAt;
    }
    struct Application {
        uint256 applicationId;
        BasicInfo basicInfo;
        ManagementInfo managementInfo;
    }
    mapping(uint256 => Application) public applications;
    uint256 public applicationCount;
    address public owner;
    event ApplicationCreated(uint256 indexed applicationId, string openid, string realName);
    event ApplicationUpdated(uint256 indexed applicationId, string status);
    event ApplicationApproved(uint256 indexed applicationId);
    event ApplicationRejected(uint256 indexed applicationId);
    modifier onlyOwner() {
        require(msg.sender == owner);
        _;
    }
    constructor() public {
        owner = msg.sender;
        applicationCount = 0;
    }
    // 创建新申请
    function createApplication(
        string _openid,
        string _realName,
        string _degreeType,
        string _schoolName,
        string _major,
        string _degreeNumber,
        string _contactPhone,
        string _email,
        string _additionalInfo
    ) public returns (uint256) {
        applicationCount++;
        BasicInfo memory basicInfo = BasicInfo({
            openid: _openid,
            realName: _realName,
            degreeType: _degreeType,
            schoolName: _schoolName,
            major: _major,
            degreeNumber: _degreeNumber
        });
        ManagementInfo memory managementInfo = ManagementInfo({
            applicationDate: now,
            certificationStatus: "PENDING",
            contactPhone: _contactPhone,
            email: _email,
            submissionDocumentUrl: "",
            additionalInfo: _additionalInfo,
            createdAt: now,
            updatedAt: now
        });
        applications[applicationCount] = Application({
            applicationId: applicationCount,
            basicInfo: basicInfo,
            managementInfo: managementInfo
        });
        emit ApplicationCreated(applicationCount, _openid, _realName);
        return applicationCount;
    }
    // 更新申请信息
    function updateApplication(
        uint256 _applicationId,
        string _realName,
        string _degreeType,
        string _schoolName,
        string _major,
        string _degreeNumber,
        string _contactPhone,
        string _email,
        string _additionalInfo
    ) public onlyOwner {
        require(_applicationId > 0 && _applicationId <= applicationCount);
        Application storage app = applications[_applicationId];
        app.basicInfo.realName = _realName;
        app.basicInfo.degreeType = _degreeType;
        app.basicInfo.schoolName = _schoolName;
        app.basicInfo.major = _major;
        app.basicInfo.degreeNumber = _degreeNumber;
        app.managementInfo.contactPhone = _contactPhone;
        app.managementInfo.email = _email;
        app.managementInfo.additionalInfo = _additionalInfo;
        app.managementInfo.updatedAt = now;
        emit ApplicationUpdated(_applicationId, app.managementInfo.certificationStatus);
    }
    // 更新文件URL
    function updateFileUrl(uint256 _applicationId, string _fileUrl) public onlyOwner {
        require(_applicationId > 0 && _applicationId <= applicationCount);
        applications[_applicationId].managementInfo.submissionDocumentUrl = _fileUrl;
        applications[_applicationId].managementInfo.updatedAt = now;
        emit ApplicationUpdated(_applicationId, applications[_applicationId].managementInfo.certificationStatus);
    }
    // 通过申请
    function approveApplication(uint256 _applicationId) public onlyOwner {
        require(_applicationId > 0 && _applicationId <= applicationCount);
        applications[_applicationId].managementInfo.certificationStatus = "APPROVED";
        applications[_applicationId].managementInfo.updatedAt = now;
        emit ApplicationApproved(_applicationId);
    }
    // 拒绝申请
    function rejectApplication(uint256 _applicationId) public onlyOwner {
        require(_applicationId > 0 && _applicationId <= applicationCount);
        applications[_applicationId].managementInfo.certificationStatus = "REJECTED";
        applications[_applicationId].managementInfo.updatedAt = now;
        emit ApplicationRejected(_applicationId);
    }
    // 获取申请基本信息
    function getBasicInfo(uint256 _applicationId) public view returns (
        string openid,
        string realName,
        string degreeType,
        string schoolName,
        string major,
        string degreeNumber
    ) {
        require(_applicationId > 0 && _applicationId <= applicationCount);
        BasicInfo storage info = applications[_applicationId].basicInfo;
        return (
            info.openid,
            info.realName,
            info.degreeType,
            info.schoolName,
            info.major,
            info.degreeNumber
        );
    }
    // 获取申请管理信息
    function getManagementInfo(uint256 _applicationId) public view returns (
        uint256 applicationDate,
        string certificationStatus,
        string contactPhone,
        string email,
        string submissionDocumentUrl,
        string additionalInfo,
        uint256 createdAt,
        uint256 updatedAt
    ) {
        require(_applicationId > 0 && _applicationId <= applicationCount);
        ManagementInfo storage info = applications[_applicationId].managementInfo;
        return (
            info.applicationDate,
            info.certificationStatus,
            info.contactPhone,
            info.email,
            info.submissionDocumentUrl,
            info.additionalInfo,
            info.createdAt,
            info.updatedAt
        );
    }
}
智能合约DegreeVerification用于学位验证的管理系统，处理学位认证申请。合约包含多个方法，如createApplication创建新申请并返回申请 ID，updateApplication 更新申请信息（仅限合约拥有者执行），updateFileUrl更新提交的文件URL（仅限合约拥有者），approveApplication和rejectApplication分别用于批准和拒绝申请（仅限合约拥有者），以及getBasicInfo和getManagementInfo用于获取申请的基本和管理信息。通过事件记录申请的创建、更新、批准和拒绝情况，确保流程的透明性和可追溯性。合约使用onlyOwner修饰符限制权限，增强安全性，确保只有合约拥有者能够执行管理操作，从而有效管理学位验证申请。
认证记录详细信息核心代码如下：
// 显示记录详情
  showRecordDetail: function(e) {
    const id = e.currentTarget.dataset.id
    const record = this.data.records.find(r => r.id === id)
    
    this.setData({
      showDetail: true,
      currentRecord: record
    })
  },

  // 隐藏记录详情
  hideRecordDetail: function() {
    this.setData({
      showDetail: false,
      currentRecord: null
    })
  }
这段代码定义了两个函数：showRecordDetail和hideRecordDetail。showRecordDetail用于显示记录详情，当点击某个记录时，它通过 e.currentTarget.dataset.id获取记录的 ID，并在this.data.records数组中查找对应的记录。找到后，使用setData方法将showDetail设置为true，并将当前记录存入 currentRecord中，从而显示详情。hideRecordDetail用于隐藏记录详情，它通过setData将showDetail设置为false，并将currentRecord设为null，从而隐藏详情并清空当前记录。
5.1.7 搜索申请信息功能
用户进入首页，点击顶部搜索栏，可以搜索认证申请记录。搜索申请信息页面如图5.8所示。

图5.8 搜索申请信息页面
搜索申请信息功能设计代码如下：
<!-- 搜索结果弹窗，卡片列表可滚动 -->
  <view wx:if="{{showSearchResult}}" class="search-result-modal-mask">
    <view class="search-result-modal-content">
      <view class="modal-header">申请信息列表</view>
      <scroll-view scroll-y class="search-result-scroll-list">
        <view class="search-result-card" wx:for="{{searchResults}}" wx:key="id">
          <view class="result-row"><text>姓名：</text><text>{{item.name}}</text></view>
          <view class="result-row"><text>学校：</text><text>{{item.school}}</text></view>
          <view class="result-row"><text>认证状态：</text><text>{{item.status}}</text></view>
          <view class="result-row"><text>申请时间：</text><text>{{item.time}}</text></view>
        </view>
      </scroll-view>
      <view class="search-result-footer">
        <button class="modal-btn" bindtap="onCloseSearchResult">关闭</button>
      </view>
    </view>
  </view>
这段代码实现了一个可滚动的搜索结果弹窗，显示每条记录的姓名、学校、认证状态和申请时间。当 showSearchResult为 true时，弹窗会显示搜索结果，点击“关闭”按钮会关闭弹窗。
搜索申请信息核心代码如下：
onSearch(e) {
  const value = e.detail.value
  if (value) {
    // 发起网络请求获取搜索结果
    wx.request({
      url: '/api/search',  // 假设的API接口
      method: 'GET',
      data: { query: value },  // 发送搜索关键词
      success: (res) => {
        // 假设返回的数据格式为res.data
        if (res.data && res.data.length > 0) {
          this.setData({
            showSearchResult: true,
            searchResults: res.data
          })
        } else {
          // 如果没有找到数据，可以显示一个提示
          this.setData({
            showSearchResult: false
          })
          wx.showToast({
            title: '未找到结果',
            icon: 'none'
          })
        }
      },
      fail: (err) => {
        // 请求失败的处理
        wx.showToast({
          title: '请求失败，请稍后再试',
          icon: 'none'
        })
      }
    })
  }
}
这段代码实现了一个搜索功能，当用户输入搜索关键词后，通过发起网络请求从服务器获取与关键词相关的真实数据。如果获取到数据，弹窗会显示搜索结果；如果没有数据，显示提示信息“未找到结果”；如果请求失败，会弹出“请求失败”的提示。这种方式避免了使用模拟数据，直接从实际的数据源中获取搜索结果。
5.1.8 编辑资料功能实现
用户登录之后，在“我的”页面可以进行资料编辑。编辑资料页面如图5.9所示。

图5.9 编辑资料页面
编辑资料页面设计代码如下：
<view wx:if="{{showEditProfile}}" class="modal-mask">
    <view class="modal-content">
      <view class="modal-header">编辑资料</view>
      <view class="modal-body">
        <input class="modal-input" placeholder="昵称" value="{{editProfile.nickName}}" bindinput="onEditNickName" />
        <input class="modal-input" placeholder="手机号" value="{{editProfile.phone}}" bindinput="onEditPhone" />
        <input class="modal-input" placeholder="邮箱" value="{{editProfile.email}}" bindinput="onEditEmail" />
      </view>
      <view class="modal-footer">
        <button class="modal-btn" bindtap="onSaveProfile">保存</button>
        <button class="modal-btn cancel" bindtap="onCancelEditProfile">取消</button>
      </view>
    </view>
  </view>
这段代码实现了一个弹出框，用于编辑用户资料。当showEditProfile为true时，弹出框显示在页面上。弹出框包含一个标题“编辑资料”，以及三个输入框供用户修改昵称、手机号和邮箱。每个输入框都绑定了相应的事件处理函数，用于实时更新输入的值。底部有两个按钮，分别用于保存修改（调用onSaveProfile函数）和取消编辑（调用onCancelEditProfile函数）。
编辑资料页面核心代码如下：
handleEditProfile: function() {
    this.setData({
      showEditProfile: true,
      editProfile: {
        nickName: this.data.userInfo.nickName,
        phone: this.data.userInfo.phone,
        email: this.data.userInfo.email
      }
    })
  },
  onEditNickName(e) {
    this.setData({ 'editProfile.nickName': e.detail.value })
  },
  onEditPhone(e) {
    this.setData({ 'editProfile.phone': e.detail.value })
  },
  onEditEmail(e) {
    this.setData({ 'editProfile.email': e.detail.value })
  },
  onSaveProfile() {
    this.setData({
      userInfo: {
        ...this.data.userInfo,
        nickName: this.data.editProfile.nickName,
        phone: this.data.editProfile.phone,
        email: this.data.editProfile.email
      },
      showEditProfile: false
    })
    wx.showToast({ title: '保存成功', icon: 'success' })
  },
  onCancelEditProfile() {
    this.setData({ showEditProfile: false })
  },
这段代码实现了编辑用户资料的功能。handleEditProfile方法用于显示编辑框，并将当前用户信息（昵称、手机号、邮箱）赋值到editProfile中，供用户修改。onEditNickName、onEditPhone和onEditEmail方法分别用于更新用户输入的昵称、手机号和邮箱。当用户点击保存按钮时，onSaveProfile方法会将修改后的资料保存到 userInfo中，并隐藏编辑框，同时显示“保存成功”的提示。点击取消按钮时，onCancelEditProfile方法会直接关闭编辑框，放弃修改。
5.1.9 更多公告功能实现
用户进入首页后可以看到有一个公告栏，点击公告栏可以看到更多公告。更多公告页面如图5.10所示。

图5.10 更多公告页面
更多公告页面设计代码如下：
<view class="container">
  <view class="notice-list">
    <view class="notice-item" wx:for="{{notices}}" wx:key="id" data-id="{{item.id}}" bindtap="onNoticeClick">
      <view class="notice-title">{{item.title}}</view>
      <view class="notice-time">{{item.time}}</view>
    </view>
  </view>
</view> 
这段代码展示了一个通知列表页面。<view class="container">包裹了整个内容。通知列表部分使用了wx:for="{{notices}}"来循环渲染notices数组中的每一项，每一项数据被渲染为一个notice-item，每个通知项包含标题 (notice-title) 和时间 (notice-time)。通过wx:key="id"来确保每个通知项都有一个唯一的标识符。每个通知项还绑定了点击事件bindtap="onNoticeClick"，当用户点击某个通知时，会触发 onNoticeClick方法。每个通知项的 ID 通过data-id="{{item.id}}"传递给事件处理函数。
更多公告页面核心代码如下：
Page({
  data: {
    notices: [] 
  },
  
  onLoad() {
    // 页面加载时请求通知数据
    this.fetchNotices();
  },

  fetchNotices() {
    // 使用 wx.request 获取数据
    wx.request({
      url: 'https://localhost/notices',  
      method: 'GET',
      success: (res) => {
        if (res.statusCode === 200) {
          this.setData({
            notices: res.data.notices  
          });
        } else {
          // 处理请求失败或数据格式错误的情况
          wx.showToast({
            title: '加载通知失败',
            icon: 'none'
          });
        }
      },
      fail: () => {
        wx.showToast({
          title: '网络请求失败',
          icon: 'none'
        });
      }
    });
  },

  onNoticeClick(e) {
    const id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: `/pages/notices/detail?id=${id}`
    });
  }
});
这段代码实现了一个通知列表页面，首先在onLoad生命周期函数中调用了fetchNotices方法从服务器获取通知数据。通过wx.request向指定的接口发送 GET 请求，获取到的通知数据会被存储在notices数组中，并通过setData更新页面的显示。用户点击某个通知时，触发onNoticeClick方法，获取通知的 ID 并通过 wx.navigateTo跳转到通知详情页面，传递通知的 ID 作为参数。这样页面能动态加载服务器返回的通知列表，并实现点击查看详细内容的功能。





















6 学历学位认证系统测试
在软件开发过程中，系统测试在软件开发中至关重要，因为它帮助确保软件在不同的环境和条件下都能稳定运行，满足预期的功能和性能要求。通过全面的系统测试，可以发现和修复潜在的缺陷和问题，防止这些问题在发布后影响用户体验或导致系统崩溃[20]。此外，系统测试还能验证软件与其他系统的兼容性，确保不同模块间的有效协作，从而提高软件的质量和可靠性，降低后期维护成本。通过实施充分的系统测试，不仅能够保障软件的质量和稳定性，更能够提升用户的满意度和信赖度。
6.1 用户端功能模块测试 
软件测试是一项至关重要的工作，是保证软件产品质量和可靠性的基石。本文测试的硬件配置和体系结构如下所示。
硬件配置：
系统开发和运行的平台为：
（1）操作系统：
Windows 10
（2）开发平台：
IntelliJ IDEA 2022
微信开发者工具版本1.06.2303220
（3）开发语言： 
Java(后端所用的语言)
JavaScript(小程序所用语言)
Solidity（智能合约开发语言）
WXML(微信标记语言)
WXSS(微信样式表)
体系结构：
学历学位认证系统的体系结构包括多个层次：用户界面层提供交互界面，应用层处理业务逻辑，数据层存储和管理信息，认证与审批层验证学历信息，安全层保障数据安全，通知与报告层负责提醒和报告生成，后台管理层用于系统管理，外部接口层实现与其他平台的数据对接。整个系统通过各层协同工作，确保认证过程高效、安全和可靠。
数据库服务器：MySQL 5.6
硬件环境：手机端最低配置：内存：512MB CPU：500MHz 内存卡(SD/TF)：512M 分辨率：240×320；服务器端最低配置：内存：8GB CPU：2GHz  硬盘：120G
软件配置：
开发系统所需要的软件包括：
（1）开发IDE至少为IDEA2022、微信开发者工具1.06.2303220；
（2）MySQL为系统支持的数据库；
（3）采用Java、JavaScript、Solidity作为开发程序设计语言；
软件测试的首要任务是确保一个稳定可靠的测试环境，因为不同环境可能会对测试结果造成不同的影响，因此需要选择恰当的测试环境。为适配测试，测试所需要的硬件环境和软件环境如表6.1-6.2所示：
表6.1硬件测试环境
资源名称	配置详情
WEB服务器	笔记本1台
微信小程序	荣耀Magic6
表6.2软件测试环境
资源名称	配置详情
WEB服务器	Window 10操作系统1台
数据库	MySQL5.6
荣耀Magic6	Android
黑盒测试又被称为数据驱动测试或基于规格说明的测试，实际上站在最终用户的立场，检测输入输出信息及系统性能指标是否符合规格说明书中有关功能需求及性能需求规定的测试方法。黑盒测试技术就是根据功能需求来设计测试用例,验证软件是否按照预期要求工作。本节将对多场景存储系统小程序端进行黑盒测试，涵盖了用户全部的功能模块。在测试中模拟用户完成各种复杂业务操作，并根据测试的结果来对系统的功能性和完整性进行评价。小程序功能黑盒测试设计表如表6.3所示。
表6.3小程序功能黑盒测试设计表
用例编号	模块	测试内容	前置条件	严重性	测试结果
1	注册模块	能否成功注册用户	正常连接服务器	非常严重	注册成功
2	登录模块	能否成功登录，并进入图片页面	正常连接服务器	非常严重	可以登录并进入图片页面
3	申请认证模块	能否上传个人信息	正常连接服务器；用户登录成功	非常严重	通过
4		能否上传学历信息	正常连接服务器；用户登录成功	非常严重	通过
5		能否上传证明材料	正常连接服务器；用户登录成功	非常严重	通过
6	个人资料模块	是否能进入个人信息页面	正常连接服务器；用户登录成功	严重	通过
7		是否能修改个人信息	正常连接服务器；用户登录成功	非常严重	通过
8		是否能修改密码	正常连接服务器；
进入我的页面	严重	通过
9		是否能跳转到提交认证信息页面	正常连接服务器，用户登录成功	非常严重	通过
10	首页模块	是否能进入首页	正常连接服务器；用户登录成功	严重	通过
11		是否能搜索认证信息	正常连接服务器；用户登录成功	非常严重	通过
12		是否能查看更多公告	正常连接服务器；用户登录成功	非常严重	通过
13		是否能查看统计数据	正常连接服务器，用户登录成功	非常严重	通过
6.2 展望
未来的学历学位认证系统将更加智能化、自动化和全球化。随着技术的发展，人工智能和大数据的应用将使认证过程更加高效和准确。AI可以自动化校验学历信息，并通过大数据分析提供更精确的风险评估和验证结果。系统将更好地与全球教育资源对接，支持跨国认证，确保国际间学历的互认和流通。此外，区块链技术的引入可能会提高数据的透明度和不可篡改性，进一步增强认证的可信度和安全性。同时，随着用户需求的增加，系统的服务将更加多样化，包括在线查询、实时通知、定制化报告等，使得学历学位认证变得更加便捷和易于管理。同时现有的小程序端也存在需要改进和完善的问题，以下几个方面仍有不足：
（1）信息安全风险：尽管系统有安全保护措施，但随着网络攻击手段的不断升级，系统仍面临数据泄露、篡改等风险，可能导致用户隐私和认证信息的泄露。

（2）跨国认证难度大：不同国家和地区的学历认证标准、程序和要求各不相同，导致国际间的学历认证存在障碍，尤其是在文化差异和法规不统一的情况下。
（3）用户体验问题：一些用户可能会遇到界面复杂、操作不便、信息查询不精准等问题，影响整体的使用体验，尤其是对于技术不熟悉的群体。

结 论
经过数个月的努力，基本完成了基于微信小程序的学历学位认证系统的设计与实现，从最初的微信小程序初学到如今整个系统的完成，我收获了很多。不仅是自学能力的提升，同样是个人能力的一次飞跃。开发期间使用微信小程序官方API文档，学习里面各种API的用法，学习WXML、WXSS和JS，逐步掌握微信小程序基础开发知识和基础开发能力，学会如何从用户和业务需求出发，进行全面的需求分析，并设计出适应需求的系统架构，了解并实践如何在系统中实施数据加密、身份验证、权限管理等安全技术，保障用户的个人信息和学历数据的安全，防止数据泄露和篡改。
在设计本系统时，着力研究目前国内外学历学位认证系统的现状以及优点和缺点并进行细致的分析，最终选择开发一款基于微信小程序的学历学位认证系统。结合实际，站在用户立场上对学历学位认证系统进行了详细需求分析和用例分析，列举系统的功能性需求与非功能性需求。并且以需求为导向，进一步完善系统的设计方案并且努力实现。最后通过完整的系统测试，发现系统问题并解决，提高用户使用体验。
随着大数据时代的到来，与云计算的普及，和存储成本的下降，学历学位认证系统有望实现更多的创新和改进：
（1）数据安全保障。通过引入更先进的加密技术和访问控制机制来增强数据的安全性。
（2）智能化存储管理。引入人工智能和机器学习技术，系统可以自动分析用户的数据使用习惯，预测未来的数据存储需求，并自动优化存储空间的分配。
经历了这次系统的开发我收获颇丰，包括系统的需求分析，系统开发的关键技术等等都让我受益匪浅。希望在未来的工作当中可以不断探索和运用新的技术与功能，使学历学位认证系统更加完善。
参考文献
[1]李帅力. 基于SpringMVC及MyBatis框架的智慧园区访客管理系统的设计与实现[D]. 浙江:浙江工业大学,2016.
[2]吴迪. 高校图书馆微信小程序用户需求研究[D]. 安徽:安徽大学,2024.
[3]胡姝帆. 基于用户体验的微信应用小程序设计——以青檬国际项目为例[D]. 湖北:湖北工业大学,2021.
[4]区块链[J]. 江苏政协,2023(11):40.
[5]郭赵倩. 联合国教科文组织高等教育学历学位认证公约研究[D]. 四川外国语大学,2024.
[6]陈杰,方国才,方水波. 基于MySQL的多地多中心系统架构研究[J]. 机电工程技术,2025,54(3):175-181. 
[7]陈泽豪. 面向以太坊区块链平台的存储系统优化[D]. 山东:山东大学,2022.
[8]罗辉琼,贺超波,李姣姣,等. 基于SpringMVC及MyBatis的高校学术成果库设计与实现[J]. 现代信息科技,2024,8(4):25-29,35. 
[9]管珂珂,诸葛阳,许大为. 基于SpringMvc架构模式的远程居家医疗系统设计[J]. 包装工程,2020,41(4):160-165,176. 
[10]王子成. 基于区块链智能合约的数据库容灾备份恢复平台的设计与实现[D]. 内蒙古:内蒙古大学,2022.
[11]韦军,农磊,韦龙腾,等. 基于SpringBoot的矿山安全评价系统的设计与实现[J]. 电脑编程技巧与维护,2025(2):110-113. 
[12]李金忠,胡志明,陈建钢,等. 基于SpringBoot和Uni-App框架的自习室平台的设计与实现[J]. 河北水利电力学院学报,2024,34(2):77-82.
[13]周晓睿,杨磊,宋欣,等. 基于Vue+Springboot的中草药病害识别管理系统研究[J]. 天津农学院学报,2024,31(3):78-84.
[14]杜龙心,林建超,成新民. 基于SpringBoot的场车定员定位云服务管理系统设计与开发[J]. 湖州师范学院学报,2022,44(4):52-57. 
[15] 张伟. 基于SpringBoot和Vue的综合教学管理平台设计与实现[D]. 重庆:重庆大学,2021.
[16]崔黎,方洁. 基于SpringBoot的肉类品质管理系统的设计与实现[J]. 电脑知识与技术,2022,18(13):47-48,52.
[17] 林翔. 基于SpringBoot技术的M公司厨电产品质量管理系统的设计与实现[D]. 四川:电子科技大学,2021.
[18]雷蓓,查笑春,蒋宗敏,等. 基于SpringBoot的智慧变电站监测及诊断系统[J]. 电气技术,2021,22(9):56-62. 
[19]华芳,丁毅,孙伽宁,等. 一套基于区块链的可信学历学位认证系统[J]. 网络空间安全,2020,11(9):9-18. 
[20]魏振毅. 高校学籍学历学位数字档案的共享路径[C]//2018年福建省科协第十八届学术年会档案分会场研讨会论文集. 2018:141-146.


致 谢
时光荏苒，岁月如梭。在此，我怀着无比感激的心情，向所有在我论文撰写过程中给予我帮助和支持的人表示衷心的感谢。
首先，我要感谢我的导师冯志林教授。冯志林教授在我整个论文的撰写过程中给予了我莫大的指导和帮助。包括对我论文研究的方向提出指导性的意见，在论文的修改过程当中始终保持最认真、最负责的态度对我进行指导，投入了大量心血与精力。此外，他以极大的耐心和热情指导我们的学习，不仅传授知识，更教会我们如何思考、如何独立解决问题。他鼓励我们积极参与各类竞赛，挑战自我，锻炼能力。在他的悉心指导下，我们取得了不俗的成绩。
同时，我还要感谢浙江工业大学之江学院软件工程专业的所有老师与同学们。感谢老师们为我提供了丰富的学习资源以及对我知识体系的建设与培养。也感谢同学们在学习的过程中互帮互助，共同成长，一起度过了一段美好的学习时光。
鉴于本人的学术水平有限，对于学历学位认证系统的研究还有许多的不足和有待完善之处，今后我将继续进行思考和总结，对本系统进行完善。
最后，我要感谢所有对本文进行评阅和参与答辩的老师们，感谢您们能在百忙之中抽出宝贵时间对本文进行评阅以及提出宝贵的意见。
