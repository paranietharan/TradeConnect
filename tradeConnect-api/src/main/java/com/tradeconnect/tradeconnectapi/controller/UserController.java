package com.tradeconnect.tradeconnectapi.controller;

import com.tradeconnect.tradeconnectapi.dto.UserReponseDto;
import com.tradeconnect.tradeconnectapi.exceptions.AppException;
import com.tradeconnect.tradeconnectapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserReponseDto> getUser(@PathVariable Long id) {
        try {
            UserReponseDto user = userService.getUser(id);
            return ResponseEntity.ok(user);
        } catch (AppException e) {
            return ResponseEntity.status(e.getStatus()).body(null);
        }
    }

    @GetMapping("/{id}/full")
    public ResponseEntity<UserReponseDto> getFullUser(
            @PathVariable Long id
    ) {
        try {
            UserReponseDto user = userService.
                    getFullUserDetails(id);
            return ResponseEntity.ok(user);
        } catch (AppException e) {
            return ResponseEntity.status(e.getStatus()).body(null);
        }
    }
}
