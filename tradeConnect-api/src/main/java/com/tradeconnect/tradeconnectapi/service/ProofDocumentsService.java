package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.repository.ProofDocumentsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProofDocumentsService {
    private final ProofDocumentsRepository proofDocumentsRepository;
}
