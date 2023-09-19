package com.example.farmingholiday.repository;

import com.example.farmingholiday.domain.Hashtag;
import com.example.farmingholiday.domain.Host;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, Long> {
  List<Hashtag> findAllByHost(Host host);
}
