package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.RecruitStatus;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// 데이터 : 몇인실인지, 이름, 지역, 주소, 숙박 시작과 끝, 숙박 기간(개월), 월세, 객실 형태, 면적, 객실시설, 부대시설, 평점, 호스트

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    @ManyToOne(optional = false)
    private Host host;

    @Setter
    @ManyToOne(optional = false)
    private FarmingHoliday farmingHoliday;

    @Setter
    @Column(nullable = false, length = 50)
    private String name;

    @Setter
    @Column(nullable = false, length = 200)
    private String location;

    @Setter
    @Column(nullable = false, length = 200)
    private String imagePath;

    @Setter
    @Column(nullable = false)
    private long rent;

    @Setter
    @Column(nullable = false)
    private long rentMonths;

    @Setter
    @Column(nullable = false)
    private LocalDateTime rentStartDate;

    @Setter
    @Column(nullable = false)
    private LocalDateTime rentEndDate;

    @Setter
    @Column(nullable = false)
    private String houseType;

    @Setter
    @Column(nullable = false)
    private long area;

    @Setter
    @Column(nullable = false)
    private long capacity;

    @Setter
    @Column(length = 200)
    private String roomFacilities;

    @Setter
    @Column(length = 200)
    private String outFacilities;

    @Setter
    @Column(nullable = false, length = 200)
    private String address;

    @Setter
    @Column(nullable = false, length = 50)
    private String lat;

    @Setter
    @Column(nullable = false, length = 50)
    private String lon;

    @Setter
    @Column
    @Enumerated(EnumType.STRING)
    private RecruitStatus recruitStatus = RecruitStatus.ON_GOING;

    @Setter
    private double rate;

    @OneToMany
    private List<Guest> guests;
}