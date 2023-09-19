package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.FarmingHolidayGuestHouse;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.dto.guest.BlockApplyDto;
import com.example.farmingholiday.dto.host.ApplicantDto;
import com.example.farmingholiday.dto.host.MyPageApplicantDto;
import com.example.farmingholiday.dto.host.MyPageHostDto;
import com.example.farmingholiday.dto.type.ApprovalStatus;
import com.example.farmingholiday.repository.FarmingHolidayGuestHouseRepository;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import com.example.farmingholiday.repository.HashtagRepository;
import com.example.farmingholiday.repository.HostRepository;
import com.example.farmingholiday.repository.LikeFarmingHolidayRepository;
import com.example.farmingholiday.repository.LikeHostRepository;
import com.example.farmingholiday.repository.LikeHouseRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostMyPageService {
  private final HostRepository hostRepository;
  private final LikeFarmingHolidayRepository likeFarmingHolidayRepository;
  private final LikeHouseRepository likeHouseRepository;
  private final LikeHostRepository likeHostRepository;
  private final HashtagRepository hashtagRepository;
  private final FarmingHolidayGuestHouseRepository farmingHolidayGuestHouseRepository;
  private final FarmingHolidayRepository farmingHolidayRepository;
  
  public MyPageHostDto getHostInfo(Long id) {
    Host host = hostRepository.findById(id).orElse(null);
    return MyPageHostDto.from(host);
  }

  public MyPageApplicantDto getApplicantInfo(Long id, int type) { // 0이면 신청자, 1이면 승인된 게스트
    Host host = hostRepository.findById(id).orElse(null);

    // 호스트가 관리하는 모든 파홀 리스트
    List<FarmingHoliday> farmingHolidays = farmingHolidayRepository.findAllByHost(host);

    // 신청자 정보 리스트
    List<ApplicantDto> applicantDtoList = new ArrayList<>();

    for(FarmingHoliday farmingHoliday : farmingHolidays){
      // 파홀-게스트-숙소 리스트
      List<FarmingHolidayGuestHouse> farmingHolidayGuests = farmingHolidayGuestHouseRepository.findAllByFarmingHoliday(farmingHoliday);

      // 목록에 필요한 정보 get
      for(FarmingHolidayGuestHouse farmingHolidayGuest : farmingHolidayGuests){
        if((type == 0 && farmingHolidayGuest.getApprovalStatus() == ApprovalStatus.WAITING) // 신청자
        || (type == 1 && farmingHolidayGuest.getApprovalStatus() == ApprovalStatus.ACCEPTED)){ // 게스트

          String guestName = farmingHolidayGuest.getGuest().getName();
          String farmingHolidayName = farmingHolidayGuest.getFarmingHoliday().getName();
          String houseName = farmingHolidayGuest.getHouse().getName();
          LocalDateTime rentStarDate = farmingHolidayGuest.getHouse().getRentStartDate();
          LocalDateTime rentEndDate = farmingHolidayGuest.getHouse().getRentEndDate();
          Long pay = farmingHolidayGuest.getFarmingHoliday().getPay();

          applicantDtoList.add(ApplicantDto.builder()
              .guestName(guestName)
              .farmingHolidayName(farmingHolidayName)
              .houseName(houseName)
              .rentStartDate(rentStarDate)
              .rentEndDate(rentEndDate)
              .pay(pay)
              .build());
        }
      }
    }

    return MyPageApplicantDto.builder()
        .myPageHostDto(MyPageHostDto.from(host))
        .applicantDtoList(applicantDtoList)
        .applicantNum(applicantDtoList.size())
        .build();
  }
}
