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
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.CartDTO;
import com.onlinepizza.entity.Cart;
import com.onlinepizza.services.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	private final CartService cartService;

	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}

	@GetMapping
	public ResponseEntity<List<Cart>> getAllCarts() {
		List<Cart> carts = cartService.getAllCarts();
		return new ResponseEntity<>(carts, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCartById(@PathVariable Integer id) {
		Cart cart = cartService.getCartById(id);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cart> createCart(@RequestBody CartDTO cartDTO) {
		Cart cart = cartService.createCart(cartDTO);
		return new ResponseEntity<>(cart, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable Integer id, @RequestBody CartDTO cartDTO) {
		Cart cart = cartService.updateCart(id, cartDTO);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCart(@PathVariable Integer id) {
		cartService.deleteCart(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
