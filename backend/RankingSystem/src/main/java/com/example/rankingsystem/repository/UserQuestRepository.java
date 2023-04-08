package com.example.RankingSystem.repository;

import com.example.RankingSystem.entity.AppUser;
import com.example.RankingSystem.entity.UserQuest;
import com.example.RankingSystem.entity.UserQuestId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserQuestRepository extends JpaRepository<UserQuest, UserQuestId> {
    
}
