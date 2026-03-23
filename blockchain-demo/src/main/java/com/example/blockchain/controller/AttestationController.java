package com.example.blockchain.controller;

import com.example.blockchain.dto.AttestRequest;
import com.example.blockchain.dto.AttestResponse;
import com.example.blockchain.dto.AttestationInfo;
import com.example.blockchain.service.AttestationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 链上存证 REST 接口
 *
 * <p>POST /api/attest           – 写入存证
 * <p>GET  /api/attest/{id}      – 查询存证
 */
@RestController
@RequestMapping("/api/attest")
public class AttestationController {

    private final AttestationService service;

    public AttestationController(AttestationService service) {
        this.service = service;
    }

    /**
     * 写入链上存证
     *
     * <p>请求体示例：
     * <pre>
     * {
     *   "requestId": 1001,
     *   "userId": "user_42",
     *   "schoolId": "school_01",
     *   "degree": "bachelor",
     *   "major": "software_engineering",
     *   "graduationYear": "2025"
     * }
     * </pre>
     *
     * <p>响应示例：
     * <pre>
     * {
     *   "requestId": 1001,
     *   "txHash": "0xabc...",
     *   "attestedHash": "0xdef...",
     *   "contractAddress": "0x123..."
     * }
     * </pre>
     */
    @PostMapping
    public ResponseEntity<AttestResponse> attest(@RequestBody AttestRequest req) throws Exception {
        AttestResponse resp = service.attest(req);
        return ResponseEntity.ok(resp);
    }

    /**
     * 查询链上存证信息（验真）
     *
     * <p>响应示例：
     * <pre>
     * {
     *   "requestId": 1001,
     *   "hash": "0xdef...",
     *   "timestamp": "2025-06-01T12:00:00Z",
     *   "issuer": "0xOwnerAddress",
     *   "meta": "degree:bachelor|school:school_01|year:2025"
     * }
     * </pre>
     */
    @GetMapping("/{requestId}")
    public ResponseEntity<AttestationInfo> getAttestation(@PathVariable Long requestId) throws Exception {
        AttestationInfo info = service.getAttestation(requestId);
        return ResponseEntity.ok(info);
    }
}
