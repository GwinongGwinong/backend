package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.domain.LikeHost;
import com.example.farmingholiday.domain.LikeHouse;
import com.example.farmingholiday.dto.home.BlockHouseDto;
import com.example.farmingholiday.dto.detail.HouseDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import com.example.farmingholiday.repository.GuestRepository;
import com.example.farmingholiday.repository.HouseRepository;
import com.example.farmingholiday.repository.LikeHouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final HouseRepository houseRepository;
    private final GuestRepository guestRepository;
    private final FarmingHolidayRepository farmingHolidayRepository;
    private final LikeHouseRepository likeHouseRepository;

    public List<HouseDto> getDetailHouse(Long farmingHolidayId, Long guestId){
        FarmingHoliday farmingHoliday = farmingHolidayRepository.findById(farmingHolidayId).orElse(null);
        List<House> houses = houseRepository.findAllByFarmingHoliday(farmingHoliday);
        Guest guest = guestRepository.findById(guestId).orElse(null);

        return houses.stream()
            .map(e -> HouseDto.from(e, likeHouseRepository.findByGuestAndHouse(guest, e).isPresent()))
            .collect(Collectors.toList());
    }

    public List<BlockHouseDto> get3BlockHouses(Long guestId){
        List<House> houses = houseRepository.findTop3ByOrderByRateDesc();
        return houses.stream()
                .map(e -> BlockHouseDto.from(e, e.getFarmingHoliday().getHost().getName(), getLikeHouseList(guestId).contains(e)))
                .collect(Collectors.toList());
    }

    public List<BlockHouseDto> getBlockHouses(Long guestId){
        List<House> houses = houseRepository.findAll();
        return houses.stream()
            .map(e -> BlockHouseDto.from(e, e.getFarmingHoliday().getHost().getName(), getLikeHouseList(guestId).contains(e)))
            .collect(Collectors.toList());
    }

    private List<House> getLikeHouseList(long guestId){
        Guest guest = guestRepository.findById(guestId).orElse(null);
        return likeHouseRepository.findAllByGuest(guest).stream()
            .map(LikeHouse::getHouse).toList();
    }
}
