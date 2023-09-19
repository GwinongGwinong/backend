package com.example.farmingholiday.dto.guest;

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
public class MyPageApplyDto { // 내 정보와 신청한 파홀블럭들의 리스트를 묶는 dto
  private MyPageGuestDto myPageGuestDto;
  private List<BlockApplyDto> blockApplyDtoList;
  private int applyNum;
}
