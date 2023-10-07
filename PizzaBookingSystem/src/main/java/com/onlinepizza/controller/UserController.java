package com.onlinepizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.UserDTO;
import com.onlinepizza.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
		UserDTO registeredUser = userService.registerUser(userDTO);
		if (registeredUser != null) {
			return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/signin")
	public ResponseEntity<UserDTO> signIn(@RequestParam String userName, @RequestParam String password) {
		UserDTO userDTO = userService.signIn(userName, password);
		if (userDTO != null) {
			return new ResponseEntity<>(userDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}

	@PostMapping("/signout")
	public ResponseEntity<String> signOut() {
		String signOutMessage = userService.signOut();
		return new ResponseEntity<>(signOutMessage, HttpStatus.OK);
	}
}
