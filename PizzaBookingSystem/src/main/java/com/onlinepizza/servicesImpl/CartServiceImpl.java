package com.onlinepizza.servicesImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.CartDTO;
import com.onlinepizza.entity.Cart;
import com.onlinepizza.repository.CartRepository;
import com.onlinepizza.services.CartService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartById(Integer id) {
        return cartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cart with id " + id + " not found"));
    }

    @Override
    public Cart createCart(CartDTO cartDTO) {
        Cart cart = new Cart();
        cart.setCartID(cartDTO.getCartId());
        cart.setQuantity(cartDTO.getQuantity());
        cart.setCustomerID(cartDTO.getCustomerID());
        cart.setPizzaId(cartDTO.getPizzaId());
        return cartRepository.save(cart);
    }

    @Override
    public Cart updateCart(Integer id, CartDTO cartDTO) {
        Cart existingCart = getCartById(id);
        existingCart.setCartID(cartDTO.getCartId());
        existingCart.setQuantity(cartDTO.getQuantity());
        existingCart.setCustomerID(cartDTO.getCustomerID());
        existingCart.setPizzaId(cartDTO.getPizzaId());
        return cartRepository.save(existingCart);
    }

    @Override
    public void deleteCart(Integer id) {
        Cart existingCart = getCartById(id);
        cartRepository.delete(existingCart);
    }
}

