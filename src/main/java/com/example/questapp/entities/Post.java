package com.example.questapp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="post")
@Data
public class Post {
	
	@Id
	Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)   //fetch lazy means we don't need user object when we call posts
	@JoinColumn(name="user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)  // when user is deleted, it deletes post that belongs to the user.
	@JsonIgnore
	User user;
	
	String title;
	
	// Stores a large block of text in the database using the 'TEXT' column type.
	// Useful for long descriptions, articles, or JSON strings.
	@Lob
	@Column(columnDefinition = "text")
	String text;
}
