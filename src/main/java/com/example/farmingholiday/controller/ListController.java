package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.home.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.home.BlockHostDto;
import com.example.farmingholiday.dto.home.BlockHouseDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ListController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;

    //TODO :페이징 처리 필요
    @GetMapping("/api/list/farming-holiday")
    public List<BlockFarmingHolidayDto> getFarmingHolidayList(){
        return farmingHolidayService.getBlockFarmingHolidays();
    }

    @GetMapping("/api/list/house")
    public List<BlockHouseDto> getHouseList(){
        return houseService.getBlockHouses();
    }

    @GetMapping("/api/list/host")
    public List<BlockHostDto> getHostList(){
        return hostService.getBlockHost();
    }
}