package com.example.farmingholiday.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageLikesDto {
  private MyPageGuestDto myPageGuestDto;
  private List<BlockFarmingHolidayDto> farmingHolidayLikes;
  private List<BlockHouseDto> houseLikes;
  private List<BlockHostDto> hostLikes;
}
