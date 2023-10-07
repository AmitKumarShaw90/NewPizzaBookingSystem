package com.onlinepizza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepizza.entity.Pizza;
import com.onlinepizza.util.PizzaSize;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

	List<Pizza> findByPizzaType_PizzaTypeName(String pizzaTypeName);

	List<Pizza> findByPizzaSize(PizzaSize valueOf);

	List<Pizza> findByPizzaCostBetween(Double minPrice, Double maxPrice);
	

	

}
