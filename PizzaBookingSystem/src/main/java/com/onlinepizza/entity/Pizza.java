package com.onlinepizza.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onlinepizza.util.PizzaSize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pizzas")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_id")
	private Integer pizzaId;

	@ManyToOne
	@JsonBackReference // to avoid any circular reference
	@JoinColumn(name = "pizza_type_id")
	private PizzaType pizzaType;

	@Column(name = "pizza_name")
	private String pizzaName;

	@Column(name = "pizza_description")
	private String pizzaDescription;

	@Column(name = "pizza_cost")
	private Double pizzaCost;

	@ManyToOne
	@JsonBackReference // to avoid any circular reference
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@ManyToOne
	@JsonBackReference // to avoid any circular reference
	@JoinColumn(name = "pizza_order_id")
	private PizzaOrder pizzaOrder;

	@Column(name = "pizza_size")
	@Enumerated(EnumType.STRING)
	private PizzaSize pizzaSize;
}
