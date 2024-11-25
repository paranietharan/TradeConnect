package com.tradeconnect.tradeconnectapi.dto.ProofDocuments;

public record ProofDocumentsResponse(
        Long id,
        Long userId,
        byte[] document
) {
}
