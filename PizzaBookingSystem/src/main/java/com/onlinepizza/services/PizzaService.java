package com.onlinepizza.services;

import java.util.List;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;

import jakarta.validation.Valid;

public interface PizzaService {

	PizzaDTO addPizza(PizzaDTO pizza);

	ToppingsDTO addToppings(ToppingsDTO toppings);

	PizzaDTO updatePizza(PizzaDTO pizza);

	PizzaDTO viewPizzaById(Integer pizzaId);

	List<PizzaDTO> viewPizzaByPizzaType(String pizzaType);

	List<PizzaDTO> viewPizzaByPizzaSize(String pizzaSize);

	List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice);

	List<PizzaDTO> viewAllPizza();

	List<ToppingsDTO> viewToppings();

	ToppingsDTO viewToppingByID(Integer toppingsID);

	PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId);

	List<PizzaTypeDTO> viewAllPizzaTypes();

	PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaTypeDTO);

}
