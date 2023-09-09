package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.HomePageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/home")
public class HomeController {
    //TODO: 리뷰 평점 높은 순으로 정렬해서 리턴
    @GetMapping
    public HomePageDto getHomeInfo(){
        HomePageDto homePageDto = new HomePageDto();
        return homePageDto;
    }
}