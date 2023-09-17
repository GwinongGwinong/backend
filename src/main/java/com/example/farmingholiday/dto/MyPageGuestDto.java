package com.example.farmingholiday.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageGuestDto { //TODO:이런식의 DTO를 관리하기 위해선 Host와 User를 따로두는 편이 속도에서나 코드 복잡성에서나 더 좋다고 판단, 호스트와 유저를 분리하는 방향으로 상의 해보기
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