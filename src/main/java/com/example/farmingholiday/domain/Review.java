package com.example.farmingholiday.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Review {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  private FarmingHolidayGuestHouse farmingHolidayGuestHouse;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
  private double farmingHolidayRate;

  @Column(nullable = false)
  private double HostRate;

  @Column(nullable = false)
  private double HouseRate;

  @Column(nullable = false)
  private LocalDateTime time;
}
