package com.example.RankingSystem.repository;

import com.example.RankingSystem.entity.Quest;
import com.example.RankingSystem.entity.User;
import com.example.RankingSystem.entity.UserTriesQuest;
import com.example.RankingSystem.entity.UserTriesQuestId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTriesQuestRepository extends JpaRepository<UserTriesQuest, UserTriesQuestId> {
    List<UserTriesQuest> findByUserId(Long userId);
    
}
