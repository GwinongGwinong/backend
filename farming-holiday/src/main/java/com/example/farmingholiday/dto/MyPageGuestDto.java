package com.example.farmingholiday.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageGuestDto {
    private int reviewCounts;
    private int workDays;
    private int earnings;
    private List<BlockFarmingHolidayDto> farmingHolidayLikes;
    private List<BlockHouseDto> houseLikes;
    private List<BlockHostDto> hostLikes;
    //TODO : 이 둘을 묶어서 전달할 dto 필요
    private List<BlockFarmingHolidayDto> appliedHolidays;
    private List<ApprovalStatus> approvalStatuses;
}