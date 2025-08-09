package com.example.questapp.business.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.questapp.business.requests.CommentCreateRequest;
import com.example.questapp.business.requests.CommentUpdateRequest;
import com.example.questapp.business.responses.CommentResponse;
import com.example.questapp.dataAccess.abstracts.CommentRepository;
import com.example.questapp.entities.Comment;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;



@Service
@Transactional
public class CommentService {
	
	private CommentRepository commentRepository;
	private UserService userService;
	private PostService postService;

	

	public CommentService(CommentRepository commentRepository, UserService userService, PostService postService) {
		this.commentRepository = commentRepository;
		this.userService = userService;
		this.postService = postService;
	}

	@Transactional(readOnly = true)
	public List<CommentResponse> getAllCommentsWithParam(Optional<Long> userId, Optional<Long> postId) {
		List<Comment> comments;
		if(userId.isPresent() && postId.isPresent()) {
			comments = commentRepository.findByUserIdAndPostId(userId.get(), postId.get());
		}else if(userId.isPresent()) {
			comments = commentRepository.findByUserId(userId.get());
		}else if(postId.isPresent()) {
			comments = commentRepository.findByPostId(postId.get());
		}else
			comments = commentRepository.findAll();
		return comments.stream().map(comment -> new CommentResponse(comment)).collect(Collectors.toList());
	}
	
	public Comment getOneCommentById(Long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}
	
	public Comment createOneComment(CommentCreateRequest newCommentRequest) {
		User user = userService.getOneUserById(newCommentRequest.getUserId());
		Post post = postService.getOnePostById(newCommentRequest.getPostId());
		
		if(user != null && post != null) {
			Comment commentToSave = new Comment();
			commentToSave.setId(newCommentRequest.getId());
			commentToSave.setPost(post);
			commentToSave.setUser(user);
			commentToSave.setText(newCommentRequest.getText());
			commentToSave.setCreateDate(new Date());
			return commentRepository.save(commentToSave);
		} else {
			return null;
		}
		
	}

	public Comment updateOneCommentById(Long commentId, CommentUpdateRequest updateRequest) {
		Optional<Comment> comment = commentRepository.findById(commentId);
		if(comment.isPresent()) {
			Comment commentToUpdate = comment.get();
			commentToUpdate.setText(updateRequest.getText());
			return commentRepository.save(commentToUpdate);
		} else {
			return null;
		}
	}

	public void deleteOneCommentById(Long commentId) {
		commentRepository.deleteById(commentId);
		
	}

	

	
	
}
