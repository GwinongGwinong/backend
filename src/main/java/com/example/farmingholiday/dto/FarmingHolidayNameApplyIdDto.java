package com.example.farmingholiday.dto;

import com.example.farmingholiday.domain.Apply;
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
public class FarmingHolidayNameApplyIdDto { // 리뷰에 필요한 정보(파홀 이룸 & 신청 정보 id)
  private String farmingHolidayName;
  private Long applyId;

  static public FarmingHolidayNameApplyIdDto from(Apply entity){
    return FarmingHolidayNameApplyIdDto.builder()
        .farmingHolidayName(entity.getFarmingHoliday().getName())
        .applyId(entity.getId())
        .build();
  }
}
