package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.BlockHouseDto;
import com.example.farmingholiday.dto.DetailPageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController("/list")
public class ListController {
    @GetMapping("/farming-holiday")
    public List<BlockFarmingHolidayDto> getFarmingHolidayList(){
        List<BlockFarmingHolidayDto> farmingHolidays = new ArrayList<>();
        return farmingHolidays;
    }

    @GetMapping("/house")
    public List<BlockHouseDto> getHouseList(){
        List<BlockHouseDto> houses = new ArrayList<>();
        return houses;
    }

    @GetMapping("/host")
    public List<BlockHostDto> getHostList(){
        List<BlockHostDto> hosts = new ArrayList<>();
        return hosts;
    }
}