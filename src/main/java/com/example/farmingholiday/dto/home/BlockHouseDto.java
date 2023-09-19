package com.example.farmingholiday.dto.home;

import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.dto.type.RecruitStatus;
import lombok.*;

import java.time.LocalDateTime;

// 숙소 미리보기에 필요한 정보만 담은 객체
// 데이터 : 이름, 평점, 지역, 호스트 이름, 시작과 끝 날짜, 월세, 개월, 모집 상태
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlockHouseDto {
    private String name;
    private double rate;
    private String location;
    private String hostName;
    private LocalDateTime rentStartDate;
    private LocalDateTime rentEndDate;
    private long rent;
    private long rentMonths;
    private RecruitStatus recruitStatus;
    private long id;
    private boolean isLike;

    static public BlockHouseDto from(House entity, String hostName, boolean isLike){
        return new BlockHouseDto(
                entity.getName(),
                entity.getRate(),
                entity.getLocation(),
                hostName,
                entity.getRentStartDate(),
                entity.getRentEndDate(),
                entity.getRent(),
                entity.getRentMonths(),
                entity.getRecruitStatus(),
                entity.getId(),
                isLike
        );
    }
}
