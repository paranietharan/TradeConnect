package com.tradeconnect.tradeconnectapi.config;

import com.tradeconnect.tradeconnectapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider {

    @Autowired
    private JwtUtil jwtUtil;

    public String createToken(String email, String role) {
        return jwtUtil.generateToken(email, role);
    }

    public Authentication validateToken(String authElement) {
        return jwtUtil.validateToken(authElement);
    }

    public void revokeToken(String token) {
        jwtUtil.revokeToken(token);
    }
}
