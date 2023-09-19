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

    @GetMapping("/api/farming-holiday/detailed-info/{faholId}/{guestId}")
    public DetailPageDto getDetailedInfo(@PathVariable Long faholId, @PathVariable Long guestId){ //TODO: 인증 후 수정
        return new DetailPageDto(
                farmingHolidayService.getFarmingHoliday(faholId, guestId),
                houseService.getDetailHouse(faholId, guestId),
                hostService.getDetailHost(faholId, guestId)
                );
    }
}
