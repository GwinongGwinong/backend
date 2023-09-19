package com.example.farmingholiday.dto.guest;

import com.example.farmingholiday.domain.Guest;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageGuestDto { // 내 정보 dto
    private String name;
    private Long reviewCounts;
    private Long workDays;
    private Long earnings;

    public static MyPageGuestDto from(Guest entity){
        return MyPageGuestDto.builder()
            .name(entity.getName())
            .reviewCounts(entity.getReviewCount())
            .workDays(entity.getWorkedDays())
            .earnings(entity.getEarnings())
            .build();
    }
}