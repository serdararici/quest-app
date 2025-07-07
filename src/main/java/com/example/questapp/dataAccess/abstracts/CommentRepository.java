package com.example.questapp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.questapp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
