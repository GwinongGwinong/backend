package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Host;
import com.example.farmingholiday.domain.House;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
  List<Host> findTop4ByOrderByRateDesc();
}
