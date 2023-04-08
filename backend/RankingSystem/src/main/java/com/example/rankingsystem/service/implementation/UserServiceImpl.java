package com.example.RankingSystem.service.implementation;

import com.example.RankingSystem.dto.QuestDto;
import com.example.RankingSystem.dto.UserDto;
import com.example.RankingSystem.entity.User;
import com.example.RankingSystem.exception.CrudException;
import com.example.RankingSystem.repository.UserRepository;
import com.example.RankingSystem.service.interfaces.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void add(UserDto userDto) {
        User user = new User();
        user.setAge(userDto.getAge());
        user.setBadges(userDto.getBadges());
        user.setTokens(userDto.getTokens());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public void update(Long id, UserDto userDto) throws CrudException {
        var user = userRepository.findById(id).orElseThrow(() -> new CrudException("User with the provided" +
                "id doesn't exist"));

        user.setAge(userDto.getAge());
        user.setBadges(userDto.getBadges());
        user.setTokens(userDto.getTokens());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) throws CrudException {
        var user = userRepository.findById(id).orElseThrow(() -> new CrudException("User with the provided" +
                "id doesn't exist"));
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream().map(user -> UserDto.builder()
                        .id(user.getId())
                        .age(user.getAge())
                        .badges(user.getBadges())
                        .tokens(user.getTokens())
                        .firstName(user.getFirstName())
                        .lastName(user.getLastName())
                        .password(user.getPassword())
                        .username(user.getUsername())
                        .quests(user.getQuests().stream().map(quest -> QuestDto.builder()
                                        .questId(quest.getQuestId())
                                        .badgesReward(quest.getBadgesReward())
                                        .tokensReward(quest.getTokensReward())
                                        .description(quest.getDescription())
                                        .ownerUserId(quest.getUser().getId())
                                        .build())
                                .toList()
                        ).build()
                )
                .toList();
    }
}
