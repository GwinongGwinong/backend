package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.FarmingHolidayGuest;
import com.example.farmingholiday.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FarmingHolidayGuestRepository extends JpaRepository<FarmingHolidayGuest, Long> {
  List<FarmingHolidayGuest> findAllByGuest(Guest guest);
}
