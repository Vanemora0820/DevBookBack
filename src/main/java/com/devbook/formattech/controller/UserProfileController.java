package com.devbook.formattech.controller;

import com.devbook.formattech.Dto.UserDto;
import com.devbook.formattech.Dto.UserProfileDto;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.entity.UserProfile;
import com.devbook.formattech.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/userProfile")
public class UserProfileController {
  @Autowired
  UserProfileService userProfileService;

  @PostMapping
  public ResponseEntity<UserProfileDto> createUserProfile(@RequestBody UserProfileDto userProfileDto) {
    UserProfileDto userProfile = userProfileService.createUserProfile(userProfileDto);
    return ResponseEntity.ok(userProfile);
  }

  @GetMapping("/getUsersProfiles")
  public ResponseEntity<List<UserProfileDto>> getUsersProfiles(){
    List<UserProfileDto> usersProfiles = userProfileService.getAllUsersProfiles();
    return ResponseEntity.ok(usersProfiles);
  }

  @GetMapping("/{id}")
  public ResponseEntity<UserProfileDto> getUserProfileById(@PathVariable int id) {
    UserProfileDto userProfile = userProfileService.getUserProfileById(id);
    return ResponseEntity.ok(userProfile);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserProfileDto> updateUserProfile(@PathVariable int id, @RequestBody UserProfileDto userProfileDto) {
    UserProfileDto updatedUserProfile = userProfileService.updateUserProfile(id, userProfileDto);
    return ResponseEntity.ok(updatedUserProfile);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<UserProfile> deleteUser(@PathVariable int id) {
    UserProfile deleteUserP = userProfileService.deleteUserP(id);
    return ResponseEntity.ok(deleteUserP);
  }
}
