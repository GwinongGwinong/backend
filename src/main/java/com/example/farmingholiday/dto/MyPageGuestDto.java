package com.example.farmingholiday.dto;

import com.example.farmingholiday.dto.type.ApprovalStatus;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyPageGuestDto {
    private int reviewCounts;
    private int workDays;
    private int earnings;
}