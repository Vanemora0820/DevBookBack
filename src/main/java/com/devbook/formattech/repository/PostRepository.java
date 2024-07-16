package com.devbook.formattech.repository;

import com.devbook.formattech.entity.Post;
import com.devbook.formattech.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository <Post, Integer> {

    @Query("SELECT p FROM Post p JOIN FETCH p.user u WHERE u.id = :userId AND p.active = true")
    List<Post> findActivePostsByUserId(@Param("userId") int userId);

}
