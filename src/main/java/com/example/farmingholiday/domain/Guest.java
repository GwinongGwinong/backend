package com.example.farmingholiday.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
public class Guest {
    @OneToOne
    private Users users;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @Column
    private long reviews;

    @Setter
    @Column
    private long workedDays;

    @Setter
    @Column
    private long earnings;

    @OneToMany
    private List<FarmingHolidayGuest> farmingHolidayGuests;
}