package com.tradeconnect.tradeconnectapi.repository;

import com.tradeconnect.tradeconnectapi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmail(String email);
}
