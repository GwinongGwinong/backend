package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.HomePageDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class HomeController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;
    @Autowired
    public HomeController(FarmingHolidayService farmingHolidayService, HostService hostService, HouseService houseService) {
        this.farmingHolidayService = farmingHolidayService;
        this.hostService = hostService;
        this.houseService = houseService;
    }

    //TODO: 리뷰 평점 높은 순으로 정렬해서 리턴
    @GetMapping
    public HomePageDto getHomeInfo(){
        HomePageDto homePageDto = new HomePageDto(
                farmingHolidayService.getBlockFarmingHolidays(),
                houseService.getBlockHouses(),
                hostService.getBlockHost()
        );
        return homePageDto;
    }
}