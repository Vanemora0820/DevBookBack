package com.devbook.formattech.converter;


import com.devbook.formattech.Dto.GenderDto;
import com.devbook.formattech.entity.Gender;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class GenderMapper {

    public static GenderDto genderDto (Gender gender){

        GenderDto genderDto = new GenderDto();
        genderDto.setId(gender.getId());
        genderDto.setName(gender.getName());
        return genderDto;
    }

    public static Gender gender (GenderDto genderDto){

        Gender gender = new Gender();
        gender.setId(genderDto.getId());
        gender.setName(genderDto.getName());
        return gender;
    }
}
