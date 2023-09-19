package com.example.farmingholiday.dto;

import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.dto.type.ApprovalStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageGuestDto {
    private String name;
    private Long reviewCounts;
    private Long workDays;
    private Long earnings;

    public static MyPageGuestDto from(Guest entity){
        return MyPageGuestDto.builder()
            .name(entity.getName())
            .reviewCounts(entity.getReviews())
            .workDays(entity.getWorkedDays())
            .earnings(entity.getEarnings())
            .build();
    }
}