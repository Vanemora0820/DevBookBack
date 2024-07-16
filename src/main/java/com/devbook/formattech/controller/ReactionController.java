package com.devbook.formattech.controller;


import com.devbook.formattech.Dto.ReactionDto;
import com.devbook.formattech.entity.Reaction;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.service.ReactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/reaction")
public class ReactionController {

    @Autowired
    ReactionService reactionService;

    @PostMapping
    public ResponseEntity<ReactionDto> createReaction(@RequestBody ReactionDto reactionDto) {

        ReactionDto createdReaction = reactionService.createReaction(reactionDto);
        return ResponseEntity.ok(createdReaction);
    }


    @GetMapping("/getReactions")

    public ResponseEntity <List<ReactionDto>> getReactions() {
        List<ReactionDto> reactions = reactionService.getAllReactions();
        return ResponseEntity.ok(reactions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReactionDto> getReactionById(@PathVariable int id) {
        ReactionDto reaction = reactionService.getReactionById(id);
        return ResponseEntity.ok(reaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReactionDto> updateReaction(@PathVariable int id, @RequestBody ReactionDto reactionDto) {
        ReactionDto updatedReaction = reactionService.updateReaction(id, reactionDto);
        return ResponseEntity.ok(updatedReaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reaction> deleteReaction(@PathVariable int id) {
        Reaction deleteReaction = reactionService.deleteReaction(id);
        return ResponseEntity.ok(deleteReaction);
    }
}
