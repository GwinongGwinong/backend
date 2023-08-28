package com.example.farmingholiday.controller;

import com.example.farmingholiday.dto.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {
    @PostMapping("/sign-up")
    public ResponseEntity checkValidSignUp(@RequestBody UserDto signUpDto){ // 회원가입 입력 정보가 곧 사용자 정보
        //TODO: 중복되는 아이디 없는지 체크
        return ResponseEntity.ok().build();
    }
}