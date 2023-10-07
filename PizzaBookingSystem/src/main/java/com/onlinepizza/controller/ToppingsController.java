package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.services.PizzaTypeService;
import com.onlinepizza.services.ToppingsService;

@RestController
@RequestMapping("/toppings")
public class ToppingsController {

	@Autowired
	ToppingsService toppingsService;

	@Autowired
	PizzaTypeService pizzaTypeService;

	public ToppingsController(ToppingsService toppingsService) {
		this.toppingsService = toppingsService;
	}

	@GetMapping
	public ResponseEntity<List<ToppingsDTO>> getAllToppings() {
		List<ToppingsDTO> toppingsList = toppingsService.getAllToppings();
		return new ResponseEntity<>(toppingsList, HttpStatus.OK);
	}

	@GetMapping("/{toppingsId}")
	public ResponseEntity<ToppingsDTO> getToppingsById(@PathVariable Integer toppingsId) {
		ToppingsDTO toppingsDTO = toppingsService.getToppingsById(toppingsId);
		if (toppingsDTO != null) {
			return new ResponseEntity<>(toppingsDTO, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/addToppings")
	public ResponseEntity<ToppingsDTO> addToppings(@RequestBody ToppingsDTO toppingsDTO,
			@RequestParam Integer pizzaTypeId) {
		ToppingsDTO addedToppings = toppingsService.addToppings(toppingsDTO, pizzaTypeId);
		return new ResponseEntity<>(addedToppings, HttpStatus.CREATED);
	}

	@PutMapping("/{toppingsId}")
	public ResponseEntity<ToppingsDTO> updateToppings(@PathVariable Integer toppingsId,
			@RequestBody ToppingsDTO toppingsDTO) {
		ToppingsDTO updatedToppings = toppingsService.updateToppings(toppingsId, toppingsDTO);
		if (updatedToppings != null) {
			return new ResponseEntity<>(updatedToppings, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{toppingsId}")
	public ResponseEntity<Void> deleteToppings(@PathVariable Integer toppingsId) {
		toppingsService.deleteToppings(toppingsId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
