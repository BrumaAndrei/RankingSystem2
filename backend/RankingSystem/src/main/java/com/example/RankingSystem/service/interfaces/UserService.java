package com.example.RankingSystem.service.interfaces;

import com.example.RankingSystem.dto.UserDto;
import com.example.RankingSystem.entity.User;

import java.util.List;

public interface UserService {
    void add(UserDto user);
    void update(Long id, UserDto user);
    void delete(Long id);
    List<UserDto> getAll();

    List<UserDto> getRanking(String criteria);

    UserDto getById(Long id);
}
