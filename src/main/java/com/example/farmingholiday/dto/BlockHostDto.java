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
    private String name; //TODO : 해당 속성과 Mapping 되는 값이 Host entity에 존재하지 않음
    private List<String> hashtags; //TODO : Host entity에서는 HashTag 클래스로 값을 저장하지만 이 클래스에선 String으로 받고 있음
    private double rate;

    static public BlockHostDto from(Host entity){
        return new BlockHostDto(
                "김호떡",
                List.of("hashtags"),
                entity.getRate()
        );
    }
}