package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.type.ApprovalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Apply { // update : FarmingHolidayGuest 를 더 취지에 맞는 네이밍으로 변경
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private FarmingHoliday farmingHoliday;

    @ManyToOne
    private Guest guest;

    @ManyToOne // update : 파홀 - 신청자의 관계가 끝이라 생각했는데, 생각해보니 숙소도 같이 신청하는거였음
    private House house;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus = ApprovalStatus.WAITING;
}