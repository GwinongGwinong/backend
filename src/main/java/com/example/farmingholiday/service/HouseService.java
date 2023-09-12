package com.example.farmingholiday.service;

import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.dto.BlockHouseDto;
import com.example.farmingholiday.dto.HouseDto;
import com.example.farmingholiday.repository.HouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HouseService {
    final private HouseRepository houseRepository;

    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    public HouseDto getHouse(long id){
        Optional<House> house = houseRepository.findById(id);
        return house.map(HouseDto::from).orElse(null);
    }

    public List<BlockHouseDto> getBlockHouses(){
        List<House> houses = houseRepository.findAll();
        return houses.stream()
                .map(BlockHouseDto::from)
                .collect(Collectors.toList());
    }
}
