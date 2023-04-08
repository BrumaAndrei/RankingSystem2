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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "quest_id", referencedColumnName = "questId")
    Quest quest;
}
