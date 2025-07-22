package com.example.questapp.business.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.questapp.dataAccess.abstracts.UserRepository;
import com.example.questapp.entities.User;
import com.example.questapp.security.JwtUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private UserRepository userRepository;
	
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (user == null) {
		    throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return JwtUserDetails.create(user);
	}
	
	public UserDetails loadUserById(Long id) {
		User user = userRepository.findById(id)
		    .orElseThrow(() -> new UsernameNotFoundException("User not found with id: " + id));
		return JwtUserDetails.create(user);
	}

}
