package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Apply;
import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.domain.Review;
import com.example.farmingholiday.dto.FarmingHolidayNameApplyIdDto;
import com.example.farmingholiday.dto.ReviewDto;
import com.example.farmingholiday.dto.ReviewInputDto;
import com.example.farmingholiday.dto.home.BlockReviewDto;
import com.example.farmingholiday.dto.type.ApprovalStatus;
import com.example.farmingholiday.repository.ApplyRepository;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import com.example.farmingholiday.repository.GuestRepository;
import com.example.farmingholiday.repository.HostRepository;
import com.example.farmingholiday.repository.HouseRepository;
import com.example.farmingholiday.repository.ReviewRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

  private final ReviewRepository reviewRepository;
  private final GuestRepository guestRepository;
  private final FarmingHolidayRepository farmingHolidayRepository;
  private final ApplyRepository applyRepository;
  private final HostRepository hostRepository;
  private final HouseRepository houseRepository;

  public List<BlockReviewDto> getBlockReview() {
    List<Review> reviews = reviewRepository.findAll();
    return reviews.stream()
        .map(BlockReviewDto::from)
        .collect(Collectors.toList());
  }

  public List<BlockReviewDto> get6BlockReview() {
    List<Review> reviews = reviewRepository.findTop6ByOrderByTime();
    return reviews.stream()
        .map(BlockReviewDto::from)
        .collect(Collectors.toList());
  }

  public ReviewDto getDetailReview(Long id) {
    Review review = reviewRepository.findById(id).orElse(null);
    return ReviewDto.from(review);
  }

  public List<FarmingHolidayNameApplyIdDto> getInfoForReview(Long guestId) {
    Guest guest = guestRepository.findById(guestId).orElse(null);
    List<Apply> applies = applyRepository.findAllByGuestAndApprovalStatus(guest, ApprovalStatus.ACCEPTED);
    return applies.stream().map(FarmingHolidayNameApplyIdDto::from).collect(Collectors.toList());
  }

  public void saveReview(Long guestId, ReviewInputDto reviewInputDto) {
    Guest guest = guestRepository.findById(guestId).orElse(null);
    Apply apply = applyRepository.findById(reviewInputDto.getApplyId()).orElse(null);

    // update farmingHoliday rate
    FarmingHoliday farmingHoliday = apply.getFarmingHoliday();
    farmingHoliday.setRate(updateRate(farmingHoliday.getRate(),
        reviewInputDto.getFarmingHolidayRate(), farmingHoliday.getReviewCount()));
    farmingHoliday.setReviewCount(farmingHoliday.getReviewCount()+1);
    farmingHolidayRepository.save(farmingHoliday);

    // update host rate
    Host host = farmingHoliday.getHost();
    host.setRate(updateRate(host.getRate(), reviewInputDto.getHostRate(), host.getReviewCount()));
    host.setReviewCount(host.getReviewCount()+1);
    hostRepository.save(host);

    // update house rate
    House house = apply.getHouse();
    house.setRate(updateRate(house.getRate(), reviewInputDto.getHouseRate(), house.getReviewCount()));
    house.setReviewCount(house.getReviewCount()+1);
    houseRepository.save(house);

    // update guest review count
    guest.setReviewCount(guest.getReviewCount()+1);
    guestRepository.save(guest);

    // save review
    reviewRepository.save(Review.builder()
        .guestName(guest.getName())
        .apply(apply)
        .title(reviewInputDto.getTitle())
        .content(reviewInputDto.getContent())
        .time(LocalDateTime.now())
        .farmingHolidayRate(reviewInputDto.getFarmingHolidayRate())
        .HostRate(reviewInputDto.getHostRate())
        .HouseRate(reviewInputDto.getHouseRate())
        .build());
  }

  private double updateRate(double originRate, double newRate, long number){
    return (originRate*number + newRate)/(double) (number+1);
  }


}
