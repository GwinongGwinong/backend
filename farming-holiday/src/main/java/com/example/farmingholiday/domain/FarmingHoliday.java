package com.example.farmingholiday.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Entity
public class FarmingHoliday {
    @Id
    private long id;

    //TODO: erd에 호스트에 대한 연관관계가 없음

    @Setter
    @Column(nullable = false, length = 50)
    private String name;

    @Setter
    @Column(nullable = false, length = 200)
    private String localation;

    @Setter
    @Column(nullable = false, length = 200)
    private String address;

    @Setter
    private double rate;

    @Setter
    @Column(nullable = false)
    private long pay;

    @Setter
    @Column(nullable = false, length = 50)
    private String payUnit;

    @Setter
    @Column(nullable = false, length = 200)
    private String imagePath;

    @Setter
    private LocalDateTime recruitStartDate;

    @Setter
    private LocalDateTime recruitEndDate;

    @Setter
    private LocalDateTime workStartDate;

    @Setter
    private LocalDateTime workEndDate;

    @Setter
    @Column(length = 50)
    private String workWeekday;

    @Setter
    @Column(nullable = false)
    private long recruitNumber;

    @Setter
    @Column(nullable = false)
    private LocalDateTime residenceDate;

    @Setter
    private long applyNumber = 0;

    @Setter
    @Column(nullable = false, length = 50)
    private String lat;

    @Setter
    @Column(nullable = false, length = 50)
    private String lon;

    @OneToMany
    private List<HouseType> houseTypes;
}
