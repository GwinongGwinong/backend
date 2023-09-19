package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.dto.home.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.detail.FarmingHolidayDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
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

    @Transactional(readOnly = true)
    public FarmingHolidayDto getFarmingHoliday(long id){
        Optional<FarmingHoliday> farmingHoliday = farmingHolidayRepository.findById(id);
        return farmingHoliday.map(FarmingHolidayDto::from).orElse(null);
    }

    public List<BlockFarmingHolidayDto> get3BlockFarmingHolidays(){
        List<FarmingHoliday> farmingHolidays = farmingHolidayRepository.findTop3ByOrderByRateDesc();
        return farmingHolidays.stream()
                .map(BlockFarmingHolidayDto::from)
                .collect(Collectors.toList());
    }

    public List<BlockFarmingHolidayDto> getBlockFarmingHolidays(){
        List<FarmingHoliday> farmingHolidays = farmingHolidayRepository.findAll();
        return farmingHolidays.stream()
            .map(BlockFarmingHolidayDto::from)
            .collect(Collectors.toList());
    }
}
