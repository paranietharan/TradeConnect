package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.ProofDocuments.ProofDocumentsRequest;
import com.tradeconnect.tradeconnectapi.dto.ProofDocuments.ProofDocumentsResponse;
import com.tradeconnect.tradeconnectapi.model.ProofDocuments;
import com.tradeconnect.tradeconnectapi.service.ProofDocumentsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/proof-documents")
public class ProofDocumentsController {
    private final ProofDocumentsService proofDocumentsService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<ProofDocumentsResponse>> getProofDocuments(
            @PathVariable String userId

    ) {
        return ResponseEntity.ok(proofDocumentsService.getProofDocuments(userId));
    }

    @PostMapping
    public ResponseEntity<ProofDocumentsRequest> addProofDocument(
            @ModelAttribute @Valid ProofDocumentsRequest proofDocumentsRequest
    ) {
        return ResponseEntity.ok(proofDocumentsService.addProofDocument(proofDocumentsRequest));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteProofDocument(String userId) {
        return ResponseEntity.ok(proofDocumentsService.deleteProofDocument(userId));
    }
}
