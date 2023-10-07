package com.onlinepizza.services;


import java.util.List;

import com.onlinepizza.dto.ToppingsDTO;

public interface ToppingsService {
    List<ToppingsDTO> getAllToppings();

    ToppingsDTO getToppingsById(Integer toppingsId);

   // ToppingsDTO addToppings(ToppingsDTO toppingsDTO);

    ToppingsDTO updateToppings(Integer toppingsId, ToppingsDTO toppingsDTO);

    void deleteToppings(Integer toppingsId);

	ToppingsDTO addToppings(ToppingsDTO toppingsDTO, Integer pizzaTypeId);
}

