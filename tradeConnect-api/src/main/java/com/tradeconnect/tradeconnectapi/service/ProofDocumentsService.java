package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.ProofDocuments.ProofDocumentsRequest;
import com.tradeconnect.tradeconnectapi.dto.ProofDocuments.ProofDocumentsResponse;
import com.tradeconnect.tradeconnectapi.model.ProofDocuments;
import com.tradeconnect.tradeconnectapi.repository.ProofDocumentsRepository;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProofDocumentsService {
    private final ProofDocumentsRepository proofDocumentsRepository;
    private final UserRepository userRepository;

    public List<ProofDocumentsResponse> getProofDocuments(String userId) {
        List<ProofDocuments> proofDocuments = proofDocumentsRepository.findByUserId(userId);

        // Convert ProofDocuments to ProofDocumentsResponse
        return proofDocuments.stream()
                .map(proofDocument -> new ProofDocumentsResponse(
                        proofDocument.getDocumentId(),
                        proofDocument.getUser().getCustomerId(),
                        proofDocument.getDocumentData()
                ))
                .toList();
    }

    public ProofDocumentsRequest addProofDocument(@Valid ProofDocumentsRequest proofDocumentsRequest) {
        ProofDocuments proofDocument = new ProofDocuments();
        proofDocument.setDocumentData(proofDocumentsRequest.document());
        proofDocument.setUser(
                userRepository.findById(proofDocumentsRequest.userId())
                        .orElseThrow(() -> new RuntimeException("User not found"))
        );
        proofDocumentsRepository.save(proofDocument);
        return proofDocumentsRequest;
    }

    public String deleteProofDocument(String userId) {
        proofDocumentsRepository.deleteByUserId(userId);
        return "Proof document deleted successfully";
    }
}
