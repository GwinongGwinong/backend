package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.detail.DetailPageDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.HostService;
import com.example.farmingholiday.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DetailController {
    final private FarmingHolidayService farmingHolidayService;
    final private HostService hostService;
    final private HouseService houseService;

    @GetMapping("/api/farming-holiday/detailed-info/{id}")
    public DetailPageDto getDetailedInfo(@PathVariable Long id){ // Long 으로 바꿔도 괜찮은지 테스트하기
        return new DetailPageDto(
                farmingHolidayService.getFarmingHoliday(id),
                houseService.getDetailHouse(id),
                hostService.getDetailHost(id)
                );
    }
}
