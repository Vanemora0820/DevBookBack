package com.devbook.formattech.service.implementation;

import com.devbook.formattech.Dto.CountryDto;
import com.devbook.formattech.converter.CountryMapper;
import com.devbook.formattech.entity.Country;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.exceptions.ResourceNotFoundException;
import com.devbook.formattech.repository.CountryRepository;
import com.devbook.formattech.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private static final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryMapper countryMapper;


    @Override
    public CountryDto createCountry(CountryDto countryDto) {
        Country country = countryMapper.country(countryDto);
        country = countryRepository.save(country);
        return countryMapper.countryDto(country);
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryRepository.findAll().stream()
                .map(CountryMapper::countryDto).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public CountryDto getCountryById(int id) {
        return countryRepository.findById(id)
                .map(CountryMapper::countryDto)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
    }


    @Override
    public CountryDto updateCountry(int id, CountryDto countryDto) {
        Country existingCountry = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Country not found with id: " + id));
        existingCountry.setName(countryDto.getName());
        Country updatedCountry = countryRepository.save(existingCountry);
        return countryMapper.countryDto(updatedCountry);
    }

    public Country deleteCountry(int id) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        country.setActive(false);
        return countryRepository.save(country);
    }

}
