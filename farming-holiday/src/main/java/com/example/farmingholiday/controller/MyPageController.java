package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.MyPageGuestDto;
import com.example.farmingholiday.dto.MyPageHostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mypage")
public class MyPageController {
    //TODO: 이런거 원래 토큰으로 자기 정보 조회하게 하는 것 같은데 어떻게 하는건지 몰라서 그냥 id 넘겨주게 했습니다ㅠ
    @GetMapping("/guest/{id}")
    public MyPageGuestDto getGuestMyPageInfo(@PathVariable String id){
        return MyPageGuestDto.builder().build();
    }

    @GetMapping("/host/{id}")
    public MyPageHostDto getHostMyPageInfo(@PathVariable String id){
        return MyPageHostDto.builder().build();
    }
}