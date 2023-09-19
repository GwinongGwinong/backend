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
public class MyPageApplyDto {
  private MyPageGuestDto myPageGuestDto;
  private List<BlockApplyDto> blockApplyDtoList;
}
