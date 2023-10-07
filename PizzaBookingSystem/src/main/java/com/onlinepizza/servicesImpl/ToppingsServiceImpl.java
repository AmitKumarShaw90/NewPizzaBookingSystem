package com.onlinepizza.servicesImpl;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.ToppingsDTO;
import com.onlinepizza.entity.PizzaType;
import com.onlinepizza.entity.Toppings;
import com.onlinepizza.repository.PizzaTypeRepository;
import com.onlinepizza.repository.ToppingsRepository;
import com.onlinepizza.services.ToppingsService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ToppingsServiceImpl implements ToppingsService {
    
	@Autowired
    ToppingsRepository toppingsRepository;
	
	@Autowired
	PizzaTypeRepository pizzaTypeRepository;
    

    @Override
    public List<ToppingsDTO> getAllToppings() {
        List<Toppings> toppingsList = toppingsRepository.findAll();
        return toppingsList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ToppingsDTO getToppingsById(Integer toppingsId) {
        Toppings toppings = toppingsRepository.findById(toppingsId).orElse(null);
        if (toppings != null) {
            return convertToDTO(toppings);
        }
        return null;
    }

    @Override
    public ToppingsDTO addToppings(ToppingsDTO toppingsDTO, Integer pizzaTypeId) {
        // Convert DTO to entity
        Toppings toppings = convertToEntity(toppingsDTO);

     

        // Fetch the PizzaType by its ID
        PizzaType pizzaType = pizzaTypeRepository.findById(pizzaTypeId)
                .orElseThrow(() -> new EntityNotFoundException("PizzaType not found with id: " + pizzaTypeId));

     

        // Set the PizzaType for the toppings
        toppings.setPizzaType(pizzaType);

     

        // Save the toppings entity
        toppings = toppingsRepository.save(toppings);

     

        // Convert the saved entity back to DTO
        return convertToDTO(toppings);
    }
    
    
    @Override
    public ToppingsDTO updateToppings(Integer toppingsId, ToppingsDTO toppingsDTO) {
        Toppings existingToppings = toppingsRepository.findById(toppingsId).orElse(null);
        if (existingToppings != null) {
            BeanUtils.copyProperties(toppingsDTO, existingToppings);
            existingToppings = toppingsRepository.save(existingToppings);
            return convertToDTO(existingToppings);
        }
        return null;
    }

    @Override
    public void deleteToppings(Integer toppingsId) {
        toppingsRepository.deleteById(toppingsId);
    }

    private ToppingsDTO convertToDTO(Toppings toppings) {
        ToppingsDTO toppingsDTO = new ToppingsDTO();
        BeanUtils.copyProperties(toppings, toppingsDTO);
        return toppingsDTO;
    }

    private Toppings convertToEntity(ToppingsDTO toppingsDTO) {
        Toppings toppings = new Toppings();
        BeanUtils.copyProperties(toppingsDTO, toppings);
        return toppings;
    }
}

