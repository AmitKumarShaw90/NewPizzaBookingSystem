package com.onlinepizza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pizza_types")
public class PizzaType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pizza_type_id")
	private Integer pizzaTypeId;
	
	@Column(name = "pizza_type")
	private String pizzaTypeName;
	
	
}
