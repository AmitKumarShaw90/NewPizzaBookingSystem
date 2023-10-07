package com.onlinepizza.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.onlinepizza.util.PizzaStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pizza_orders")
public class PizzaOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_order_Id")
	private Integer bookingOrderId;

	@Column(name = "date_time_of_order")
	private LocalDateTime dateTimeOfOrder;

	private Integer quantity;

	@Column(name = "total_cost")
	private Double totalCost;

	@OneToMany(mappedBy = "pizzaOrder", cascade = CascadeType.ALL)
	private List<Pizza> pizzaList;

	@ManyToOne
	@JsonBackReference  // to avoid any circular reference
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private PizzaStatus status;
}
