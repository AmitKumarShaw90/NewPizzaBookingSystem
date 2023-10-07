package com.onlinepizza.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Cart {

	@Id
	private Integer cartID;

	private Integer quantity;

	private Integer customerID;

	private Integer pizzaId;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<Pizza> pizzas;

}
