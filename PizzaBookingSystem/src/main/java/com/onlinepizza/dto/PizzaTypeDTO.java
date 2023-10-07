package com.onlinepizza.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PizzaTypeDTO {
	
	@NotNull(message = "Pizza ID cannot be null")
	private Integer pizzaTypeId;
	
	
	// Veg or Non-Veg
	@NotNull(message = "Pizza Type cannot be null")
	private String pizzaTypeName;
	
	
	
	private List<ToppingsDTO> toppings;

}
