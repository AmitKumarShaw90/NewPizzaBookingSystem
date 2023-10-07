package com.onlinepizza.services;

import java.util.List;

import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.entity.PizzaType;

public interface PizzaTypeService {

	List<PizzaType> getAllPizzaTypes();

	PizzaType getPizzaTypeById(Integer id);

	PizzaType createPizzaType(PizzaTypeDTO pizzaTypeDTO);

	PizzaType updatePizzaType(Integer id, PizzaTypeDTO pizzaTypeDTO);

	void deletePizzaType(Integer id);
}
