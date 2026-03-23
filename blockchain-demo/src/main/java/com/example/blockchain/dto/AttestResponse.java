package com.example.blockchain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** POST /api/attest 响应体 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttestResponse {
    private Long   requestId;
    private String txHash;
    private String attestedHash;
    private String contractAddress;
}
