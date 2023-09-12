package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import com.example.farmingholiday.dto.FarmingHolidayDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FarmingHolidayService {
    final FarmingHolidayRepository farmingHolidayRepository;
    //TODO:리뷰에 대한 domain 구현
    @Autowired
    public FarmingHolidayService(FarmingHolidayRepository farmingHolidayRepository) {
        this.farmingHolidayRepository = farmingHolidayRepository;
    }
    @Transactional(readOnly = true)
    public FarmingHolidayDto getFarmingHoliday(long id){
        Optional<FarmingHoliday> farmingHoliday = farmingHolidayRepository.findById(id);
        return farmingHoliday.map(FarmingHolidayDto::from).orElse(null);
    }

    public List<BlockFarmingHolidayDto> getBlockFarmingHolidays(){
        List<FarmingHoliday> farmingHolidays = farmingHolidayRepository.findAll();
        return farmingHolidays.stream()
                .map(BlockFarmingHolidayDto::from)
                .collect(Collectors.toList());
    }

}
