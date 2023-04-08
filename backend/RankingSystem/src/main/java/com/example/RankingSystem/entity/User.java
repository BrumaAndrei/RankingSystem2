package com.example.RankingSystem.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
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
