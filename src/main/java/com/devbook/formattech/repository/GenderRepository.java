package com.devbook.formattech.repository;

import com.devbook.formattech.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository <Gender, Integer> {
}
