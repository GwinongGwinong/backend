package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Apply;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.dto.host.ApplicantDto;
import com.example.farmingholiday.dto.host.MyPageApplicantDto;
import com.example.farmingholiday.dto.host.MyPageHostDto;
import com.example.farmingholiday.dto.type.ApprovalStatus;
import com.example.farmingholiday.repository.ApplyRepository;
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
  private final ApplyRepository applyRepository;
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
      // 신청 정보(파홀-게스트-숙소) 리스트
      List<Apply> applies = applyRepository.findAllByFarmingHoliday(farmingHoliday);

      // 목록에 필요한 정보 get
      for(Apply apply : applies){
        if((type == 0 && apply.getApprovalStatus() == ApprovalStatus.WAITING) // 신청자 조회
        || (type == 1 && apply.getApprovalStatus() == ApprovalStatus.ACCEPTED)){ // 게스트 조회
          applicantDtoList.add(ApplicantDto.builder()
              .guestName(apply.getGuest().getName())
              .farmingHolidayName(apply.getFarmingHoliday().getName())
              .houseName(apply.getHouse().getName())
              .rentStartDate(apply.getHouse().getRentStartDate())
              .rentEndDate(apply.getHouse().getRentEndDate())
              .pay(apply.getFarmingHoliday().getPay())
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
