package com.example.RankingSystem.service.interfaces;

import com.example.RankingSystem.dto.QuestDto;
import com.example.RankingSystem.entity.Quest;
import com.example.RankingSystem.exception.CrudException;

import java.util.List;

public interface QuestService {
    void add(QuestDto quest) throws CrudException;
    void update(Long id, QuestDto quest) throws CrudException;
    void delete(Long id) throws CrudException;
    List<QuestDto> getAll();
}
