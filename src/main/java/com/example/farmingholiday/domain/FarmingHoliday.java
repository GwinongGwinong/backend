package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.RecruitStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// 데이터 : 이름, 지역, 주소, 신청기간, 근무기간, 근무요일, 근무시간, 모집인원, 신청인원, 월급, 개월 수, 근무지 주소, 메인 이미지, 상세 이미지

@Getter
@Setter
@Entity
public class FarmingHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Host host;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 200)
    private String location;

    @Column(nullable = false, length = 200)
    private String address;

    @Column(nullable = false)
    private long pay;

    @Column(nullable = false)
    private long payMonths;

    @Column(nullable = false)
    private String mainImagePath;

    @Column(nullable = false)
    private String detailImagePath;

    @Column(nullable = false)
    private LocalDateTime recruitStartDate;

    @Column(nullable = false)
    private LocalDateTime recruitEndDate;

    @Column(nullable = false)
    private LocalDateTime workStartDate;

    @Column(nullable = false)
    private LocalDateTime workEndDate;

    @Column(nullable = false)
    private String workWeekday;

    @Column(nullable = false)
    private String workTime;

    @Column(nullable = false)
    private long recruitNumber;

    @Column(nullable = false)
    private long applyNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private RecruitStatus recruitStatus = RecruitStatus.ON_GOING;

    @Column(nullable = false, length = 10000)
    private String explanation;

    @Column(nullable = false)
    private String lat;

    @Column(nullable = false)
    private String lon;

    private double rate;

    @OneToMany(mappedBy = "farmingHoliday")
    private List<House> houses;

    public FarmingHoliday(){}

    public FarmingHoliday(String name, String location, String address, long pay, long payMonths) {
        this.name = name;
        this.location = location;
        this.address = address;
        this.pay = pay;
        this.payMonths = payMonths;
    }
}