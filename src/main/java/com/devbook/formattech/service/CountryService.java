package com.devbook.formattech.service;

import com.devbook.formattech.Dto.CountryDto;
import com.devbook.formattech.entity.Country;


import java.util.List;

public interface CountryService {

    CountryDto createCountry (CountryDto countryDto);
    List<CountryDto> getAllCountries();
    CountryDto getCountryById(int id);
    CountryDto updateCountry(int id, CountryDto countryDto);
    Country deleteCountry(int id);
}
