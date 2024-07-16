package com.devbook.formattech.controller;

import com.devbook.formattech.Dto.CommentDto;
import com.devbook.formattech.entity.Comment;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/comment")

public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto) {

        CommentDto createdComment = commentService.createComment(commentDto);
        return ResponseEntity.ok(createdComment);
    }

    @GetMapping("/getComments")

    public ResponseEntity <List<CommentDto>> getComments() {
        List<CommentDto> comments = commentService.getAllComments();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable int id) {
        CommentDto comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDto> updateComment(@PathVariable int id, @RequestBody CommentDto commentDto) {
        CommentDto updatedComment = commentService.updateComment(id, commentDto);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Comment> deleteComment(@PathVariable int id) {
        Comment deleteComment = commentService.deleteComment(id);
        return ResponseEntity.ok(deleteComment);
    }
}
