package com.tradeconnect.tradeconnectapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDto {

    private String firstName;
    private String lastName;
    private String email;
    private char[] password;

}
