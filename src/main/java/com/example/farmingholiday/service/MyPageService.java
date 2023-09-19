package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.Hashtag;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.domain.LikeHost;
import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.BlockHostDto;
import com.example.farmingholiday.dto.BlockHouseDto;
import com.example.farmingholiday.dto.FarmingHolidayDto;
import com.example.farmingholiday.dto.MyPageGuestDto;
import com.example.farmingholiday.dto.MyPageLikesDto;
import com.example.farmingholiday.repository.GuestRepository;
import com.example.farmingholiday.repository.HashtagRepository;
import com.example.farmingholiday.repository.HostRepository;
import com.example.farmingholiday.repository.LikeFarmingHolidayRepository;
import com.example.farmingholiday.repository.LikeHostRepository;
import com.example.farmingholiday.repository.LikeHouseRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyPageService {
  private final GuestRepository guestRepository;
  private final LikeFarmingHolidayRepository likeFarmingHolidayRepository;
  private final LikeHouseRepository likeHouseRepository;
  private final LikeHostRepository likeHostRepository;
  private final HashtagRepository hashtagRepository;
  
  public MyPageGuestDto getGuestMyPageInfo(Long id) {
    Guest guest = guestRepository.findById(id).orElse(null);
    return MyPageGuestDto.from(guest);
  }

  public MyPageLikesDto getGuestLikesInfo(Long id) {
    Guest guest = guestRepository.findById(id).orElse(null);

    List<BlockFarmingHolidayDto> likeFarmingHoliday =
        likeFarmingHolidayRepository.findAllByGuest(guest).stream()
        .map(e -> BlockFarmingHolidayDto.from(e.getFarmingHoliday())).toList();

    List<BlockHouseDto> likeHouse =
        likeHouseRepository.findAllByGuest(guest).stream()
            .map(e -> BlockHouseDto.from(e.getHouse())).toList();

    List<BlockHostDto> likeHost =
        likeHostRepository.findAllByGuest(guest).stream()
                .map(e -> BlockHostDto.from(e.getHost(), findHashtag(e.getHost()))).toList();

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
}
