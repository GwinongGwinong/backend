package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.BlockHouseDto;
import com.example.farmingholiday.dto.FarmingHolidayDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController("/api/list")
public class ListController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;

    @GetMapping("/farming-holiday")
    public List<BlockFarmingHolidayDto> getFarmingHolidayList(){
        return farmingHolidayService.getBlockFarmingHolidays();
    }

    @GetMapping("/house")
    public List<BlockHouseDto> getHouseList(){
        return houseService.getBlockHouses();
    }

    @GetMapping("/host")
    public List<BlockHostDto> getHostList(){
        return hostService.getBlockHost();
    }
}