package com.tradeconnect.tradeconnectapi.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private String token;
}
