package com.example.farmingholiday.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Likes {
    @Id
    private long id;

    @Setter
    @ManyToOne(optional = false)
    private Guest guest;

    @Setter
    @Column(nullable = false)
    private int likeType;

    @Setter
    @OneToOne(optional = false)
    private House house;

    @Setter
    @OneToOne(optional = false)
    private Host host;

    @Setter
    @OneToOne(optional = false)
    private FarmingHoliday farmingHoliday;
}
