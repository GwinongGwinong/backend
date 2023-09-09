package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.ApprovalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// 게스트가 신청한 파밍 홀리데이 정보를 담는 관계 테이블
// 게스트는 여러 파홀을 신청할 수 있음
// 파홀은 여러 게스트의 신청을 받을 수 있음

@Getter
@Entity
public class FarmingHolidayGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private FarmingHoliday farmingHoliday;

    @ManyToOne
    private Guest guest;

    @ManyToOne
    private Host host;

    @Setter
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus = ApprovalStatus.WAITING;
}