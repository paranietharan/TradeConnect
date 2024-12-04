package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.config.UserAuthenticationProvider;
import com.tradeconnect.tradeconnectapi.dto.CredentialsDto;
import com.tradeconnect.tradeconnectapi.dto.SignUpDto;
import com.tradeconnect.tradeconnectapi.dto.User.UserDto;
import com.tradeconnect.tradeconnectapi.model.Verification;
import com.tradeconnect.tradeconnectapi.repository.VerificationRepository;
import com.tradeconnect.tradeconnectapi.service.UserService;
import com.tradeconnect.tradeconnectapi.service.VerificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserService userService;
    private final UserAuthenticationProvider userAuthenticationProvider;
    private final VerificationService verificationService;
    private final VerificationRepository verificationRepository;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setToken(userAuthenticationProvider.createToken(userDto.getEmail(), userDto.getRole()));
        return ResponseEntity.ok(userDto);
    }

    // Endpoint to register a new user
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid SignUpDto signUpDto) {
        String pin = verificationService.generateVerificationPin();
        verificationService.sendVerificationEmail(signUpDto.getEmail(), pin);

        Verification verification = new Verification();
        verification.setEmail(signUpDto.getEmail());
        verification.setPin(pin);
        verification.setFirstName(signUpDto.getFirstName());
        verification.setLastName(signUpDto.getLastName());
        verification.setPassword(signUpDto.getPassword());
        verificationRepository.save(verification);

        return ResponseEntity.ok("Verification email sent");
    }

    // Endpoint to verify email and pin
    @PostMapping("/verify")
    public ResponseEntity<UserDto> verify(@RequestParam String email, @RequestParam String pin) {
        Verification verification = verificationRepository.findById(email).orElseThrow(() -> new RuntimeException("Invalid email or pin"));
        if (!verification.getPin().equals(pin)) {
            throw new RuntimeException("Invalid email or pin");
        }

        SignUpDto signUpDto = new SignUpDto();
        signUpDto.setEmail(verification.getEmail());
        signUpDto.setFirstName(verification.getFirstName());
        signUpDto.setLastName(verification.getLastName());
        signUpDto.setPassword(verification.getPassword());

        UserDto userDto = userService.register(signUpDto);
        verificationRepository.delete(verification);

        return ResponseEntity.ok(userDto);
    }

    // Endpoint to resend verification email
    @PostMapping("/resend-verification")
    public ResponseEntity<String> resendVerification(@RequestParam String email) {
        Verification verification = verificationRepository.findById(email).orElseThrow(() -> new RuntimeException("Invalid email"));
        verification.setPin(verificationService.generateVerificationPin());
        verificationRepository.save(verification);
        verificationService.sendVerificationEmail(email, verification.getPin());
        return ResponseEntity.ok("Verification email sent");
    }

    // Endpoint to logout
    @PostMapping("revoke-token")
    public ResponseEntity<String> revokeToken(@RequestParam String token) {
        userAuthenticationProvider.revokeToken(token);
        return ResponseEntity.ok("Token revoked");
    }
}
