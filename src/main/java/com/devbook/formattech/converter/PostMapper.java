package com.devbook.formattech.converter;

import com.devbook.formattech.Dto.PostDto;
import com.devbook.formattech.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {

    public static PostDto postDto(Post post) {

        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setPost_content(post.getPost_content());
        postDto.setPost_media_url(post.getPost_media_url());
        postDto.setPost_picture_url(post.getPost_picture_url());
        return postDto;

    }

    public static Post post(PostDto postDto) {

        Post post = new Post();
        post.setId(postDto.getId());
        post.setPost_content(postDto.getPost_content());
        post.setPost_media_url(postDto.getPost_media_url());
        post.setPost_picture_url(postDto.getPost_picture_url());
        return post;
    }
}
