package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.FarmingHolidayGuest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmingHolidayGuestRepository extends JpaRepository<FarmingHolidayGuest, Long> {
}
