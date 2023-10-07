package com.onlinepizza.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.Pizza;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.repository.PizzaRepository;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.services.PizzaService;
import com.onlinepizza.util.PizzaSize;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	PizzaRepository pizzaRepository;

	@Autowired
	ToppingsRepository toppingsRepository;

	@Autowired
	PizzaTypeRepository pizzaTypeRepository;

	@Override
	public PizzaDTO addPizza(PizzaDTO pizzaDTO) {
		Pizza pizza = new Pizza();
		pizza.setPizzaName(pizzaDTO.getPizzaName());
		pizza.setPizzaDescription(pizzaDTO.getPizzaDescription());
		pizza.setPizzaSize(pizzaDTO.getPizzaSize());
		pizza.setPizzaCost(pizzaDTO.getPizzaCost());

		pizzaRepository.save(pizza);
		return pizzaDTO;
	}

	@Override
	public ToppingsDTO addToppings(ToppingsDTO toppings) {
		Toppings newToppings = new Toppings();
		newToppings.setToppingsName(toppings.getToppingsName());
		newToppings.setPrice(toppings.getPrice());

		toppingsRepository.save(newToppings);
		return toppings;
	}

	@Override
	public PizzaTypeDTO addPizzaType(PizzaTypeDTO pizzaTypeDTO) {
		PizzaType newPizzaType = new PizzaType();
		newPizzaType.setPizzaTypeName(pizzaTypeDTO.getPizzaTypeName());

		pizzaTypeRepository.save(newPizzaType);
		return pizzaTypeDTO;
	}

	@Override
	public PizzaDTO updatePizza(PizzaDTO pizzaDTO) {
		Optional<Pizza> existingPizzaOptional = pizzaRepository.findById(pizzaDTO.getPizzaId());

		if (existingPizzaOptional.isPresent()) {
			Pizza existingPizza = existingPizzaOptional.get();
			existingPizza.setPizzaName(pizzaDTO.getPizzaName());
			existingPizza.setPizzaDescription(pizzaDTO.getPizzaDescription());
			existingPizza.setPizzaSize(pizzaDTO.getPizzaSize());
			existingPizza.setPizzaCost(pizzaDTO.getPizzaCost());

			pizzaRepository.save(existingPizza);
			return pizzaDTO;
		} else {

			// handle exception here
			return null;
		}
	}

	@Override
	public PizzaDTO viewPizzaById(Integer pizzaId) {
		Optional<Pizza> pizzaOptional = pizzaRepository.findById(pizzaId);

		if (pizzaOptional.isPresent()) {
			Pizza pizza = pizzaOptional.get();
			PizzaDTO pizzaDTO = new PizzaDTO();
			pizzaDTO.setPizzaId(pizza.getPizzaId());
			pizzaDTO.setPizzaName(pizza.getPizzaName());
			pizzaDTO.setPizzaDescription(pizza.getPizzaDescription());
			pizzaDTO.setPizzaSize(pizza.getPizzaSize());
			pizzaDTO.setPizzaCost(pizza.getPizzaCost());

			// You can also set pizzaType, pizzaOrder, and cart as needed.

			return pizzaDTO;
		} else {
			// Handle the case when the pizza with the given ID is not found.
			return null;
		}
	}

	@Override
	public ToppingsDTO viewToppingByID(Integer toppingsID) {
		Optional<Toppings> toppingsOptional = toppingsRepository.findById(toppingsID);

		if (toppingsOptional.isPresent()) {
			Toppings toppings = toppingsOptional.get();
			ToppingsDTO toppingsDTO = new ToppingsDTO();
			toppingsDTO.setToppingsId(toppings.getToppingsId());
			toppingsDTO.setToppingsName(toppings.getToppingsName());
			toppingsDTO.setPrice(toppings.getPrice());

			return toppingsDTO;
		} else {
			// Handle the case when the toppings with the given ID is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}

	@Override
	public PizzaTypeDTO viewPizzaTypeById(Integer pizzaTypeId) {
		Optional<PizzaType> pizzaTypeOptional = pizzaTypeRepository.findById(pizzaTypeId);

		if (pizzaTypeOptional.isPresent()) {
			PizzaType pizzaType = pizzaTypeOptional.get();
			PizzaTypeDTO pizzaTypeDTO = new PizzaTypeDTO();
			pizzaTypeDTO.setPizzaTypeId(pizzaType.getPizzaTypeId());
			pizzaTypeDTO.setPizzaTypeName(pizzaType.getPizzaTypeName());

			return pizzaTypeDTO;
		} else {
			// Handle the case when the pizza type with the given ID is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}

	@Override
	public List<PizzaDTO> viewPizzaByPizzaType(String pizzaTypeName) {
		// Implement the logic to retrieve pizzas by pizza type and convert them to
		// DTOs.
		List<Pizza> pizzasByType = pizzaRepository.findByPizzaType_PizzaTypeName(pizzaTypeName);
		List<PizzaDTO> pizzaDTOs = new ArrayList<>();

		for (Pizza pizza : pizzasByType) {
			PizzaDTO pizzaDTO = new PizzaDTO();
			pizzaDTO.setPizzaId(pizza.getPizzaId());
			pizzaDTO.setPizzaName(pizza.getPizzaName());
			pizzaDTO.setPizzaDescription(pizza.getPizzaDescription());
			pizzaDTO.setPizzaSize(pizza.getPizzaSize());
			pizzaDTO.setPizzaCost(pizza.getPizzaCost());

			// You can also set pizzaType, pizzaOrder, and cart as needed.

			pizzaDTOs.add(pizzaDTO);
		}

		return pizzaDTOs;
	}

	@Override
	public List<PizzaDTO> viewPizzaByPizzaSize(String pizzaSize) {
		// Implement the logic to retrieve pizzas by pizza size and convert them to
		// DTOs.
		List<Pizza> pizzasBySize = pizzaRepository.findByPizzaSize(PizzaSize.valueOf(pizzaSize));
		List<PizzaDTO> pizzaDTOs = new ArrayList<>();

		for (Pizza pizza : pizzasBySize) {
			PizzaDTO pizzaDTO = new PizzaDTO();
			pizzaDTO.setPizzaId(pizza.getPizzaId());
			pizzaDTO.setPizzaName(pizza.getPizzaName());
			pizzaDTO.setPizzaDescription(pizza.getPizzaDescription());
			pizzaDTO.setPizzaSize(pizza.getPizzaSize());
			pizzaDTO.setPizzaCost(pizza.getPizzaCost());

			// You can also set pizzaType, pizzaOrder, and cart as needed.

			pizzaDTOs.add(pizzaDTO);
		}

		return pizzaDTOs;
	}

	@Override
	public List<PizzaDTO> viewPizzaByPrice(Double minPrice, Double maxPrice) {
		// Implement the logic to retrieve pizzas within a price range and convert them
		// to DTOs.
		List<Pizza> pizzasByPriceRange = pizzaRepository.findByPizzaCostBetween(minPrice, maxPrice);
		List<PizzaDTO> pizzaDTOs = new ArrayList<>();

		for (Pizza pizza : pizzasByPriceRange) {
			PizzaDTO pizzaDTO = new PizzaDTO();
			pizzaDTO.setPizzaId(pizza.getPizzaId());
			pizzaDTO.setPizzaName(pizza.getPizzaName());
			pizzaDTO.setPizzaDescription(pizza.getPizzaDescription());
			pizzaDTO.setPizzaSize(pizza.getPizzaSize());
			pizzaDTO.setPizzaCost(pizza.getPizzaCost());

			// You can also set pizzaType, pizzaOrder, and cart as needed.

			pizzaDTOs.add(pizzaDTO);
		}

		return pizzaDTOs;
	}

	@Override
	public List<PizzaDTO> viewAllPizza() {
		// Implement the logic to retrieve all pizzas and convert them to DTOs.
		List<Pizza> allPizzas = pizzaRepository.findAll();
		List<PizzaDTO> pizzaDTOs = new ArrayList<>();

		for (Pizza pizza : allPizzas) {
			PizzaDTO pizzaDTO = new PizzaDTO();
			pizzaDTO.setPizzaId(pizza.getPizzaId());
			pizzaDTO.setPizzaName(pizza.getPizzaName());
			pizzaDTO.setPizzaDescription(pizza.getPizzaDescription());
			pizzaDTO.setPizzaSize(pizza.getPizzaSize());
			pizzaDTO.setPizzaCost(pizza.getPizzaCost());

			// You can also set pizzaType, pizzaOrder, and cart as needed.

			pizzaDTOs.add(pizzaDTO);
		}

		return pizzaDTOs;
	}

	@Override
	public List<ToppingsDTO> viewToppings() {
		// Implement the logic to retrieve all toppings and convert them to DTOs.
		List<Toppings> allToppings = toppingsRepository.findAll();
		List<ToppingsDTO> toppingsDTOs = new ArrayList<>();

		for (Toppings toppings : allToppings) {
			ToppingsDTO toppingsDTO = new ToppingsDTO();
			toppingsDTO.setToppingsId(toppings.getToppingsId());
			toppingsDTO.setToppingsName(toppings.getToppingsName());
			toppingsDTO.setPrice(toppings.getPrice());

			toppingsDTOs.add(toppingsDTO);
		}

		return toppingsDTOs;
	}

	@Override
	public List<PizzaTypeDTO> viewAllPizzaTypes() {
		// Implement the logic to retrieve all pizza types and convert them to DTOs.
		List<PizzaType> allPizzaTypes = pizzaTypeRepository.findAll();
		List<PizzaTypeDTO> pizzaTypeDTOs = new ArrayList<>();

		for (PizzaType pizzaType : allPizzaTypes) {
			PizzaTypeDTO pizzaTypeDTO = new PizzaTypeDTO();
			pizzaTypeDTO.setPizzaTypeId(pizzaType.getPizzaTypeId());
			pizzaTypeDTO.setPizzaTypeName(pizzaType.getPizzaTypeName());

			pizzaTypeDTOs.add(pizzaTypeDTO);
		}

		return pizzaTypeDTOs;
	}

}
