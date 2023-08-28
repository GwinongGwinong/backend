package com.example.farmingholiday.dto;

import lombok.*;

import java.time.LocalDateTime;

// 상세페이지 - 파홀
// 데이터 : 이름, 지역, 주소, 신청기간, 근무기간, 근무요일, 근무시간, 지원자 현황, 월급과 개월 수,
// 평점, 모집 상태, 설명, 위경도
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FarmingHolidayDto {
    private String name;
    private String location;
    private String address;
    private LocalDateTime recruitStartDate;
    private LocalDateTime recruitEndDate;
    private LocalDateTime workStartDate;
    private LocalDateTime workEndDate;
    private String workWeekday;
    private String workTime;
    private long recruitNumber;
    private long applyNumber;
    private long pay;
    private long payMonths;
    private double rate;
    private RecruitStatus recruitStatus;
    private String explanation;
    private String lat;
    private String lon;
}