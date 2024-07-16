package com.devbook.formattech.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private int id;
//    private int post_id;
//    private int user_id;
    private String comm_content;
    private String comm_media_url;
    private String comm_picture_url;

}
