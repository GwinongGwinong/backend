package com.example.farmingholiday.dto.home;

import com.example.farmingholiday.domain.Review;
import com.example.farmingholiday.dto.ReviewDto;
import jakarta.persistence.Column;
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
public class BlockReviewDto {
  private String title;
  private String farmingHolidayName;

  static public BlockReviewDto from(Review entity){
    return BlockReviewDto.builder()
        .farmingHolidayName(entity.getFarmingHolidayGuestHouse().getFarmingHoliday().getName())
        .title(entity.getTitle())
        .build();
  }
}
