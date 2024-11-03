package com.tradeconnect.tradeconnectapi.repository;

import com.tradeconnect.tradeconnectapi.model.Role;
import com.tradeconnect.tradeconnectapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    boolean existsByRole(Role role);
}
