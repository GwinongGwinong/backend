package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.guest.MyPageApplyDto;
import com.example.farmingholiday.dto.guest.MyPageGuestDto;
import com.example.farmingholiday.dto.guest.MyPageLikesDto;
import com.example.farmingholiday.service.GuestMyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GuestMyPageController {
    //TODO: 추후에 authentication이 추가되면 권한에 따라 출력해주는 페이지가 달라지게 설정
    //TODO: 추후에 인증까지 완료하면 id를 PathVariable이 아니라 @AuthenticationPrincipal로 받기
    private final GuestMyPageService guestMyPageService;

    @GetMapping("/api/guest/my-page/{id}")
    public MyPageGuestDto getGuestInfo(@PathVariable Long id){
        return guestMyPageService.getGuestInfo(id);
    }

    @GetMapping("/api/guest/my-page/likes/{id}")
    public MyPageLikesDto getLikesInfo(@PathVariable Long id){
        return guestMyPageService.getLikesInfo(id);
    }

    @GetMapping("/api/guest/my-page/apply/{id}")
    public MyPageApplyDto getApplyInfo(@PathVariable Long id){
        return guestMyPageService.getApplyInfo(id);
    }

}