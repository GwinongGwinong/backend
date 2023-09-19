package com.example.farmingholiday.dto.guest;

import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.type.ApprovalStatus;
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
public class BlockApplyDto { // 파홀 블럭과 상태를 묶는 dto
  private BlockFarmingHolidayDto appliedFarmingHoliday;
  private ApprovalStatus approvalStatus;
}
