package com.example.farmingholiday.dto;

import com.example.farmingholiday.domain.Review;
import java.time.LocalDateTime;
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
public class ReviewDto {
    private String title;
    private String content;
    private String farmingHolidayName;
    private double farmingHolidayRate;
    private double hostRate;
    private double houseRate;
    private LocalDateTime time;

    static public ReviewDto from(Review entity){
      return ReviewDto.builder()
          .farmingHolidayName(entity.getFarmingHolidayGuestHouse().getFarmingHoliday().getName())
          .title(entity.getTitle())
          .content(entity.getContent())
          .farmingHolidayRate(entity.getFarmingHolidayRate())
          .hostRate(entity.getHostRate())
          .houseRate(entity.getHouseRate())
          .time(entity.getTime())
          .build();
    }
}
