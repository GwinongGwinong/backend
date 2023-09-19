package com.example.farmingholiday.controller;

import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class LikeController {
  private final LikeService likeService;

  @PostMapping("/api/like/farming-holiday/{guestId}")
  public void likeFarmingHoliday(@PathVariable Long guestId, @RequestBody Long farmingHolidayId){
    likeService.likeFarmingHoliday(guestId, farmingHolidayId);
  }

  @PostMapping("/api/like/house/{guestId}")
  public void likeHouse(@PathVariable Long guestId, @RequestBody Long houseId){
    likeService.likeHouse(guestId, houseId);
  }

  @PostMapping("/api/like/host/{guestId}")
  public void likeHost(@PathVariable Long guestId, @RequestBody Long hostId){
    likeService.likeHost(guestId, hostId);
  }
}
