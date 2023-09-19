package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.home.BlockReviewDto;
import com.example.farmingholiday.dto.home.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.home.BlockHostDto;
import com.example.farmingholiday.dto.home.BlockHouseDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import com.example.farmingholiday.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ListController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;
    final private ReviewService reviewService;

    //TODO :페이징 처리 필요
    //TODO : geust id를 PathVariable이 아니라 @AuthenticationPrincipal로 받기
    @GetMapping("/api/list/farming-holiday/{guestId}")
    public List<BlockFarmingHolidayDto> getFarmingHolidayList(@PathVariable Long guestId){
        return farmingHolidayService.getBlockFarmingHolidays(guestId);
    }

    @GetMapping("/api/list/house/{guestId}")
    public List<BlockHouseDto> getHouseList(@PathVariable Long guestId){
        return houseService.getBlockHouses(guestId);
    }

    @GetMapping("/api/list/host/{guestId}")
    public List<BlockHostDto> getHostList(@PathVariable Long guestId){
        return hostService.getBlockHost(guestId);
    }

    @GetMapping("/api/list/review")
    public List<BlockReviewDto> getReviewList(){
        return reviewService.getBlockReview();
    }
}