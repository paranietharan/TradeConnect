package com.tradeconnect.tradeconnectapi.config;

import com.tradeconnect.tradeconnectapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAuthenticationProvider {

    @Autowired
    private JwtUtil jwtUtil;

    public String createToken(String email, String role) {
        return jwtUtil.generateToken(email, role);
    }
}
