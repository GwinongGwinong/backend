package com.example.farmingholiday.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInDto {
    private String email;
    private String password;
}
