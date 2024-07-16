package com.devbook.formattech.controller;


import com.devbook.formattech.Dto.PostDto;
import com.devbook.formattech.entity.Post;
import com.devbook.formattech.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {

        PostDto createdPost = postService.createPost(postDto);
        return ResponseEntity.ok(createdPost);
    }


    @GetMapping("/getPosts")

    public ResponseEntity <List<PostDto>> getPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int id) {
        PostDto post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable int id, @RequestBody PostDto postDto) {
        PostDto updatedPost = postService.updatePost(id, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Post> deactivatePost(@PathVariable int postId) {
        Post deactivatedPost = postService.deactivatePost(postId);
        return ResponseEntity.ok(deactivatedPost);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getPostsByUser(@PathVariable int userId) {
        List<Post> posts = postService.getPostsByUser(userId);
        return ResponseEntity.ok(posts);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Post> createPostForUser(@PathVariable int userId, @RequestBody PostDto postDto) {
        Post post = postService.createPostForUser(userId, postDto);
        return ResponseEntity.ok(post);
    }
}
