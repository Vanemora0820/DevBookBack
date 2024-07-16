package com.devbook.formattech.service;

import com.devbook.formattech.Dto.UserProfileDto;
import com.devbook.formattech.entity.UserProfile;

import java.util.List;

public interface UserProfileService {
  UserProfileDto createUserProfile(UserProfileDto userProfileDto);

  List<UserProfileDto> getAllUsersProfiles();

  UserProfileDto getUserProfileById(int id);

  UserProfileDto updateUserProfile(int id, UserProfileDto userProfileDto);

  UserProfile deleteUserP(int id);
}
