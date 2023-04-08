package com.example.RankingSystem.controller;

import com.example.RankingSystem.dto.QuestDto;
import com.example.RankingSystem.service.interfaces.QuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quest")
public class QuestController {
    QuestService questService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(questService.getAll());
    }

    @GetMapping("/add")
    public ResponseEntity<?> add(@RequestBody QuestDto dto){
        questService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id,
                                    @RequestBody QuestDto questDto){
        questService.update(id, questDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        questService.delete(id);
        return ResponseEntity.ok().build();
    }

}
