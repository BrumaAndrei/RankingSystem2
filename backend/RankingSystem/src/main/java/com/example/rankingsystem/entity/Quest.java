package com.example.RankingSystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ownerUserId;
    String description;
    Integer badgesReward;
    Integer tokensReward;
}
