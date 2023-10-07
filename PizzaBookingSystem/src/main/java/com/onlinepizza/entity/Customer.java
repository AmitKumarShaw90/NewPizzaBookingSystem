package com.onlinepizza.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Customer extends User {
	
	
	
	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_mobile")
	private Long customerMobile;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "customer_address")
	private String customerAddress;

}
