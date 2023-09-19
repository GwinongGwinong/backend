package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.House;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
  List<House> findTop3ByOrderByRateDesc();
}
