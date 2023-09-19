package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.type.RecruitStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

// 데이터 : 몇인실인지, 이름, 지역, 주소, 숙박 시작과 끝, 숙박 기간(개월), 월세, 객실 형태, 면적, 객실시설, 부대시설, 평점, 호스트

@Getter
@Setter
@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    private FarmingHoliday farmingHoliday;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String imagePath;

    @Column(nullable = false)
    private long rent;

    @Column(nullable = false)
    private long rentMonths;

    @Column(nullable = false)
    private LocalDateTime rentStartDate;

    @Column(nullable = false)
    private LocalDateTime rentEndDate;

    @Column(nullable = false)
    private String houseType;

    @Column(nullable = false)
    private long area;

    @Column(nullable = false)
    private long capacity;

    @Column
    private String roomFacilities;

    @Column
    private String outFacilities;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String lat;

    @Column(nullable = false)
    private String lon;

    @Column
    @Enumerated(EnumType.STRING)
    private RecruitStatus recruitStatus = RecruitStatus.ON_GOING;

    @Column
    private double rate;

    @Column
    private Long reviewCount;
}