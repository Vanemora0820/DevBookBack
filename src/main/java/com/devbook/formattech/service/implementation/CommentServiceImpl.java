package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.CommentDto;
import com.devbook.formattech.converter.CommentMapper;
import com.devbook.formattech.entity.Comment;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.CommentRepository;
import com.devbook.formattech.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service

public class CommentServiceImpl implements CommentService {

    private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public CommentDto createComment(CommentDto commentDto) {
        Comment comment = commentMapper.comment(commentDto);
        comment = commentRepository.save(comment);
        return commentMapper.commentDto(comment);
    }


    @Override
    public List<CommentDto> getAllComments() {
        return commentRepository.findAll().stream()
                .map(CommentMapper::commentDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public CommentDto getCommentById(int id) {
        return commentRepository.findById(id)
                .map(CommentMapper::commentDto)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
    }


    @Override
    public CommentDto updateComment(int id, CommentDto commentDto) {
        Comment existingComment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment not found with id: " + id));
        existingComment.setComm_content(commentDto.getComm_content());
        existingComment.setComm_media_url(commentDto.getComm_media_url());
        existingComment.setComm_picture_url(commentDto.getComm_picture_url());
        Comment updatedComment = commentRepository.save(existingComment);
        return commentMapper.commentDto(updatedComment);
    }

    public Comment deleteComment(int id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        comment.setActive(false);
        return commentRepository.save(comment);
    }
}
