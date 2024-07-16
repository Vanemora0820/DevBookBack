package com.devbook.formattech.converter;

import com.devbook.formattech.Dto.UserDto;
import com.devbook.formattech.entity.User;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class UserMapper {

    public static UserDto userDto (User user) {

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        userDto.setSurname(user.getSurname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setDateOfBirth(user.getDateOfBirth());
        userDto.setRoles(user.getRoles().stream().map(RolMapper::rolDto).collect(Collectors.toList()));
        userDto.setGender(GenderMapper.genderDto(user.getGender()));
        userDto.setCountry(CountryMapper.countryDto(user.getCountry()));
        return userDto;
    }

    public static User user (UserDto userDto) {

        User user = new User();
        user.setId(userDto.getId());
        user.setUsername(userDto.getUsername());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setRoles(userDto.getRoles().stream().map(RolMapper::rol).collect(Collectors.toList()));
        user.setGender(GenderMapper.gender(userDto.getGender()));
        user.setCountry(CountryMapper.country(userDto.getCountry()));
        return user;

    }

}
