package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.MyPageGuestDto;
import com.example.farmingholiday.dto.MyPageHostDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mypage")
public class MyPageController {
    //TODO: 추후에 authentication이 추가되면 권한에 따라 출력해주는 페이지가 달라지게 설정
    //
    @GetMapping("/guest/{id}")
    public MyPageGuestDto getGuestMyPageInfo(@PathVariable String id){
        return MyPageGuestDto.builder().build();
    }

    @GetMapping("/host/{id}")
    public MyPageHostDto getHostMyPageInfo(@PathVariable String id){
        return MyPageHostDto.builder().build();
    }
}