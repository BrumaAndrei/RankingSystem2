package com.example.RankingSystem.controller;

import com.example.RankingSystem.dto.QuestDto;
import com.example.RankingSystem.dto.UserTriesQuestDto;
import com.example.RankingSystem.service.interfaces.QuestService;
import com.example.RankingSystem.service.interfaces.UserTriesQuestService;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userTriesQuest")
public class UserTriesQuestController {
   private final UserTriesQuestService userTriesQuestService;

    public UserTriesQuestController(UserTriesQuestService userTriesQuestService) {
        this.userTriesQuestService = userTriesQuestService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getAllUserStartedQuests(@PathVariable Long userId){
        return ResponseEntity.ok(userTriesQuestService.getAllQuestsStarted(userId));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UserTriesQuestDto dto){
        userTriesQuestService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserTriesQuestDto dto){
        userTriesQuestService.update(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(UserTriesQuestDto dto){
        userTriesQuestService.delete(dto);
        return ResponseEntity.ok().build();
    }

}
