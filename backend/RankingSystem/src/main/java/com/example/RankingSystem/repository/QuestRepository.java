package com.example.RankingSystem.repository;

import com.example.RankingSystem.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestRepository extends JpaRepository<Quest, Long> {
    List<Quest> getByUserId(Long userId);
}
