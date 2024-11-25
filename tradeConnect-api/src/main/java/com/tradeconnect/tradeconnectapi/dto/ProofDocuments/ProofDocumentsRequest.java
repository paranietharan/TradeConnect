package com.tradeconnect.tradeconnectapi.dto.ProofDocuments;

public record ProofDocumentsRequest(
        Long userId,
        byte[] document
) {
}
