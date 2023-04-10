package com.example.RankingSystem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserTriesQuest {
    @EmbeddedId
    UserTriesQuestId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("questId")
    @JoinColumn(name = "quest_id")
    private Quest quest;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    Boolean completed;
}
