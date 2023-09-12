package com.example.farmingholiday.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Entity
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private Users users;

    @OneToMany
    private List<FarmingHolidayGuest> farmingHolidayGuest;

    @Setter
    @OneToMany(orphanRemoval = false)
    private List<Hashtag> hashtags;

    @Setter
    @OneToMany(orphanRemoval = false)
    private List<FarmingHoliday> farmingHolidays;

    @Setter
    @OneToMany(orphanRemoval = false)
    private List<House> houses;

    @Setter
    @Column
    private double rate;

    @Setter
    @Column(length = 10000)
    private String explanation;
}