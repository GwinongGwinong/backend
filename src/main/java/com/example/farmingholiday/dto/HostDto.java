package com.example.farmingholiday.dto;

import com.example.farmingholiday.domain.Hashtag;
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
    private String name; // TODO : 해당 속성과 Mapping 되는 값이 Host entity에 존재하지 않음
    private List<String> hashtags; //TODO : Host entity에서는 HashTag 클래스로 값을 저장하지만 이 클래스에선 String으로 받고 있음
    private String explanation;
    private double rate;

    public static HostDto from(Host entity){
        return new HostDto(
                "김아무개",
                List.of("new hashtags"),
                entity.getExplanation(),
                entity.getRate()
        );
    }
}