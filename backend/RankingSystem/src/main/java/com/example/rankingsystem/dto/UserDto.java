package com.example.RankingSystem.dto;

import com.example.RankingSystem.entity.Quest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {
    private Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    int age;
    int tokens;
    int badges;
    List<QuestDto> quests;
}
