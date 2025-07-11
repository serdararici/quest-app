package com.example.questapp.business.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.questapp.business.requests.LikeCreateRequest;
import com.example.questapp.dataAccess.abstracts.LikeRepository;
import com.example.questapp.entities.Like;
import com.example.questapp.entities.Post;
import com.example.questapp.entities.User;

@Service
public class LikeService {

	private LikeRepository likeRepository;
	private UserService userService;
	private PostService postService;

	public LikeService(LikeRepository likeRepository, UserService userService, 
			PostService postService) {
		this.likeRepository = likeRepository;
		this.userService = userService;
		this.postService = postService;
	}

	public List<Like> getAllLikesWithParam(Optional<Long> userId, Optional<Long> postId) {
		List<Like> list;
		if(userId.isPresent() && postId.isPresent()) {
			list = likeRepository.findByUserIdAndPostId(userId.get(), postId.get());
			return list;
		}else if(userId.isPresent()) {
			list = likeRepository.findByUserId(userId.get());
			return list;
		}else if(postId.isPresent()) {
			list = likeRepository.findByPostId(postId.get());
			return list;
		}else
			list = likeRepository.findAll();
		return list;
		//return list.stream().map(like -> new LikeResponse(like)).collect(Collectors.toList());
	}

	public Like getOneLikeById(Long LikeId) {
		return likeRepository.findById(LikeId).orElse(null);
	}

	public Like createOneLike(LikeCreateRequest request) {
		User user = userService.getOneUserById(request.getUserId());
		Post post = postService.getOnePostById(request.getPostId());
		if(user != null && post != null) {
			Like likeToSave = new Like();
			likeToSave.setId(request.getId());
			likeToSave.setPost(post);
			likeToSave.setUser(user);
			return likeRepository.save(likeToSave);
		}else		
			return null;
	}

	public void deleteOneLikeById(Long likeId) {
		likeRepository.deleteById(likeId);
	}
	
	
}