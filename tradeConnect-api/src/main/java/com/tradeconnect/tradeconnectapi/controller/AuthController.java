package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.config.UserAuthenticationProvider;
import com.tradeconnect.tradeconnectapi.dto.CredentialsDto;
import com.tradeconnect.tradeconnectapi.dto.SignUpDto;
import com.tradeconnect.tradeconnectapi.dto.UserDto;
import com.tradeconnect.tradeconnectapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class AuthController {
    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getEmail(), userDto.getRole()));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto signUpDto) {
        UserDto userDto = userService.register(signUpDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getEmail(), userDto.getRole()));
        return ResponseEntity.ok(userDto);
    }
}
