package com.devbook.formattech.controller;

import com.devbook.formattech.Dto.CountryDto;
import com.devbook.formattech.entity.Country;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/country")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDto> createCountry(@RequestBody CountryDto countryDto) {

            CountryDto createdCountry = countryService.createCountry(countryDto);
            return ResponseEntity.ok(createdCountry);
        }

        @GetMapping("/getCountries")
        public ResponseEntity <List<CountryDto>> getCountries() {
            List<CountryDto> countries = countryService.getAllCountries();
            return ResponseEntity.ok(countries);
        }

        @GetMapping("/{id}")
        public ResponseEntity<CountryDto> getCountryById(@PathVariable int id) {
            CountryDto country = countryService.getCountryById(id);
            return ResponseEntity.ok(country);
        }

        @PutMapping("/{id}")
        public ResponseEntity<CountryDto> updateCountry(@PathVariable int id, @RequestBody CountryDto countryDto) {
            CountryDto updatedCountry = countryService.updateCountry(id, countryDto);
            return ResponseEntity.ok(updatedCountry);
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Country> deleteUser(@PathVariable int id) {
        Country deleteCountry = countryService.deleteCountry(id);
        return ResponseEntity.ok(deleteCountry);
    }
    }

