package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.PostDto;
import com.devbook.formattech.converter.PostMapper;
import com.devbook.formattech.entity.Post;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.PostRepository;
import com.devbook.formattech.repository.UserRepository;
import com.devbook.formattech.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PostServiceImpl implements PostService {

    private static final Logger log = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserRepository userRepository;


    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = postMapper.post(postDto);
        post = postRepository.save(post);
        return postMapper.postDto(post);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostMapper::postDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public PostDto getPostById(int id) {
        return postRepository.findById(id)
                .map(PostMapper::postDto)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
    }

    @Override
    public PostDto updatePost(int id, PostDto postDto) {
        Post existingPost = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        existingPost.setPost_content(postDto.getPost_content());
        existingPost.setPost_media_url(postDto.getPost_media_url());
        existingPost.setPost_picture_url(postDto.getPost_picture_url());
        Post updatedPost = postRepository.save(existingPost);
        return postMapper.postDto(updatedPost);
    }


    public Post createPostForUser(int userId, PostDto postDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        Post post = new Post();
        post.setPost_content(postDto.getPost_content());
        post.setPost_picture_url(postDto.getPost_picture_url());
        post.setPost_media_url(postDto.getPost_media_url());
        post.setUser(user);

        return postRepository.save(post);
    }

    @Override
    public List<Post> getPostsByUser(int userId) {
        return postRepository.findActivePostsByUserId(userId);
    }

    public Post deactivatePost(int postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + postId));

        post.setActive(false);

        return postRepository.save(post);
    }
}
