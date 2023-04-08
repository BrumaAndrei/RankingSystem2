package com.example.RankingSystem.repository;

import com.example.RankingSystem.entity.User;
import com.example.RankingSystem.entity.UserTriesQuest;
import com.example.RankingSystem.entity.UserTriesQuestId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTriesQuestRepository extends JpaRepository<UserTriesQuest, UserTriesQuestId> {
    
}
