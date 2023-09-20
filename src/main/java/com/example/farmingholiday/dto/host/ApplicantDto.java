package com.example.farmingholiday.dto.host;

import java.time.LocalDateTime;
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
public class ApplicantDto {
  // 신청자 목록에서 '신청자 한명'에 해당하는 dto, [신청자 조회]와 [게스트 조회] 형식이 동일하므로 둘 다에 사용
  private String guestName;
  private String farmingHolidayName;
  private String houseName;
  private LocalDateTime rentStartDate;
  private LocalDateTime rentEndDate;
  private Long pay;
}