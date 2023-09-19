package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.BlockApplyDto;
import com.example.farmingholiday.dto.MyPageApplyDto;
import com.example.farmingholiday.dto.MyPageGuestDto;
import com.example.farmingholiday.dto.MyPageHostDto;
import com.example.farmingholiday.dto.MyPageLikesDto;
import com.example.farmingholiday.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MyPageController {
    //TODO: 추후에 authentication이 추가되면 권한에 따라 출력해주는 페이지가 달라지게 설정
    //TODO: 추후에 인증까지 완료하면 id를 PathVariable이 아니라 @AuthenticationPrincipal로 받기

    private final MyPageService myPageService;

    @GetMapping("/api/guest/my-page/{id}")
    public MyPageGuestDto getGuestMyPageInfo(@PathVariable Long id){
        return myPageService.getGuestMyPageInfo(id);
    }

    @GetMapping("/api/guest/my-page/likes/{id}")
    public MyPageLikesDto getGuestLikesInfo(@PathVariable Long id){
        return myPageService.getGuestLikesInfo(id);
    }

    @GetMapping("/api/guest/my-page/apply/{id}")
    public MyPageApplyDto getGuestApplyInfo(@PathVariable Long id){
        return myPageService.getGuestApplyInfo(id);
    }

    @GetMapping("/api/host/my-page/{id}")
    public MyPageHostDto getHostMyPageInfo(@PathVariable Long id){
        return MyPageHostDto.builder().build();
    }
}