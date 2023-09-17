package com.example.farmingholiday.domain;

import com.example.farmingholiday.dto.ApprovalStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class FarmingHolidayGuest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private FarmingHoliday farmingHoliday;

    @ManyToOne
    private Guest guest;

    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus = ApprovalStatus.WAITING;
}