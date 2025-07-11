package com.example.questapp.business.services;

import org.springframework.stereotype.Service;

import com.example.questapp.dataAccess.abstracts.LikeRepository;

@Service
public class LikeService {
	
	LikeRepository likeRepository;

	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}
	
	
}
