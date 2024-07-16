package com.devbook.formattech.converter;


import com.devbook.formattech.Dto.CommentDto;
import com.devbook.formattech.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public static CommentDto commentDto (Comment comment){

        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setComm_content(comment.getComm_content());
        commentDto.setComm_media_url(comment.getComm_media_url());
        commentDto.setComm_picture_url(comment.getComm_picture_url());
        return commentDto;

    }

    public static Comment comment (CommentDto commentDto){

        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setComm_content(commentDto.getComm_content());
        comment.setComm_media_url(commentDto.getComm_media_url());
        comment.setComm_picture_url(commentDto.getComm_picture_url());
        return comment;
    }
}
