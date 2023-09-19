package com.example.farmingholiday.dto;

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
public class ApplyFarmingHolidayDto {
  private MyPageGuestDto myPageGuestDto;
  private List<BlockFarmingHolidayDto> appliedHolidays;
  private List<ApprovalStatus> approvalStatuses;
}
