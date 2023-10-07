package com.onlinepizza.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.services.PizzaTypeService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PizzaTypeServiceImpl implements PizzaTypeService{

	@Autowired
	PizzaTypeRepository pizzaTypeRepository;

	@Override
	public List<PizzaType> getAllPizzaTypes() {
		return pizzaTypeRepository.findAll();
	}

	@Override
	public PizzaType getPizzaTypeById(Integer id) {
		return pizzaTypeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("PizzaType with id " + id + " not found"));
	}

	@Override
	public PizzaType createPizzaType(PizzaTypeDTO pizzaTypeDTO) {
		PizzaType pizzaType = new PizzaType();
		pizzaType.setPizzaTypeName(pizzaTypeDTO.getPizzaTypeName());
		return pizzaTypeRepository.save(pizzaType);
	}

	@Override
	public PizzaType updatePizzaType(Integer id, PizzaTypeDTO pizzaTypeDTO) {
		PizzaType existingPizzaType = getPizzaTypeById(id);
		existingPizzaType.setPizzaTypeName(pizzaTypeDTO.getPizzaTypeName());
		return pizzaTypeRepository.save(existingPizzaType);
	}

	@Override
	public void deletePizzaType(Integer id) {
		PizzaType existingPizzaType = getPizzaTypeById(id);
		pizzaTypeRepository.delete(existingPizzaType);
	}
}
