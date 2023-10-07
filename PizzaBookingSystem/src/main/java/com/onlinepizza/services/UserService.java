package com.onlinepizza.services;

import com.onlinepizza.dto.UserDTO;

public interface UserService {
	
	UserDTO registerUser(UserDTO user);

	UserDTO signIn(String userName, String password);

	// use session management accordingly
	public String signOut();

}
