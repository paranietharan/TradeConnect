package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.CredentialsDto;
import com.tradeconnect.tradeconnectapi.dto.SignUpDto;
import com.tradeconnect.tradeconnectapi.dto.UserDto;
import com.tradeconnect.tradeconnectapi.dto.UserReponseDto;
import com.tradeconnect.tradeconnectapi.exceptions.AppException;
import com.tradeconnect.tradeconnectapi.mappers.UserMapper;
import com.tradeconnect.tradeconnectapi.model.Admin;
import com.tradeconnect.tradeconnectapi.model.Role;
import com.tradeconnect.tradeconnectapi.model.User;
import com.tradeconnect.tradeconnectapi.repository.AdminRepository;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import com.tradeconnect.tradeconnectapi.util.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

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

    @Autowired
    private UserMapper userMapper;

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

            if(user.getRole() != null) {
                userDto.setRole(user.getRole().name());
            }
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

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));
        user.setRole(Role.ROLE_USER);

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByLogin(String email) {
        User user = userRepository.findByEmail(email);
        return userMapper.toUserDto(user);
    }

    public UserReponseDto getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return toUserResponseDto(user.get());
        } else {
            throw new AppException("User not found", HttpStatus.NOT_FOUND);
        }
    }

    private UserReponseDto toUserResponseDto(User user) {
        UserReponseDto userReponseDto = new UserReponseDto();
        userReponseDto.setId(user.getCustomerId());
        userReponseDto.setFirstName(user.getFirstName());
        userReponseDto.setLastName(user.getLastName());
        userReponseDto.setEmail(user.getEmail());
        userReponseDto.setRole(user.getRole().name());
        return userReponseDto;
    }
}
