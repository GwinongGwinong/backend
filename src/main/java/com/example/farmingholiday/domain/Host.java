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

    @Column(columnDefinition ="DOUBLE DEFAULT 0")
    private double rate;

    @Column(columnDefinition ="BIGINT DEFAULT 0")
    private Long reviewCount;

    @Column(length = 10000)
    private String explanation;

    @OneToMany(mappedBy = "host")
    private List<FarmingHoliday> farmingHolidays;
}