package com.example.farmingholiday.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Guest {
    @Id
    private long id;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private LocalDateTime birth;

    @Column(nullable = false, length = 200)
    private String email;

    @Column(length = 50)
    private String phoneNumber;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(length = 100)
    private String detailAddress;

    private long reviews;

    private long workedDays;

    private long earnings;

    @ManyToOne
    private House house;
}
