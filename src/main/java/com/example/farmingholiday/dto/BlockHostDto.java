package com.example.farmingholiday.dto;

import com.example.farmingholiday.domain.Hashtag;
import com.example.farmingholiday.domain.Host;
import lombok.*;

import java.util.List;

// 호스트 미리보기를 위한 정보를 담은 객체
// 이름 / 해시테크 / 리뷰 수
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlockHostDto {
    private String name;
    private List<String> hashtags;
    private double rate;

    static public BlockHostDto from(Host entity, List<String> hashtags){
        return BlockHostDto.builder()
            .name(entity.getName())
            .hashtags(hashtags)
            .rate(entity.getRate())
            .build();
    }
}