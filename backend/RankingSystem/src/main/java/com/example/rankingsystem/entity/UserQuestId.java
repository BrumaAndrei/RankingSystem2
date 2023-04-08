package com.example.RankingSystem.entity;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserQuestId implements Serializable {
    Long questId;
    Long userId;
}
