package com.devbook.formattech.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private int id;
    private String username;
    private String surname;
    private String email;
    private String password;
    private Long phone;
    private String dateOfBirth;
    private GenderDto gender;
    private List<RolDto> roles;
    private CountryDto country;



}
