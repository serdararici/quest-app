package com.example.questapp.business.responses;

import java.util.List;

import com.example.questapp.entities.Like;
import com.example.questapp.entities.Post;

import lombok.Data;

@Data
public class PostResponse {
	Long id;
	Long userId;
	String userName;
	String title;
	String text;
	List<LikeResponse> postLikes;
	
	public PostResponse(Post entity, List<LikeResponse> likes) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.title = entity.getTitle();
		this.text = entity.getText();
		this.postLikes = likes;
	}
}
