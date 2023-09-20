package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.House;
import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.domain.LikeHost;
import com.example.farmingholiday.domain.LikeHouse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeHouseRepository extends JpaRepository<LikeHouse, Long> {
  List<LikeHouse> findAllByGuest(Guest guest);

  Optional<LikeHouse> findByGuestAndHouse(Guest guest, House house);
}
