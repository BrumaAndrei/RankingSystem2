package com.example.RankingSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserTriesQuestId implements Serializable {
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "quest_id")
    private Long questId;
}
