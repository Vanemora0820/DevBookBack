package com.devbook.formattech.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    private int id;
    private String post_content;
    private String post_media_url;
    private String post_picture_url;
}
