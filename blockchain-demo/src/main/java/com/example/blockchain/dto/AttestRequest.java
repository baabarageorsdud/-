package com.example.blockchain.dto;

import lombok.Data;

/** POST /api/attest 请求体 */
@Data
public class AttestRequest {
    /** 认证申请唯一编号 */
    private Long requestId;

    /** 申请人用户 ID */
    private String userId;

    /** 学校 ID */
    private String schoolId;

    /** 学历层次，如 bachelor / master / doctor */
    private String degree;

    /** 专业名称 */
    private String major;

    /** 毕业年份，如 2025 */
    private String graduationYear;
}
