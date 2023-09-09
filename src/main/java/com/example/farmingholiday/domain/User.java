package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    private UserType userType = UserType.GUEST;

    @Setter
    @Column(nullable = false, length = 50)
    private String email;

    @Setter
    @Column(nullable = false, length = 50)
    private String password;

    @Setter
    @Column(nullable = false, length = 50)
    private String name;

    @Setter
    @Column(nullable = false)
    private String birth;

    @Setter
    @Column(length = 50)
    private String phoneNumber;

    @Setter
    @Column(nullable = false, length = 50)
    private String address;

    @Setter
    @Column(length = 100)
    private String detailAddress;

    @Setter
    @Column(nullable = false, length = 200)
    private String imagePath;
}