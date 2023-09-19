package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.dto.home.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.detail.FarmingHolidayDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import com.example.farmingholiday.repository.GuestRepository;
import com.example.farmingholiday.repository.LikeFarmingHolidayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FarmingHolidayService {
    private final FarmingHolidayRepository farmingHolidayRepository;
    private final GuestRepository guestRepository;
    private final LikeFarmingHolidayRepository likeFarmingHolidayRepository;

    @Transactional(readOnly = true)
    public FarmingHolidayDto getFarmingHoliday(long id, long guestId){
        FarmingHoliday farmingHoliday = farmingHolidayRepository.findById(id).orElse(null);
        Guest guest = guestRepository.findById(guestId).orElse(null);
        boolean isLike = likeFarmingHolidayRepository.findByFarmingHolidayAndGuest(farmingHoliday, guest).isPresent();

        return FarmingHolidayDto.from(farmingHoliday, isLike);
    }

    public List<BlockFarmingHolidayDto> get3BlockFarmingHolidays(long guestId){
        List<FarmingHoliday> farmingHolidays = farmingHolidayRepository.findTop3ByOrderByRateDesc();
        List<FarmingHoliday> likeFarmingHolidays =  getLikeFarmingHolidayList(guestId);

        return farmingHolidays.stream()
                .map(e -> BlockFarmingHolidayDto.from(e, likeFarmingHolidays.contains(e)))
                .collect(Collectors.toList());
    }

    public List<BlockFarmingHolidayDto> getBlockFarmingHolidays(long guestId){
        List<FarmingHoliday> farmingHolidays = farmingHolidayRepository.findAll();
        List<FarmingHoliday> likeFarmingHolidays =  getLikeFarmingHolidayList(guestId);

        return farmingHolidays.stream()
            .map(e -> BlockFarmingHolidayDto.from(e, likeFarmingHolidays.contains(e)))
            .collect(Collectors.toList());
    }

    private List<FarmingHoliday> getLikeFarmingHolidayList(long guestId){
        Guest guest = guestRepository.findById(guestId).orElse(null);
        return likeFarmingHolidayRepository.findAllByGuest(guest).stream()
            .map(LikeFarmingHoliday::getFarmingHoliday).toList();
    }
}
