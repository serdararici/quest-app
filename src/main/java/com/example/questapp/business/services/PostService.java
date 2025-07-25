package com.example.questapp.business.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.example.questapp.business.requests.PostCreateRequest;
import com.example.questapp.business.requests.PostUpdateRequest;
import com.example.questapp.business.responses.LikeResponse;
import com.example.questapp.business.responses.PostResponse;
import com.example.questapp.dataAccess.abstracts.PostRepository;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;

@Service
public class PostService {

	private PostRepository postRepository;
	private UserService userService;
	private LikeService likeService;

	public PostService(PostRepository postRepository, UserService userService,  @Lazy LikeService likeService) {
		this.postRepository = postRepository;
		this.userService = userService;
		this.likeService = likeService;
	}
	
	/*
	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}
	*/

	public List<PostResponse> getAllPosts(Optional<Long> userId) {
		List<Post> list;
		if(userId.isPresent()) {
			list = postRepository.findByUserId(userId.get());
		} else {
			list = postRepository.findAll();
		}
		return list.stream().map(p -> { 
			List<LikeResponse> likes = likeService.getAllLikesWithParam(Optional.ofNullable(null), Optional.of(p.getId()));
			return new PostResponse(p, likes);}).collect(Collectors.toList());
			
	}

	public Post getOnePostById(Long postId) {
		return postRepository.findById(postId).orElse(null);
	}

	public Post createOnePost(PostCreateRequest newPostRequest) {
		User user = userService.getOneUserById(newPostRequest.getUserId());
		if(user == null) {
			return null;
		} else {
			Post toSave = new Post();
			toSave.setId(newPostRequest.getId());
			toSave.setText(newPostRequest.getText());
			toSave.setTitle(newPostRequest.getTitle());
			toSave.setUser(user);
			return postRepository.save(toSave);
		}
		
	}

	public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
		Optional<Post> post = postRepository.findById(postId);
		if(post.isPresent()) {
			Post toUpdate = post.get();
			toUpdate.setText(updatePost.getText());
			toUpdate.setTitle(updatePost.getTitle());
			postRepository.save(toUpdate);
			return toUpdate;
		}
		return null;
	}

	public void deleteOnePostById(Long postId) {
		postRepository.deleteById(postId);
	}
	
	
	
}
