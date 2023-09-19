package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.HomePageDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;

    // 리뷰 높은 순으로 3,3,4개씩 리턴하도록 바꿈
    @GetMapping("/api/home")
    public HomePageDto getHomeInfo(){
        HomePageDto homePageDto = new HomePageDto(
                farmingHolidayService.get3BlockFarmingHolidays(),
                houseService.get3BlockHouses(),
                hostService.get4BlockHost()
        );
        return homePageDto;
    }
}