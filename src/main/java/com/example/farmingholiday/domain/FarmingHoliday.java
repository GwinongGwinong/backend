package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.RecruitStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

// 데이터 : 이름, 지역, 주소, 신청기간, 근무기간, 근무요일, 근무시간, 모집인원, 신청인원, 월급, 개월 수, 근무지 주소, 메인 이미지, 상세 이미지

@Getter
@Entity
public class FarmingHoliday {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //TODO: erd에 호스트에 대한 연관관계가 없음 -> 추가 완료
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
    @Column(nullable = false)
    private long pay;

    @Setter
    @Column(nullable = false)
    private long payMonths;

    @Setter
    @Column(nullable = false, length = 200)
    private String mainImagePath;

    @Setter
    @Column(nullable = false, length = 200)
    private String detailImagePath;

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
    @Column(length = 50)
    private String workTime;

    @Setter
    @Column(nullable = false)
    private long recruitNumber;

    @Setter
    @Column(nullable = false)
    private long applyNumber;

    @Setter
    @Column
    @Enumerated(EnumType.STRING)
    private RecruitStatus recruitStatus = RecruitStatus.ON_GOING;

    @Setter
    @Column(nullable = false, length = 10000)
    private String explanation;

    @Setter
    @Column(nullable = false, length = 50)
    private String lat;

    @Setter
    @Column(nullable = false, length = 50)
    private String lon;

    @Setter
    private double rate;

    @OneToMany
    private List<House> houses;
}