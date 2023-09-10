package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
