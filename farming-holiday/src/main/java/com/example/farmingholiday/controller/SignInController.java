package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.SignInDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignInController {
    @PostMapping("/sign-in")
    public ResponseEntity checkValidSignIn(@RequestBody SignInDto loginDto){
        //TODO: 유효한 아이디, 비밀번호인지 체크하는 로직 필요
        return ResponseEntity.ok().build();
    }
}