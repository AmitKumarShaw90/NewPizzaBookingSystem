package com.onlinepizza.dto;

import com.onlinepizza.entity.PizzaType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToppingsDTO {
	
	
	@NotNull(message = "Toppings ID cannot be null")
	private Integer toppingsId;
	
	@NotNull(message = "Toppings Name cannot be null")
	private String toppingsName;
	
	@NotNull(message = "Price cannot be null")
	private Double price;

	PizzaType pizzaType;
}
