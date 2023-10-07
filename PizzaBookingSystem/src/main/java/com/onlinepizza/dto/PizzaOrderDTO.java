package com.onlinepizza.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.onlinepizza.util.PizzaStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PizzaOrderDTO {
	
	@NotNull(message = "Booking order cannot be null")
	private Integer bookingOrderId;
	
	@NotNull(message = "Date cannot be null")
	private LocalDateTime dateTimeOfOrder;
	
	@NotNull(message = "Quantity cannot be null")
	@Min(value = 1, message = "Quantity should be greater than or equal to 1")
	private Integer quantity;
	
	@NotNull(message = "Total cost cannot be null")
	private Double totalCost;
	
	private List<PizzaDTO> pizzaList;
	
	private CustomerDTO customer;
	
	private PizzaStatus status;

	

}
