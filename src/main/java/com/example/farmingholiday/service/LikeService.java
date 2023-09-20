package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.domain.LikeHouse;
import com.example.farmingholiday.domain.LikeHost;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import com.example.farmingholiday.repository.GuestRepository;
import com.example.farmingholiday.repository.HostRepository;
import com.example.farmingholiday.repository.HouseRepository;
import com.example.farmingholiday.repository.LikeFarmingHolidayRepository;
import com.example.farmingholiday.repository.LikeHostRepository;
import com.example.farmingholiday.repository.LikeHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {
  private final LikeFarmingHolidayRepository likeFarmingHolidayRepository;
  private final LikeHostRepository likeHostRepository;
  private final LikeHouseRepository likeHouseRepository;
  private final FarmingHolidayRepository farmingHolidayRepository;
  private final HostRepository hostRepository;
  private final HouseRepository houseRepository;
  private final GuestRepository guestRepository;

  public void likeFarmingHoliday(Long guestId, Long farmingHolidayId) {
    likeFarmingHolidayRepository.save(LikeFarmingHoliday.builder()
            .farmingHoliday(farmingHolidayRepository.findById(farmingHolidayId).orElse(null))
            .guest(guestRepository.findById(guestId).orElse(null))
        .build());
  }

  public void likeHouse(Long guestId, Long houseId) {
    likeHouseRepository.save(LikeHouse.builder()
        .house(houseRepository.findById(houseId).orElse(null))
        .guest(guestRepository.findById(guestId).orElse(null))
        .build());
  }

  public void likeHost(Long guestId, Long hostId) {
    likeHostRepository.save(LikeHost.builder()
        .host(hostRepository.findById(hostId).orElse(null))
        .guest(guestRepository.findById(guestId).orElse(null))
        .build());
  }
}
