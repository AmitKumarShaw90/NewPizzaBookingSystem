package com.onlinepizza.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.UserDTO;
import com.onlinepizza.entity.User;
import com.onlinepizza.repository.UserRepository;
import com.onlinepizza.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUserName());
		user.setPassword(userDTO.getPassword());
		user.setUserRole(userDTO.getUserRole());

		// You may set other properties of the User entity as needed.

		userRepository.save(user);

		// Set the generated user ID in the DTO
		userDTO.setUserId(user.getUserId());

		return userDTO;
	}

	public UserDTO signIn(String userName, String password) {
		// Step 1: Query the repository to find the user by username.
		User user = userRepository.findByUserName(userName);

		if (user == null) {
			// User not found.
			return null;
		}

		// Step 2: Validate the password (plain text comparison).
		if (!isPasswordValid(password, user.getPassword())) {
			// Password is incorrect.
			return null;
		}

		// Step 3: Create a UserDTO and populate it with user information.
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setUserName(user.getUserName());
		userDTO.setUserRole(user.getUserRole());

		// You may set other properties of the UserDTO as needed.

		return userDTO;
	}

	// Helper method to validate the password using plain text comparison.
	private boolean isPasswordValid(String inputPassword, String storedPassword) {
		// Perform plain text password comparison.
		return inputPassword.equals(storedPassword);
	}
	

	@Override
	public String signOut() {
		// Implement the logic to sign out a user. You may use session management here.
		// Return a message or status indicating the sign-out operation.
		// This method does not require a DTO response.
		return "User signed out successfully.";
	}
}
