package com.tradeconnect.tradeconnectapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserReponseDto {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;
        private String role;
}
