package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
