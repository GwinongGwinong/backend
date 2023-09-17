package com.example.farmingholiday.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<FarmingHolidayGuest> farmingHolidayGuest;

    @OneToMany
    private List<Hashtag> hashtags;

    @OneToMany
    private List<FarmingHoliday> farmingHolidays;

    @OneToMany
    private List<House> houses;

    @Column(nullable = false)
    private String email;

    @Setter
    @Column(nullable = false)
    private String password;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false)
    private String birth;

    @Setter
    @Column(nullable = false)
    private String phoneNumber;

    @Setter
    @Column(nullable = false)
    private String address;

    @Setter
    @Column(nullable = false, length = 200)
    private String imagePath;

    @Column
    private double rate;

    @Column(length = 10000)
    private String explanation;
}