package com.tradeconnect.tradeconnectapi.repository;

import com.tradeconnect.tradeconnectapi.model.ProofDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProofDocumentsRepository extends JpaRepository<ProofDocuments, Long> {
    @Query("SELECT p FROM ProofDocuments p WHERE p.user.customerId = ?1")
    List<ProofDocuments> findByUserId(String userId);

    @Query("DELETE FROM ProofDocuments p WHERE p.user.customerId = ?1")
    void deleteByUserId(String userId);
}
