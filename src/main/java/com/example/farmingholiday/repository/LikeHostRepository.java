package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.domain.LikeHost;
import com.example.farmingholiday.dto.BlockHostDto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeHostRepository extends JpaRepository<LikeHost, Long> {
  List<LikeHost> findAllByGuest(Guest guest);
}
