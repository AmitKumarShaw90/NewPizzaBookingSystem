package com.onlinepizza.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/register")
	public ResponseEntity<CustomerDTO> registerCustomer(@RequestBody CustomerDTO customerDTO) {
		CustomerDTO registeredCustomer = customerService.registerCustomer(customerDTO);
		return ResponseEntity.ok(registeredCustomer);
	}

	@PutMapping("/update")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO) {
		CustomerDTO updatedCustomer = customerService.updateCustomer(customerDTO);
		if (updatedCustomer != null) {
			return ResponseEntity.ok(updatedCustomer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewByPhone/{phoneNo}")
	public ResponseEntity<CustomerDTO> viewCustomerByPhone(@PathVariable Long phoneNo) {
		CustomerDTO customerDTO = customerService.viewCustomerByPhone(phoneNo);
		if (customerDTO != null) {
			return ResponseEntity.ok(customerDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<CustomerDTO>> viewAllCustomer() {
		List<CustomerDTO> allCustomers = customerService.viewAllCustomer();
		return ResponseEntity.ok(allCustomers);
	}

	@GetMapping("/viewById/{customerId}")
	public ResponseEntity<CustomerDTO> viewCustomerById(@PathVariable Integer customerId) {
		CustomerDTO customerDTO = customerService.viewCustomerById(customerId);
		if (customerDTO != null) {
			return ResponseEntity.ok(customerDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
