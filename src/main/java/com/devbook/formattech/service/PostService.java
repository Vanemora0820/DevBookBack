package com.devbook.formattech.service;

import com.devbook.formattech.Dto.PostDto;
import com.devbook.formattech.entity.Post;

import java.util.List;

public interface PostService {

    PostDto createPost (PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(int id);
    PostDto updatePost(int id, PostDto postDto);
    Post deactivatePost(int postId);
    List<Post> getPostsByUser(int userId);
    Post createPostForUser(int userId, PostDto postDto);
}
