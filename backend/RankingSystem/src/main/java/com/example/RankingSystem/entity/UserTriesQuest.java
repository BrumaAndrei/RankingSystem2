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
    Boolean completed;
}
