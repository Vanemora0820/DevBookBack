package com.devbook.formattech.repository;

import com.devbook.formattech.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository <Reaction, Integer> {
}
