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
    private HouseDto house;
    private HostDto host;
}
