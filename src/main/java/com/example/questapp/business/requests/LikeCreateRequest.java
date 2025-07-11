package com.example.questapp.business.requests;

import lombok.Data;

@Data
public class LikeCreateRequest {
	
	Long id;
	Long userId;
	Long postId;
	
}