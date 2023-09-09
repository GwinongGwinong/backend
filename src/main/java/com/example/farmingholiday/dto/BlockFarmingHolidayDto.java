package com.example.farmingholiday.dto;

import lombok.*;

import java.time.LocalDateTime;

// 파홀 미리보기 블럭에 필요한 정보만 담은 객체
// 이름 / 지역 / 일 시작과 끝 / 월급과 개월 수 / 평점 / 모집 상태
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlockFarmingHolidayDto {
    private String name;
    private String location;
    private LocalDateTime recruitStartDate;
    private LocalDateTime recruitEndDate;
    private long pay;
    private long payMonths;
    private double rate;
    private RecruitStatus recruitStatus;
}