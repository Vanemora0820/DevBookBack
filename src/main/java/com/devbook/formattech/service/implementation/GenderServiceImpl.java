package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.GenderDto;
import com.devbook.formattech.converter.GenderMapper;
import com.devbook.formattech.entity.Gender;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.GenderRepository;
import com.devbook.formattech.service.GenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenderServiceImpl implements GenderService {

    private static final Logger log = LoggerFactory.getLogger(GenderServiceImpl.class);

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private GenderMapper genderMapper;


    @Override
    public GenderDto createGender(GenderDto genderDto) {
        Gender gender = genderMapper.gender(genderDto);
        gender = genderRepository.save(gender);
        return genderMapper.genderDto (gender);
    }



    @Override
    public List<GenderDto> getAllGenders() {
        return genderRepository.findAll().stream()
                .map(GenderMapper::genderDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public GenderDto getGenderById(int id) {
        return genderRepository.findById(id)
                .map(GenderMapper::genderDto)
                .orElseThrow(() -> new ResourceNotFoundException("Gender not found with id: " + id));
    }


    @Override
    public GenderDto updateGender(int id, GenderDto genderDto) {
        Gender existingGender = genderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gender not found with id: " + id));
        existingGender.setName(genderDto.getName());
        Gender updatedGender = genderRepository.save(existingGender);
        return genderMapper.genderDto(updatedGender);
    }

    public Gender deleteGender(int id) {
        Gender gender = genderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        gender.setActive(false);
        return genderRepository.save(gender);
    }

}
