package com.example.farmingholiday.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HomePageDto {
    private List<BlockFarmingHolidayDto> farmingHolidays;
    private List<BlockHouseDto> houses;
    private List<BlockHostDto> hosts;
}