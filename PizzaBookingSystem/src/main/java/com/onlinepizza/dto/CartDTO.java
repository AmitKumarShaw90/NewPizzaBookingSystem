package com.onlinepizza.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data      //used for getters and setters and to string

@NoArgsConstructor
public class CartDTO {
	
	@NotNull(message = "Cart ID cannot be null")
	private Integer cartId;
	
	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity must be at least 1")
	private Integer quantity;
	
	@NotNull(message = "Customer ID cannot be null")
	private Integer customerID;
	
	@NotNull(message = "Pizza Id cannot be null")
	private Integer pizzaId;
	
	//getters and setters (DATA annotation

}
