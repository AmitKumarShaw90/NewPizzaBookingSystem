package com.onlinepizza.services;

import java.util.List;

import com.onlinepizza.dto.CartDTO;
import com.onlinepizza.entity.Cart;

public interface CartService {

	List<Cart> getAllCarts();

	Cart getCartById(Integer id);

	Cart createCart(CartDTO cartDTO);

	Cart updateCart(Integer id, CartDTO cartDTO);

	void deleteCart(Integer id);
}
