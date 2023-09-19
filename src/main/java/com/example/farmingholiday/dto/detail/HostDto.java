package com.example.farmingholiday.dto.detail;

import com.example.farmingholiday.domain.Host;
import lombok.*;

import java.util.List;

// 상세페이지 - 호스트
// 이름 / 해시테크 / 리뷰 수
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HostDto {
    private String name;
    private List<String> hashtags;
    private String explanation;
    private double rate;

    public static HostDto from(Host entity, List<String> hashtags){
        return HostDto.builder()
            .name(entity.getName())
            .hashtags(hashtags)
            .explanation(entity.getExplanation())
            .rate(entity.getRate())
            .build();
    }
}