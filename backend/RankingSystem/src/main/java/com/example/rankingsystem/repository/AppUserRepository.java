package com.example.RankingSystem.repository;

import com.example.RankingSystem.entity.AppUser;
import com.example.RankingSystem.entity.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    
}
