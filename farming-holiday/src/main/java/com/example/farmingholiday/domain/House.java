package com.example.farmingholiday.domain;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.List;

@Entity
public class House {
    @Id
    private long id;

    @Setter
    @ManyToOne(optional = false)
    private Host host;

    @Setter
    @Column(nullable = false, length = 50)
    private String name;

    @Setter
    @Column(nullable = false, length = 200)
    private String location;

    @Setter
    @Column(nullable = false, length = 200)
    private String address;

    @Setter
    @Column(nullable = false, length = 200)
    private String imagePath;

    @Setter
    @Column(nullable = false)
    private long rent;

    @Setter
    @Column(nullable = false, length = 50)
    private String rentUnit;

    @Setter
    private double rate;

    @Setter
    @Column(nullable = false, length = 50)
    private String lat;

    @Setter
    @Column(nullable = false, length = 50)
    private String lon;

    @OneToMany
    private List<Guest> guests;
}
