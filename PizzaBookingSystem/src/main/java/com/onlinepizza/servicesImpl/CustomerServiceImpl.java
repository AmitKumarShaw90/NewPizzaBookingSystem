package com.onlinepizza.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.CustomerDTO;
import com.onlinepizza.entity.Customer;
import com.onlinepizza.repository.CustomerRepository;
import com.onlinepizza.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		customer.setCustomerName(customerDTO.getCustomerName());
		customer.setCustomerMobile(customerDTO.getCustomerMobile());
		customer.setCustomerEmail(customerDTO.getCustomerEmail());
		customer.setCustomerAddress(customerDTO.getCustomerAddress());

		// You may set other properties of the Customer entity as needed.

		customerRepository.save(customer);

		// Set the generated customer ID in the DTO
		customerDTO.setCustomerID(customer.getUserId());

		return customerDTO;
	}

	@Override
	public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
		Optional<Customer> existingCustomerOptional = customerRepository.findById(customerDTO.getCustomerID());

		if (existingCustomerOptional.isPresent()) {
			Customer existingCustomer = existingCustomerOptional.get();
			existingCustomer.setCustomerName(customerDTO.getCustomerName());
			existingCustomer.setCustomerMobile(customerDTO.getCustomerMobile());
			existingCustomer.setCustomerEmail(customerDTO.getCustomerEmail());
			existingCustomer.setCustomerAddress(customerDTO.getCustomerAddress());

			// You may update other properties of the Customer entity as needed.

			customerRepository.save(existingCustomer);

			return customerDTO;
		} else {
			// Handle the case when the customer with the given ID is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}

	@Override
	public CustomerDTO viewCustomerByPhone(Long phoneNo) {
		Optional<Customer> customerOptional = customerRepository.findByCustomerMobile(phoneNo);

		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerID(customer.getUserId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setCustomerMobile(customer.getCustomerMobile());
			customerDTO.setCustomerEmail(customer.getCustomerEmail());
			customerDTO.setCustomerAddress(customer.getCustomerAddress());

			// You may retrieve other properties of the Customer entity as needed.

			return customerDTO;
		} else {
			// Handle the case when the customer with the given phone number is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}

	@Override
	public List<CustomerDTO> viewAllCustomer() {
		List<Customer> allCustomers = customerRepository.findAll();
		List<CustomerDTO> customerDTOs = new ArrayList<>();

		for (Customer customer : allCustomers) {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerID(customer.getUserId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setCustomerMobile(customer.getCustomerMobile());
			customerDTO.setCustomerEmail(customer.getCustomerEmail());
			customerDTO.setCustomerAddress(customer.getCustomerAddress());

			// You may retrieve other properties of the Customer entity as needed.

			customerDTOs.add(customerDTO);
		}

		return customerDTOs;
	}

	@Override
	public CustomerDTO viewCustomerById(Integer customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);

		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerID(customer.getUserId());
			customerDTO.setCustomerName(customer.getCustomerName());
			customerDTO.setCustomerMobile(customer.getCustomerMobile());
			customerDTO.setCustomerEmail(customer.getCustomerEmail());
			customerDTO.setCustomerAddress(customer.getCustomerAddress());

			// You may retrieve other properties of the Customer entity as needed.

			return customerDTO;
		} else {
			// Handle the case when the customer with the given ID is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}
}
