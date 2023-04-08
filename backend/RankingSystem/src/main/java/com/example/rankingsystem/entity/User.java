package com.example.RankingSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "app_user")
public class User {
    @Id
    private Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    int age;
    int tokens;
    int badges;
    @OneToMany(mappedBy="questId")
    List<Quest> quests;
}
