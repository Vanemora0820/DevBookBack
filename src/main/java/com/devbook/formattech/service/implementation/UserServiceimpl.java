package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.PostDto;
import com.devbook.formattech.Dto.UserDto;
import com.devbook.formattech.converter.UserMapper;
import com.devbook.formattech.entity.Post;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.entity.UserProfile;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.*;
import com.devbook.formattech.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceimpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceimpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private UserProfileRepository profileRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userMapper.user(userDto);
        user.setGender(genderRepository.findById(userDto.getGender().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Gender not found with id: " + userDto.getGender().getId())));
        user.setRoles(userDto.getRoles().stream()
                .map(roleDto -> rolRepository.findById(roleDto.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleDto.getId())))
                .collect(Collectors.toList()));
        user.setCountry(countryRepository.findById(userDto.getCountry().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + userDto.getCountry().getId())));
        log.info("Creating user: " + userDto);
        user = userRepository.save(user);


        UserProfile userProfile = new UserProfile();
        userProfile.setUser(user);
        profileRepository.save(userProfile);
        return userMapper.userDto(user);
    }


    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::userDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public UserDto getUserById(int id) {
        return userRepository.findById(id)
                .map(UserMapper::userDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }

    @Override
    public UserDto updateUser(int id, UserDto userDto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));

        existingUser.setUsername(userDto.getUsername());
        existingUser.setSurname(userDto.getSurname());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPassword(userDto.getPassword());
        existingUser.setPhone(userDto.getPhone());
        existingUser.setDateOfBirth(userDto.getDateOfBirth());
        existingUser.setGender(genderRepository.findById(userDto.getGender().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Gender not found with id: " + userDto.getGender().getId())));
        existingUser.setRoles(userDto.getRoles().stream()
                .map(roleDto -> rolRepository.findById(roleDto.getId())
                        .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + roleDto.getId())))
                .collect(Collectors.toList()));
        existingUser.setCountry(countryRepository.findById(userDto.getCountry().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + userDto.getCountry().getId())));

        User updatedUser = userRepository.save(existingUser);
        return userMapper.userDto(updatedUser);
    }


    public User deleteUser(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setActive(false);
       return userRepository.save(user);
    }

}
