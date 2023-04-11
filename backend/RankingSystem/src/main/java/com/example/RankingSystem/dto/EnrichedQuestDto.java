package com.example.RankingSystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class EnrichedQuestDto {
    Long questId;
    String description;
    Integer badgesReward;
    Integer tokensReward;
    Long ownerUserId;
    Boolean completed;
}
