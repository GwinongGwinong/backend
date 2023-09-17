package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.LikeFarmingHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeFarmingHolidayRepository extends JpaRepository<LikeFarmingHoliday, Long> {
}
