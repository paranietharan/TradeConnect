package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.model.ProofDocuments;
import com.tradeconnect.tradeconnectapi.service.ProofDocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/proof-documents")
public class ProofDocumentsController {
    private final ProofDocumentsService proofDocumentsService;

    @GetMapping("/{userId}")
    public ResponseEntity<ProofDocumentsRequest> getProofDocuments(String userId) {
        return ResponseEntity.ok(proofDocumentsService.getProofDocuments(userId));
    }

    @PostMapping("/{userId}")
    public ResponseEntity<ProofDocumentsResponse> addProofDocument(String userId) {
        return ResponseEntity.ok(proofDocumentsService.addProofDocument(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteProofDocument(String userId) {
        return ResponseEntity.ok(proofDocumentsService.deleteProofDocument(userId));
    }
}
