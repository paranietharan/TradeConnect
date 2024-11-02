package com.tradeconnect.tradeconnectapi.config;

import com.tradeconnect.tradeconnectapi.model.Role;
import com.tradeconnect.tradeconnectapi.model.User;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AdminUserInitializer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner createAdminUser() {
        return args -> {
            if (!userRepository.existsByRole(Role.ROLE_ADMIN)) {
                User admin = new User();
                admin.setEmail("admin@admin.com");
                admin.setPassword(passwordEncoder.encode("adminPassword"));
                admin.setRole(Role.ROLE_ADMIN);
                userRepository.save(admin);
            }
        };
    }
}