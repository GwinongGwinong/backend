package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.FarmingHolidayNameApplyIdDto;
import com.example.farmingholiday.dto.ReviewDto;
import com.example.farmingholiday.dto.ReviewInputDto;
import com.example.farmingholiday.service.FarmingHolidayService;
import com.example.farmingholiday.service.ReviewService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReviewController {
  private final ReviewService reviewService;
  private final FarmingHolidayService farmingHolidayService;

  @GetMapping("/api/review/detail/{id}")
  public ReviewDto getDetailedReview(@PathVariable Long id){
    return reviewService.getDetailReview(id);
  }

  // 리뷰 작성 시 내려줘야 하는 정보
  // 파밍홀리데이의 이름과 신청 정보 id를 목록으로 - 이름 골라서 작성할 수 있게 (참고 : 피그마)
  // form 에서 활용 예시 : <optional value="{신청 정보 id}">{파홀 이름}</option>
  //TODO: 유저 아이디가 URI로 전달되는게 부자연스러우므로 인증 적용 후 @AuthenticationPrincipal 사용해서 수정 필요
  @GetMapping("/api/review/{guestId}")
  public List<FarmingHolidayNameApplyIdDto> getInfoForReview(@PathVariable Long guestId){
    return reviewService.getInfoForReview(guestId);
  }

  // 리뷰 저장 시 받아야 하는 정보
  // 1. 제목, 내용, 평점 2. 신청 정보 id - 평점 수정을 위해서
  //TODO: 유저 아이디가 URI로 전달되는게 부자연스러우므로 인증 적용 후 @AuthenticationPrincipal 사용해서 수정 필요
  @PostMapping("/api/review/{guestId}")
  public void saveReview(@PathVariable Long guestId, @RequestBody ReviewInputDto reviewInput){
    reviewService.saveReview(guestId, reviewInput);
  }
}
