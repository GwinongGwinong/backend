package com.example.farmingholiday.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailPageDto {
    private FarmingHolidayDto farmingHoliday;
    private List<HouseDto> house;
    private HostDto host;
}
