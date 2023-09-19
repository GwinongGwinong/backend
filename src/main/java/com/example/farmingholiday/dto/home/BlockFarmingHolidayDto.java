package com.example.farmingholiday.dto.home;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.dto.type.RecruitStatus;
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
    private long id;
    private boolean isLike;

    static public BlockFarmingHolidayDto from(FarmingHoliday entity, boolean isLike){
        return BlockFarmingHolidayDto.builder()
            .name(entity.getName())
            .location(entity.getLocation())
            .recruitStartDate(entity.getRecruitStartDate())
            .recruitEndDate(entity.getRecruitEndDate())
            .pay(entity.getPay())
            .payMonths(entity.getPayMonths())
            .rate(entity.getRate())
            .recruitStatus(entity.getRecruitStatus())
            .id(entity.getId())
            .isLike(isLike)
            .build();
    }
}