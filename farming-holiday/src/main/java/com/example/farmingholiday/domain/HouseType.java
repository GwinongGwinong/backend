package com.example.farmingholiday.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class HouseType {

    @Id
    private long id;

    @Setter
    @Column(nullable = false,length = 50)
    private String name;

    @Setter
    @ManyToOne(optional = false)
    private FarmingHoliday house;

    @Setter
    @Column(nullable = false)
    private long area;

    @Setter
    private double rate;

    @Setter
    @Column(length = 200)
    private String roomFacilities;

    @Setter
    @Column(length = 200)
    private String outFacilities;
}
