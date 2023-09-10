package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
