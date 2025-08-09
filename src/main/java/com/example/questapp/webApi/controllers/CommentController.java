package com.example.questapp.webApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.questapp.business.requests.CommentCreateRequest;
import com.example.questapp.business.requests.CommentUpdateRequest;
import com.example.questapp.business.responses.CommentResponse;
import com.example.questapp.business.services.CommentService;
import com.example.questapp.entities.Comment;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	CommentService commentService;

	public CommentController(CommentService commentService) {
		this.commentService = commentService;
	}
	
	@GetMapping
	public List<CommentResponse> getAllComments(@RequestParam Optional<Long> userId, @RequestParam Optional<Long> postId) {
		return commentService.getAllCommentsWithParam(userId, postId);
	}
	
	@GetMapping("/{commentId}")
	public Comment getOneComment(@PathVariable Long commentId) {
		return commentService.getOneCommentById(commentId);
	}
	
	@PostMapping
	public Comment createOneComment(@RequestBody CommentCreateRequest newCommentRequest) {
		return commentService.createOneComment(newCommentRequest);
	}
	
	
	@PutMapping("/{commentId}")
	public Comment updateOneComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequest updateRequest) {
		return commentService.updateOneCommentById(commentId, updateRequest);
	}
	
	@DeleteMapping("/{commentId}") 
	public void deleteOneComment(@PathVariable Long commentId) {
		commentService.deleteOneCommentById(commentId);
	}
	
}
