package com.onlinepizza.dto;

import com.onlinepizza.util.PizzaSize;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class PizzaDTO {
	
	
	
	private Integer pizzaId;
	
	@NotNull(message = "Pizza Name cannot be null")
	@Size(min=3, max =50, message = "Pizza name must be between 3 and 50 characters")
	private String pizzaName;
	
	
	private String pizzaDescription;
	
	
	@NotNull(message = "Prize should be mandatory")
	private Double pizzaCost;
	
	
	
	private PizzaTypeDTO pizzaType;
	
	private PizzaSize pizzaSize;

	
}
