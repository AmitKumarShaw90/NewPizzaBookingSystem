package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.PizzaDTO;
import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.services.PizzaService;

@RestController
@RequestMapping("/pizza")
public class PizzaController {

	@Autowired
	PizzaService pizzaService;

	@PostMapping("/addPizza")
	public ResponseEntity<PizzaDTO> addPizza(@RequestBody PizzaDTO pizzaDTO) {
		PizzaDTO addedPizza = pizzaService.addPizza(pizzaDTO);
		return ResponseEntity.ok(addedPizza);
	}

	@PostMapping("/addToppings")
	public ResponseEntity<ToppingsDTO> addToppings(@RequestBody ToppingsDTO toppingsDTO) {
		ToppingsDTO addedToppings = pizzaService.addToppings(toppingsDTO);
		return ResponseEntity.ok(addedToppings);
	}

	@PostMapping("/addPizzaType")
	public ResponseEntity<PizzaTypeDTO> addPizzaType(@RequestBody PizzaTypeDTO pizzaTypeDTO) {
		PizzaTypeDTO addedPizzaType = pizzaService.addPizzaType(pizzaTypeDTO);
		return ResponseEntity.ok(addedPizzaType);
	}

	@PutMapping("/updatePizza")
	public ResponseEntity<PizzaDTO> updatePizza(@RequestBody PizzaDTO pizzaDTO) {
		PizzaDTO updatedPizza = pizzaService.updatePizza(pizzaDTO);
		if (updatedPizza != null) {
			return ResponseEntity.ok(updatedPizza);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewPizzaById/{pizzaId}")
	public ResponseEntity<PizzaDTO> viewPizzaById(@PathVariable Integer pizzaId) {
		PizzaDTO pizzaDTO = pizzaService.viewPizzaById(pizzaId);
		if (pizzaDTO != null) {
			return ResponseEntity.ok(pizzaDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewPizzaByPizzaType/{pizzaType}")
	public ResponseEntity<List<PizzaDTO>> viewPizzaByPizzaType(@PathVariable String pizzaTypeName) {
		List<PizzaDTO> pizzasByType = pizzaService.viewPizzaByPizzaType(pizzaTypeName);
		return ResponseEntity.ok(pizzasByType);
	}

	@GetMapping("/viewPizzaByPizzaSize/{pizzaSize}")
	public ResponseEntity<List<PizzaDTO>> viewPizzaByPizzaSize(@PathVariable String pizzaSize) {
		List<PizzaDTO> pizzasBySize = pizzaService.viewPizzaByPizzaSize(pizzaSize);
		return ResponseEntity.ok(pizzasBySize);
	}

	@GetMapping("/viewPizzaByPrice")
	public ResponseEntity<List<PizzaDTO>> viewPizzaByPrice(@RequestParam Double minPrice,
			@RequestParam Double maxPrice) {
		List<PizzaDTO> pizzasByPrice = pizzaService.viewPizzaByPrice(minPrice, maxPrice);
		return ResponseEntity.ok(pizzasByPrice);
	}

	@GetMapping("/viewAllPizza")
	public ResponseEntity<List<PizzaDTO>> viewAllPizza() {
		List<PizzaDTO> allPizzas = pizzaService.viewAllPizza();
		return ResponseEntity.ok(allPizzas);
	}

	@GetMapping("/viewToppings")
	public ResponseEntity<List<ToppingsDTO>> viewToppings() {
		List<ToppingsDTO> allToppings = pizzaService.viewToppings();
		return ResponseEntity.ok(allToppings);
	}

	@GetMapping("/viewToppingById/{toppingsID}")
	public ResponseEntity<ToppingsDTO> viewToppingByID(@PathVariable Integer toppingsID) {
		ToppingsDTO toppingsDTO = pizzaService.viewToppingByID(toppingsID);
		if (toppingsDTO != null) {
			return ResponseEntity.ok(toppingsDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewPizzaTypeById/{pizzaTypeId}")
	public ResponseEntity<PizzaTypeDTO> viewPizzaTypeById(@PathVariable Integer pizzaTypeId) {
		PizzaTypeDTO pizzaTypeDTO = pizzaService.viewPizzaTypeById(pizzaTypeId);
		if (pizzaTypeDTO != null) {
			return ResponseEntity.ok(pizzaTypeDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewAllPizzaTypes")
	public ResponseEntity<List<PizzaTypeDTO>> viewAllPizzaTypes() {
		List<PizzaTypeDTO> allPizzaTypes = pizzaService.viewAllPizzaTypes();
		return ResponseEntity.ok(allPizzaTypes);
	}
}
