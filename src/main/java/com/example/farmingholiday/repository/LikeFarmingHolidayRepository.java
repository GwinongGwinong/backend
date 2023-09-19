package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.dto.BlockFarmingHolidayDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeFarmingHolidayRepository extends JpaRepository<LikeFarmingHoliday, Long> {
  List<LikeFarmingHoliday> findAllByGuest(Guest guest);
}
