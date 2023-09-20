package com.example.farmingholiday.dto.host;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyPageApplicantDto {
  private MyPageHostDto myPageHostDto;
  private List<ApplicantDto> applicantDtoList;
  private int applicantNum;
}
