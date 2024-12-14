package com.tradeconnect.tradeconnectapi.service;

import com.tradeconnect.tradeconnectapi.dto.CredentialsDto;
import com.tradeconnect.tradeconnectapi.dto.SignUpDto;
import com.tradeconnect.tradeconnectapi.dto.User.UserDto;
import com.tradeconnect.tradeconnectapi.dto.UserReponseDto;
import com.tradeconnect.tradeconnectapi.exceptions.AppException;
import com.tradeconnect.tradeconnectapi.model.Role;
import com.tradeconnect.tradeconnectapi.model.User;
import com.tradeconnect.tradeconnectapi.repository.UserRepository;
import com.tradeconnect.tradeconnectapi.util.JwtUtil;
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

            if(user.getRole() != null) {
                userDto.setRole(user.getRole().name());
            }
            userDto.setToken(token);

            return userDto;
        } else {
            System.out.println("Invalid credentials for user ::" + credentialsDto.getEmail());
        }

        throw new RuntimeException("Invalid credentials");
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByEmail(userDto.getEmail()));

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));
        user.setRole(Role.ROLE_USER);

        User savedUser = userRepository.save(user);

        UserDto userDto1 = toUserDto(savedUser);
        userDto1.setToken(
                jwtUtil.generateToken(
                        user.getEmail(),
                        user.getRole().name()
                )
        );
        return userDto1;
    }

    public UserDto findByLogin(String email) {
        User user = userRepository.findByEmail(email);
        return toUserDto(user);
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

    private UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getCustomerId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setRole(user.getRole().name());

        return userDto;
    }

    // Check if user exists
    public boolean isUserExists(Long userId) {
        return userRepository.existsById(userId);
    }

    public User getUserById(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get Full user details
    public UserReponseDto getFullUserDetails(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return toUserResponseDto(user.get());
        } else {
            throw new AppException("User not found", HttpStatus.NOT_FOUND);
        }
    }

    public Integer deleteUser(Long id) {
        try{
            userRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            System.out.println("Error :: " + e.getMessage());
            return -1;
        }
    }
}
