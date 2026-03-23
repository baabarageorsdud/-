package com.example.blockchain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** GET /api/attest/{requestId} 响应体 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttestationInfo {
    private Long   requestId;
    private String hash;
    private String timestamp;   // ISO-8601 字符串
    private String issuer;
    private String meta;
}
