package com.devbook.formattech.service.implementation;


import com.devbook.formattech.Dto.UserProfileDto;
import com.devbook.formattech.converter.UserProfileMapper;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.entity.UserProfile;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.UserProfileRepository;
import com.devbook.formattech.service.UserProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserProfileServiceImpl implements UserProfileService {

  private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

  @Autowired
  private UserProfileRepository userProfileRepository;

  @Autowired
  private UserProfileMapper userProfileMapper;

  @Override
  public UserProfileDto createUserProfile(UserProfileDto userProfileDto) {
    UserProfile userProfile = userProfileMapper.userProfile(userProfileDto);
    userProfile = userProfileRepository.save(userProfile);
    return userProfileMapper.userProfileDto(userProfile);
  }

  @Override
  public List<UserProfileDto> getAllUsersProfiles() {
    return userProfileRepository.findAll().stream()
            .map(UserProfileMapper::userProfileDto).collect(Collectors.toUnmodifiableList());
  }

  @Override
  public UserProfileDto getUserProfileById(int id) {
    return userProfileRepository.findById(id)
            .map(UserProfileMapper::userProfileDto)
            .orElseThrow(() -> new ResourceNotFoundException("User profile not found with id: " + id));
  }

  @Override
  public UserProfileDto updateUserProfile(int id, UserProfileDto userProfileDto) {
    UserProfile existingUserProfile = userProfileRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User profile not found with id: " + id));
    existingUserProfile.setBio(userProfileDto.getBio());
    existingUserProfile.setProfile_picture_url(userProfileDto.getProfile_picture_url());
    UserProfile updatedUserProfile = userProfileRepository.save(existingUserProfile);
    return userProfileMapper.userProfileDto(updatedUserProfile);
  }

  public UserProfile deleteUserP(int id) {
    UserProfile userP = userProfileRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    userP.setActive(false);
    return userProfileRepository.save(userP);
  }
}
