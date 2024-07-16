package com.devbook.formattech.repository;

import com.devbook.formattech.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository <UserProfile, Integer> {
}
