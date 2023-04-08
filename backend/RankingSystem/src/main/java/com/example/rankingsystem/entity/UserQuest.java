package com.example.RankingSystem.entity;

import jakarta.persistence.EmbeddedId;
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
public class UserQuest {
    @EmbeddedId
    UserQuestId id;
    Boolean status; //false == not finished, true == done
}
