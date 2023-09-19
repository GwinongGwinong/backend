package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.FarmingHolidayGuestHouse;
import com.example.farmingholiday.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FarmingHolidayGuestHouseRepository extends JpaRepository<FarmingHolidayGuestHouse, Long> {
  List<FarmingHolidayGuestHouse> findAllByGuest(Guest guest);
  List<FarmingHolidayGuestHouse> findAllByFarmingHoliday(FarmingHoliday farmingHoliday);
}
