package com.example.RankingSystem.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserTriesQuestDto {
    Long questId;
    Long userId;
    Boolean completed;
}
