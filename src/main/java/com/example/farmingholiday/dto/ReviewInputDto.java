package com.example.farmingholiday.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class ReviewInputDto {
  @NotBlank(message = "제목을 입력하세요.")
  private String title;
  @NotBlank(message = "내용을 입력하세요.")
  private String content;
  @NotEmpty(message = "파밍 홀리데이를 하나 고르세요.")
  private Long applyId;
  @NotEmpty(message = "파밍 홀리데이 평점을 입력하세요.")
  private double farmingHolidayRate;
  @NotEmpty(message = "호스트 평점을 입력하세요.")
  private double hostRate;
  @NotEmpty(message = "숙소 평점을 입력하세요.")
  private double houseRate;
}
