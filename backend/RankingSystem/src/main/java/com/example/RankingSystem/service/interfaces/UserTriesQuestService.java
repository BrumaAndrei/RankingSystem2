package com.example.RankingSystem.service.interfaces;

import com.example.RankingSystem.dto.EnrichedQuestDto;
import com.example.RankingSystem.dto.UserTriesQuestDto;
import com.example.RankingSystem.exception.CrudException;

import java.util.List;

public interface UserTriesQuestService {
    void add(UserTriesQuestDto dto) throws CrudException;
    void completeQuest(UserTriesQuestDto dto) throws CrudException;
    void delete(UserTriesQuestDto dto) throws CrudException;
    List<EnrichedQuestDto> getAllQuestsStarted(Long userId);
    List<EnrichedQuestDto> getAllAvailable(Long userId);

    List<EnrichedQuestDto> getAlluserQuestsToJudge(Long userId);
}