package com.example.farmingholiday.dto.host;

import com.example.farmingholiday.domain.Host;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyPageHostDto {
    private String name;
    private Long reviewCounts;
    private double rate;

    public static MyPageHostDto from(Host entity){
        return MyPageHostDto.builder()
            .name(entity.getName())
            .reviewCounts(entity.getReviewCount())
            .rate(entity.getRate())
            .build();
    }
}