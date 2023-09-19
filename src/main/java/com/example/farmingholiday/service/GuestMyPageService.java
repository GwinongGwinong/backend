package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHolidayGuest;
import com.example.farmingholiday.domain.FarmingHolidayGuestHouse;
import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.Hashtag;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.dto.guest.BlockApplyDto;
import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.BlockHouseDto;
import com.example.farmingholiday.dto.guest.MyPageApplyDto;
import com.example.farmingholiday.dto.guest.MyPageGuestDto;
import com.example.farmingholiday.dto.guest.MyPageLikesDto;
import com.example.farmingholiday.repository.FarmingHolidayGuestHouseRepository;
import com.example.farmingholiday.repository.GuestRepository;
import com.example.farmingholiday.repository.HashtagRepository;
import com.example.farmingholiday.repository.LikeFarmingHolidayRepository;
import com.example.farmingholiday.repository.LikeHostRepository;
import com.example.farmingholiday.repository.LikeHouseRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuestMyPageService {
  private final GuestRepository guestRepository;
  private final LikeFarmingHolidayRepository likeFarmingHolidayRepository;
  private final LikeHouseRepository likeHouseRepository;
  private final LikeHostRepository likeHostRepository;
  private final HashtagRepository hashtagRepository;
  private final FarmingHolidayGuestHouseRepository farmingHolidayGuestHouseRepository;
  
  public MyPageGuestDto getGuestInfo(Long id) {
    Guest guest = guestRepository.findById(id).orElse(null);
    return MyPageGuestDto.from(guest);
  }

  public MyPageLikesDto getLikesInfo(Long id) {
    Guest guest = guestRepository.findById(id).orElse(null);

    // 게스트가 좋아요 누른 파홀을 Block dto 로 리턴
    List<BlockFarmingHolidayDto> likeFarmingHoliday =
        likeFarmingHolidayRepository.findAllByGuest(guest).stream()
        .map(e -> BlockFarmingHolidayDto.from(e.getFarmingHoliday())).toList();

    List<BlockHouseDto> likeHouse =
        likeHouseRepository.findAllByGuest(guest).stream()
            .map(e -> BlockHouseDto.from(e.getHouse())).toList();

    List<BlockHostDto> likeHost =
        likeHostRepository.findAllByGuest(guest).stream()
                .map(e -> BlockHostDto.from(e.getHost(), findHashtag(e.getHost()))).toList();

    // 게스트 정보와 찜 목록을 MyPageLikesDto 로 묶어서 리턴
    return MyPageLikesDto.builder()
        .myPageGuestDto(MyPageGuestDto.from(guest))
        .farmingHolidayLikes(likeFarmingHoliday)
        .houseLikes(likeHouse)
        .hostLikes(likeHost)
        .build();
  }

  private List<String> findHashtag(Host host){
    List<Hashtag> hashtags = hashtagRepository.findAllByHost(host);
    List<String> hashtagContent = new ArrayList<>();
    for(Hashtag hashtag : hashtags){
      hashtagContent.add(hashtag.getContent());
    }
    return hashtagContent;
  }

  public MyPageApplyDto getApplyInfo(Long id) {
    Guest guest = guestRepository.findById(id).orElse(null);

    // 게스트가 신청한 파홀
    List<FarmingHolidayGuestHouse> applied = farmingHolidayGuestHouseRepository.findAllByGuest(guest);

    // 신청한 파홀을 [block dto + 승인 상태]를 하나로 묶는 dto list 로 리턴
    List<BlockApplyDto> blockApplyDtoList = new ArrayList<>();
    for(FarmingHolidayGuestHouse apply : applied){
      blockApplyDtoList.add(
          BlockApplyDto.builder()
              .appliedFarmingHoliday(BlockFarmingHolidayDto.from(apply.getFarmingHoliday()))
              .approvalStatus(apply.getApprovalStatus())
              .build());
    }

    return MyPageApplyDto.builder()
        .myPageGuestDto(MyPageGuestDto.from(guest))
        .blockApplyDtoList(blockApplyDtoList)
        .applyNum(blockApplyDtoList.size())
        .build();
  }
}
