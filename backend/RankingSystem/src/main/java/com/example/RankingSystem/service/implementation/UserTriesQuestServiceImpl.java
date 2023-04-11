package com.example.RankingSystem.service.implementation;

import com.example.RankingSystem.dto.EnrichedQuestDto;
import com.example.RankingSystem.dto.QuestDto;
import com.example.RankingSystem.dto.UserTriesQuestDto;
import com.example.RankingSystem.entity.UserTriesQuest;
import com.example.RankingSystem.entity.UserTriesQuestId;
import com.example.RankingSystem.exception.CrudException;
import com.example.RankingSystem.repository.QuestRepository;
import com.example.RankingSystem.repository.UserRepository;
import com.example.RankingSystem.repository.UserTriesQuestRepository;
import com.example.RankingSystem.service.interfaces.UserTriesQuestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTriesQuestServiceImpl implements UserTriesQuestService {
    private final QuestRepository questRepository;
    private final UserRepository userRepository;
    private final UserTriesQuestRepository userTriesQuestRepository;

    public UserTriesQuestServiceImpl(QuestRepository questRepository, UserRepository userRepository, UserTriesQuestRepository userTriesQuestRepository) {
        this.questRepository = questRepository;
        this.userRepository = userRepository;
        this.userTriesQuestRepository = userTriesQuestRepository;
    }

    @Override
    public void add(UserTriesQuestDto dto) throws CrudException {
        var quest = questRepository.findById(dto.getQuestId()).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        var user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        UserTriesQuest userTriesQuest = new UserTriesQuest();
        userTriesQuest.setId(new UserTriesQuestId(user.getId(), quest.getQuestId()));
        userTriesQuest.setQuest(quest);
        userTriesQuest.setUser(user);
        userTriesQuest.setCompleted(false);
        userTriesQuestRepository.save(userTriesQuest);
    }

    @Override
    public void update(UserTriesQuestDto dto) throws CrudException {
        var quest = questRepository.findById(dto.getQuestId()).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        var user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        var userTriesQuest = userTriesQuestRepository.findById(new UserTriesQuestId(user.getId(), quest.getQuestId())).orElseThrow(() -> new CrudException("User or Quest with " +
                "this id doesn't exist"));
        userTriesQuest.setCompleted(dto.getCompleted());
        userTriesQuestRepository.save(userTriesQuest);
    }

    @Override
    public void delete(UserTriesQuestDto dto) throws CrudException {
        var quest = questRepository.findById(dto.getQuestId()).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        var user = userRepository.findById(dto.getUserId()).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        var userTriesQuest = userTriesQuestRepository.findById(new UserTriesQuestId(user.getId(), quest.getQuestId())).orElseThrow(() -> new CrudException("User or Quest with " +
                "this id doesn't exist"));
        userTriesQuestRepository.delete(userTriesQuest);
    }

    @Override
    public List<EnrichedQuestDto> getAllQuestsStarted(Long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new CrudException("User with " +
                "this id doesn't exist"));
        List<UserTriesQuest> userTriesQuests = userTriesQuestRepository.findByUserId(userId);
        return userTriesQuests.stream().map(utq -> EnrichedQuestDto.builder()
                .questId(utq.getId().getQuestId())
                .ownerUserId(utq.getQuest().getUser().getId())
                .description(utq.getQuest().getDescription())
                .tokensReward(utq.getQuest().getTokensReward())
                .badgesReward(utq.getQuest().getBadgesReward())
                .completed(utq.getCompleted())
                .build()).collect(Collectors.toList());
    }
}