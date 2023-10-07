package com.onlinepizza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "toppings")
public class Toppings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "toppings_id")
	private Integer toppingsId;

	@Column(name = "toppings_name")
	private String toppingsName;

	private Double price;

	@ManyToOne
	//@JsonBackReference  // to avoid any circular reference
	@JoinColumn(name = "pizza_type_id") 
	 PizzaType pizzaType;
}

