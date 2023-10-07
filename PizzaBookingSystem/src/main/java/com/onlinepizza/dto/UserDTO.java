package com.onlinepizza.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	private String userName;
	
	private String password;
	
	private String userRole;

}
