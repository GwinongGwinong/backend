package com.example.farmingholiday.domain;


import com.example.farmingholiday.dto.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String imagePath;

    @Column
    private long reviews;

    @Column
    private long workedDays;

    @Column
    private long earnings;

    @OneToMany(mappedBy = "guest")
    private List<FarmingHolidayGuest> farmingHolidayGuests;

    public Guest(String email, String password, String name, String birth, String phoneNumber, String address, String imagePath) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.imagePath = imagePath;
    }

    public Guest() {}

    public static Guest of(String email, String password, String name, String birth, String phoneNumber, String address, String imagePath) {
        return new Guest(email, password, name, birth, phoneNumber, address, imagePath);
    }
}