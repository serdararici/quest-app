package com.example.questapp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questapp.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
