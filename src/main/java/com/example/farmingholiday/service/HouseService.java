package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.dto.home.BlockHouseDto;
import com.example.farmingholiday.dto.detail.HouseDto;
import com.example.farmingholiday.repository.FarmingHolidayRepository;
import com.example.farmingholiday.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class HouseService {
    private final HouseRepository houseRepository;
    private final FarmingHolidayRepository farmingHolidayRepository;

    public List<HouseDto> getDetailHouse(Long id){
        FarmingHoliday farmingHoliday = farmingHolidayRepository.findById(id).orElse(null);
        List<House> houses = houseRepository.findAllByFarmingHoliday(farmingHoliday);
        return houses.stream().map(HouseDto::from).collect(Collectors.toList());
    }

    public List<BlockHouseDto> get3BlockHouses(){
        List<House> houses = houseRepository.findTop3ByOrderByRateDesc();
        return houses.stream()
                .map(e -> BlockHouseDto.from(e, e.getFarmingHoliday().getHost().getName()))
                .collect(Collectors.toList());
    }

    public List<BlockHouseDto> getBlockHouses(){
        List<House> houses = houseRepository.findAll();
        return houses.stream()
            .map(e -> BlockHouseDto.from(e, e.getFarmingHoliday().getHost().getName()))
            .collect(Collectors.toList());
    }
}
