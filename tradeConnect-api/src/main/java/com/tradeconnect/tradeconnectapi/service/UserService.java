package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.CredentialsDto;
import com.tradeconnect.tradeconnectapi.dto.UserDto;
import com.tradeconnect.tradeconnectapi.model.Admin;
import com.tradeconnect.tradeconnectapi.model.User;
import com.tradeconnect.tradeconnectapi.repository.AdminRepository;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import com.tradeconnect.tradeconnectapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public UserDto login(CredentialsDto credentialsDto) {
        String password = new String(credentialsDto.getPassword());

        User user = userRepository.findByEmail(credentialsDto.getEmail());
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());

            // Create a new UserDto object and set the user's details
            UserDto userDto = new UserDto();
            userDto.setId(user.getCustomerId());
            userDto.setFirstName(user.getFirstName());
            userDto.setLastName(user.getLastName());
            userDto.setEmail(user.getEmail());
            userDto.setRole(user.getRole().toString());
            userDto.setToken(token);

            return userDto;
        } else {
            System.out.println("Invalid credentials for user ::" + credentialsDto.getEmail());
        }

        Admin admin = adminRepository.findByEmail(credentialsDto.getEmail());
        if (admin != null && passwordEncoder.matches(password, admin.getPassword())) {
            String token = jwtUtil.generateToken(admin.getEmail(), "ADMIN");

            // Create a new UserDto object and set the admin's details
            UserDto userDto = new UserDto();
            userDto.setId(admin.getAdminId());
            userDto.setFirstName(admin.getFirstName());
            userDto.setLastName(admin.getLastName());
            userDto.setEmail(admin.getEmail());
            userDto.setRole("ADMIN");
            userDto.setToken(token);

            return userDto;
        } else {
            System.out.println("Invalid credentials for admin ::" + credentialsDto.getEmail());
        }

        throw new RuntimeException("Invalid credentials");
    }
}
