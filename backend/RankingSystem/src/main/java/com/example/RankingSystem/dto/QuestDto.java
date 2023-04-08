package com.example.RankingSystem.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class QuestDto {
    Long questId;
    String description;
    Integer badgesReward;
    Integer tokensReward;
    Long ownerUserId;
}
