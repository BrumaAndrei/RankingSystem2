package com.example.RankingSystem.service.interfaces;

import com.example.RankingSystem.dto.EnrichedQuestDto;
import com.example.RankingSystem.dto.QuestDto;
import com.example.RankingSystem.dto.UserTriesQuestDto;
import com.example.RankingSystem.exception.CrudException;

import java.util.List;

public interface UserTriesQuestService {
    void add(UserTriesQuestDto dto) throws CrudException;
    void update(UserTriesQuestDto dto) throws CrudException;
    void delete(UserTriesQuestDto dto) throws CrudException;
    List<EnrichedQuestDto> getAllQuestsStarted(Long userId);
}