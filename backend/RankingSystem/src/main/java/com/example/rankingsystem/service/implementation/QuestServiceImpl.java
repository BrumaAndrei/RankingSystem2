package com.example.RankingSystem.service.implementation;

import com.example.RankingSystem.dto.QuestDto;
import com.example.RankingSystem.entity.Quest;
import com.example.RankingSystem.entity.User;
import com.example.RankingSystem.exception.CrudException;
import com.example.RankingSystem.repository.QuestRepository;
import com.example.RankingSystem.repository.UserRepository;
import com.example.RankingSystem.service.interfaces.QuestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestServiceImpl implements QuestService {
    private QuestRepository questRepository;
    private UserRepository userRepository;

    @Override
    public void add(QuestDto questDto) throws CrudException {
        Quest quest = new Quest();
        quest.setTokensReward(questDto.getTokensReward());
        quest.setDescription(questDto.getDescription());
        quest.setBadgesReward(questDto.getBadgesReward());
        User user = userRepository.findById(questDto.getOwnerUserId()).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        quest.setUser(user);
        questRepository.save(quest);
    }

    @Override
    public void update(Long id, QuestDto quest) throws CrudException {
        var dbQuest = questRepository.findById(id).orElseThrow(() -> new CrudException("Quest with the provided" +
                "id doesn't exist"));

        dbQuest.setDescription(quest.getDescription());
        dbQuest.setBadgesReward(quest.getBadgesReward());
        dbQuest.setTokensReward(quest.getTokensReward());
        questRepository.save(dbQuest);
    }

    @Override
    public void delete(Long id) throws CrudException {
        var dbQuest = questRepository.findById(id).orElseThrow(() -> new CrudException("Quest with the provided" +
                "id doesn't exist"));
        questRepository.delete(dbQuest);
    }

    @Override
    public List<QuestDto> getAll() {
        return questRepository.findAll().stream().map(quest -> QuestDto.builder()
                .questId(quest.getQuestId())
                .badgesReward(quest.getBadgesReward())
                .tokensReward(quest.getTokensReward())
                .description(quest.getDescription())
                .ownerUserId(quest.getUser().getId())
                .build()).toList();
    }
}
