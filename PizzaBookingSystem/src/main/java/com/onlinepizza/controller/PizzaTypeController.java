package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.PizzaTypeDTO;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.services.PizzaTypeService;

@RestController
@RequestMapping("/PizzaType")
public class PizzaTypeController {

	@Autowired
	PizzaTypeService pizzaTypeService;

	@GetMapping
	public ResponseEntity<List<PizzaType>> getAllPizzaTypes() {
		List<PizzaType> pizzaTypes = pizzaTypeService.getAllPizzaTypes();
		return new ResponseEntity<>(pizzaTypes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PizzaType> getPizzaTypeById(@PathVariable Integer id) {
		PizzaType pizzaType = pizzaTypeService.getPizzaTypeById(id);
		return new ResponseEntity<>(pizzaType, HttpStatus.OK);
	}

	@PostMapping("/addPizzaType")
	public ResponseEntity<PizzaType> createPizzaType(@RequestBody PizzaTypeDTO pizzaTypeDTO) {
		PizzaType pizzaType = pizzaTypeService.createPizzaType(pizzaTypeDTO);
		return new ResponseEntity<>(pizzaType, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<PizzaType> updatePizzaType(@PathVariable Integer id, @RequestBody PizzaTypeDTO pizzaTypeDTO) {
		PizzaType pizzaType = pizzaTypeService.updatePizzaType(id, pizzaTypeDTO);
		return new ResponseEntity<>(pizzaType, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletePizzaType(@PathVariable Integer id) {
		pizzaTypeService.deletePizzaType(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
