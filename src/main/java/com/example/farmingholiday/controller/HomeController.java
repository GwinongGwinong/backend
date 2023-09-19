package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.home.HomePageDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import com.example.farmingholiday.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;
    final private ReviewService reviewService;

    // 리뷰 높은 순으로 3,3,4,6개씩 리턴
    @GetMapping("/api/home/{guestId}")
    public HomePageDto getHomeInfo(@PathVariable Long guestId){
        HomePageDto homePageDto = new HomePageDto(
                farmingHolidayService.get3BlockFarmingHolidays(guestId),
                houseService.get3BlockHouses(),
                hostService.get4BlockHost(),
                reviewService.get6BlockReview()
        );
        return homePageDto;
    }
}