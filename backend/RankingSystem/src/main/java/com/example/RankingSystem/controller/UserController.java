package com.example.RankingSystem.controller;

import com.example.RankingSystem.dto.UserDto;
import com.example.RankingSystem.service.interfaces.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/ranking/{criteria}")
    public ResponseEntity<?> getRanking(@PathVariable String criteria)
    {
        return ResponseEntity.ok(userService.getRanking(criteria));
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UserDto dto){
        userService.add(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable(value = "id") Long id,
                                    @RequestBody UserDto userDto){
        userService.update(id, userDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getById(@PathVariable(value = "userId") Long id){
        return ResponseEntity.ok(userService.getById(id));
    }
}
