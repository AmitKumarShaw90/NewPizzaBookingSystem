package com.onlinepizza.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class CustomerDTO {

	private Integer customerID;

	@NotNull(message = "Customer Name cannot be null")
	@Min(value = 3, message = "Customer Name should contains atleast 3 characters")
	private String customerName;

	@NotNull(message = "Customer Mobile number cannot be null")
	@Min(value = 10, message = "Mobile number should contains atleast 10 digits")
	private Long customerMobile;

	@NotNull(message = "Customer Email cannot be null")
	@Email(message = "Please give valid email address")
	private String customerEmail;

	@NotNull(message = "Customer Address cannot be null")
	private String customerAddress;

}
