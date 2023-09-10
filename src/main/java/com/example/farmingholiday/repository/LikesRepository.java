package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes, Long> {
}
