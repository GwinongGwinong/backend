package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.DetailPageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetailController {
    @GetMapping("farming-holiday/detailed-info/{id}")
    public DetailPageDto getDetailedInfo(@PathVariable String id){
        return DetailPageDto.builder().build();
    }
}
