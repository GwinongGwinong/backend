package com.example.farmingholiday.dto;

import com.example.farmingholiday.domain.Hashtag;
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
}