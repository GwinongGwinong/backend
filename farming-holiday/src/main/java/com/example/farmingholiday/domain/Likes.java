package com.example.farmingholiday.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Likes { //TODO: 짜긴 했지만 확신 x
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @ManyToOne(optional = false)
    private Guest guest;

    @Setter
    @Column(nullable = false)
    private int likeType;

    @Setter
    @OneToOne
    private House house;

    @Setter
    @OneToOne
    private Host host;

    @Setter
    @OneToOne
    private FarmingHoliday farmingHoliday;
}
