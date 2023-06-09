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
import java.util.stream.Collectors;

@Service
public class QuestServiceImpl implements QuestService {
    private final QuestRepository questRepository;
    private final UserRepository userRepository;

    public QuestServiceImpl(QuestRepository questRepository, UserRepository userRepository) {
        this.questRepository = questRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(QuestDto questDto) {
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
                .build())
                .toList();
    }

    @Override
    public void addQuestToUser(Long questId, Long userId) {
        var quest = questRepository.findById(questId).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        var user = userRepository.findById(userId).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));

        var quests = user.getQuests();
        quests.add(quest);
        user.setQuests(quests);
    }

    @Override
    public List<QuestDto> getUserQuestsById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));

        return questRepository.getByUserId(id).stream().map(quest -> QuestDto.builder()
                .questId(quest.getQuestId())
                .badgesReward(quest.getBadgesReward())
                .tokensReward(quest.getTokensReward())
                .description(quest.getDescription())
                .ownerUserId(quest.getUser().getId())
                .build()).collect(Collectors.toList());
    }
}
