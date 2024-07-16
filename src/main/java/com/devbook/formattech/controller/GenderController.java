package com.devbook.formattech.controller;

import com.devbook.formattech.Dto.GenderDto;
import com.devbook.formattech.entity.Gender;
import com.devbook.formattech.entity.User;
import com.devbook.formattech.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/gender")
public class GenderController {

    @Autowired
    GenderService genderService;

    @PostMapping
    public ResponseEntity<GenderDto> createGender(@RequestBody GenderDto genderDto) {

        GenderDto createdGender = genderService.createGender(genderDto);
        return ResponseEntity.ok(createdGender);
    }


    @GetMapping("/getGenders")

    public ResponseEntity <List<GenderDto>> getGenders() {
        List<GenderDto> genders = genderService.getAllGenders();
        return ResponseEntity.ok(genders);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenderDto> getGenderById(@PathVariable int id) {
        GenderDto gender = genderService.getGenderById(id);
        return ResponseEntity.ok(gender);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenderDto> updateGender(@PathVariable int id, @RequestBody GenderDto genderDto) {
        GenderDto updatedGender = genderService.updateGender(id, genderDto);
        return ResponseEntity.ok(updatedGender);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Gender> deleteUser(@PathVariable int id) {
        Gender deleteGender = genderService.deleteGender(id);
        return ResponseEntity.ok(deleteGender);
    }
}
