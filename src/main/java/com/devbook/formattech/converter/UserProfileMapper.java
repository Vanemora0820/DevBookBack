package com.devbook.formattech.converter;

import com.devbook.formattech.Dto.UserProfileDto;
import com.devbook.formattech.entity.UserProfile;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {


    public static UserProfileDto userProfileDto (UserProfile userProfile) {

        UserProfileDto userProfileDto = new UserProfileDto();
        userProfileDto.setId(userProfile.getId());
        userProfileDto.setBio(userProfile.getBio());
        userProfileDto.setProfile_picture_url(userProfile.getProfile_picture_url());
        return userProfileDto;
    }

    public static UserProfile userProfile (UserProfileDto userProfileDto) {

        UserProfile userProfile = new UserProfile();
        userProfile.setId(userProfileDto.getId());
        userProfile.setBio(userProfileDto.getBio());
        userProfile.setProfile_picture_url(userProfileDto.getProfile_picture_url());
        return userProfile;
    }
}
