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
public class Quest {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long questId;
    String description;
    Integer badgesReward;
    Integer tokensReward;
    @ManyToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "user_id", nullable = false)
    User user;
}
