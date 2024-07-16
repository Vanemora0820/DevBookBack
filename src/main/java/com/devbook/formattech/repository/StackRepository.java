package com.devbook.formattech.repository;

import com.devbook.formattech.entity.Stack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StackRepository extends JpaRepository <Stack, Integer> {
}
