package com.devbook.formattech.service;

import com.devbook.formattech.Dto.GenderDto;
import com.devbook.formattech.entity.Gender;
import org.springframework.stereotype.Component;

import java.util.List;


public interface GenderService {

    GenderDto createGender (GenderDto genderDto);
    List<GenderDto> getAllGenders();
    GenderDto getGenderById(int id);
    GenderDto updateGender(int id, GenderDto genderDto);
    Gender deleteGender(int id);

}
