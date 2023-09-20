package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.host.MyPageApplicantDto;
import com.example.farmingholiday.dto.host.MyPageHostDto;
import com.example.farmingholiday.service.HostMyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HostMyPageController {

  private final HostMyPageService hostMyPageService;

  @GetMapping("/api/host/my-page/{id}")
  public MyPageHostDto getHostInfo(@PathVariable Long id){
    return hostMyPageService.getHostInfo(id);
  }

  @GetMapping("/api/host/my-page/applicant/{id}")
  public MyPageApplicantDto getApplicantInfo(@PathVariable Long id){
    return hostMyPageService.getApplicantInfo(id, 0);
  }

  @GetMapping("/api/host/my-page/guest/{id}")
  public MyPageApplicantDto getGuestInfo(@PathVariable Long id){
    return hostMyPageService.getApplicantInfo(id, 1);
  }
}
