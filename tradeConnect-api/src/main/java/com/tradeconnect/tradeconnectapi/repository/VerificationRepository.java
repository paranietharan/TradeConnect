package com.tradeconnect.tradeconnectapi.repository;

import com.tradeconnect.tradeconnectapi.model.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification, String> {
}
