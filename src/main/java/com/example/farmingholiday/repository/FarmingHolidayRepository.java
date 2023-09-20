package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Host;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FarmingHolidayRepository extends JpaRepository<FarmingHoliday,Long> {
  List<FarmingHoliday> findTop3ByOrderByRateDesc();

  List<FarmingHoliday> findAllByHost(Host host);
}
