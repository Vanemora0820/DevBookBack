package com.devbook.formattech.Dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UserProfileDto {
    private int id;
    private String bio;
    private String profile_picture_url;
}
