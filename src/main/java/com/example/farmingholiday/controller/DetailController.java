package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.DetailPageDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;

    @Autowired
    public DetailController(FarmingHolidayService farmingHolidayService, HostService hostService, HouseService houseService) {
        this.farmingHolidayService = farmingHolidayService;
        this.hostService = hostService;
        this.houseService = houseService;
    }

    @GetMapping("farming-holiday/detailed-info/{id}")
    public DetailPageDto getDetailedInfo(@PathVariable String id){
        return new DetailPageDto(
                farmingHolidayService.getFarmingHoliday(Long.parseLong(id)),
                houseService.getHouse(Long.parseLong(id)),
                hostService.getHost(Long.parseLong(id))
                );
    }
}
