package com.example.RankingSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AppUser {
    @Id
    private Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    int age;
    int tokens;
    int badges;
}
