package com.example.farmingholiday.dto.guest;

import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.BlockHouseDto;
import com.example.farmingholiday.dto.guest.MyPageGuestDto;
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
public class MyPageLikesDto { // 내 정보와 좋아요 목록을 묶는 dto
  private MyPageGuestDto myPageGuestDto;
  private List<BlockFarmingHolidayDto> farmingHolidayLikes;
  private List<BlockHouseDto> houseLikes;
  private List<BlockHostDto> hostLikes;
}
