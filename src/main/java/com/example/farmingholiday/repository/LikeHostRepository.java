package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.LikeFarmingHoliday;
import com.example.farmingholiday.domain.LikeHost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeHostRepository extends JpaRepository<LikeHost, Long> {
}
