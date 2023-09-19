package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.FarmingHoliday;
import com.example.farmingholiday.domain.Apply;
import com.example.farmingholiday.domain.Guest;
import com.example.farmingholiday.dto.type.ApprovalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ApplyRepository extends JpaRepository<Apply, Long> {
  List<Apply> findAllByGuest(Guest guest);
  List<Apply> findAllByFarmingHoliday(FarmingHoliday farmingHoliday);
  Apply findByGuestAndFarmingHoliday(Guest guest, FarmingHoliday farmingHoliday);
  List<Apply> findAllByGuestAndApprovalStatus(Guest guest, ApprovalStatus approvalStatus);
}
