package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
