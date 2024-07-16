package com.devbook.formattech.converter;


import com.devbook.formattech.Dto.CountryDto;
import com.devbook.formattech.Dto.UserDto;
import com.devbook.formattech.entity.Country;
import com.devbook.formattech.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {


    public static CountryDto countryDto (Country country){

        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getId());
        countryDto.setName(country.getName());
        return countryDto;
    }

    public  static  Country country (CountryDto countryDto){

        Country country = new Country();
        country.setId(countryDto.getId());
        country.setName(countryDto.getName());
        return country;
    }

}
