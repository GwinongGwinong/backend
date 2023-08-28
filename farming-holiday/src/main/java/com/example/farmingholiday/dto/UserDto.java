package com.example.farmingholiday.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String email;
    private String password;
    private String name;
    private String birth;
    private String phoneNumber;
    private String address;
    private String detailAddress;
    private UserType userType;
}
