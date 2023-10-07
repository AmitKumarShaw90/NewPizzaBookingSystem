package com.onlinepizza.servicesImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.entity.PizzaOrder;
import com.onlinepizza.repository.PizzaOrderRepository;
import com.onlinepizza.services.PizzaOrderService;
import com.onlinepizza.util.PizzaStatus;

@Service
public class PizzaOrderServiceImpl implements PizzaOrderService {

	@Autowired
	PizzaOrderRepository pizzaOrderRepository;

	@Override
	public PizzaOrderDTO bookPizzaOrder(PizzaOrderDTO order) {
		PizzaOrder pizzaOrder = new PizzaOrder();
		pizzaOrder.setDateTimeOfOrder(order.getDateTimeOfOrder());
		pizzaOrder.setQuantity(order.getQuantity());
		pizzaOrder.setTotalCost(order.getTotalCost());
		pizzaOrder.setStatus(order.getStatus());

		// Set the customer and pizzaList properties based on order.getCustomer() and
		// order.getPizzaList()

		pizzaOrderRepository.save(pizzaOrder);

		// Set the generated bookingOrderId in the DTO
		order.setBookingOrderId(pizzaOrder.getBookingOrderId());

		return order;
	}

	@Override
	public PizzaOrderDTO updatepizzaOrder(PizzaOrderDTO pizzaOrder) {
		Optional<PizzaOrder> existingPizzaOrderOptional = pizzaOrderRepository.findById(pizzaOrder.getBookingOrderId());

		if (existingPizzaOrderOptional.isPresent()) {
			PizzaOrder existingPizzaOrder = existingPizzaOrderOptional.get();
			existingPizzaOrder.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
			existingPizzaOrder.setQuantity(pizzaOrder.getQuantity());
			existingPizzaOrder.setTotalCost(pizzaOrder.getTotalCost());
			existingPizzaOrder.setStatus(pizzaOrder.getStatus());

			// Update the customer and pizzaList properties based on
			// pizzaOrder.getCustomer() and pizzaOrder.getPizzaList()

			pizzaOrderRepository.save(existingPizzaOrder);

			return pizzaOrder;
		} else {
			// Handle the case when the pizza order with the given ID is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}

	@Override
	public PizzaOrderDTO cancelPizzaOrder(Integer pizzaOrderId) {
		Optional<PizzaOrder> pizzaOrderOptional = pizzaOrderRepository.findById(pizzaOrderId);

		if (pizzaOrderOptional.isPresent()) {
			PizzaOrder pizzaOrder = pizzaOrderOptional.get();

			// Set the status of the pizza order to canceled or a corresponding status

			pizzaOrderRepository.save(pizzaOrder);

			PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
			pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
			pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
			pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
			pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
			pizzaOrderDTO.setStatus(pizzaOrder.getStatus());

			// You may set customer and pizzaList properties if needed.

			return pizzaOrderDTO;
		} else {
			// Handle the case when the pizza order with the given ID is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}

	@Override
	public PizzaOrderDTO viewPizzaOrderById(Integer pizzaOrderId) {
		Optional<PizzaOrder> pizzaOrderOptional = pizzaOrderRepository.findById(pizzaOrderId);

		if (pizzaOrderOptional.isPresent()) {
			PizzaOrder pizzaOrder = pizzaOrderOptional.get();
			PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
			pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
			pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
			pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
			pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
			pizzaOrderDTO.setStatus(pizzaOrder.getStatus());

			// You may set customer and pizzaList properties if needed.

			return pizzaOrderDTO;
		} else {
			// Handle the case when the pizza order with the given ID is not found.
			// You can throw an exception or return an appropriate response.
			return null;
		}
	}

	@Override
	public List<PizzaOrderDTO> viewAllPizzaOrders() {
		List<PizzaOrder> allPizzaOrders = pizzaOrderRepository.findAll();
		List<PizzaOrderDTO> pizzaOrderDTOs = new ArrayList<>();

		for (PizzaOrder pizzaOrder : allPizzaOrders) {
			PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
			pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
			pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
			pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
			pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
			pizzaOrderDTO.setStatus(pizzaOrder.getStatus());

			// You may set customer and pizzaList properties if needed.

			pizzaOrderDTOs.add(pizzaOrderDTO);
		}

		return pizzaOrderDTOs;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByStartAndEndDate(LocalDate startDate, LocalDate endDate) {
		// Implement the logic to retrieve pizza orders within the specified date range
		// and convert them to DTOs.
		List<PizzaOrder> pizzaOrdersInRange = pizzaOrderRepository
				.findByDateTimeOfOrderBetween(startDate.atStartOfDay(), endDate.atTime(LocalTime.MAX));
		List<PizzaOrderDTO> pizzaOrderDTOs = new ArrayList<>();

		for (PizzaOrder pizzaOrder : pizzaOrdersInRange) {
			PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
			pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
			pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
			pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
			pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
			pizzaOrderDTO.setStatus(pizzaOrder.getStatus());

			// You may set customer and pizzaList properties if needed.

			pizzaOrderDTOs.add(pizzaOrderDTO);
		}

		return pizzaOrderDTOs;
	}

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByDate(LocalDate date) {
		// Implement the logic to retrieve pizza orders on a specific date and convert
		// them to DTOs.
		List<PizzaOrder> pizzaOrdersOnDate = pizzaOrderRepository.findByDateTimeOfOrderBetween(date.atStartOfDay(),
				date.atTime(LocalTime.MAX));
		List<PizzaOrderDTO> pizzaOrderDTOs = new ArrayList<>();

		for (PizzaOrder pizzaOrder : pizzaOrdersOnDate) {
			PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
			pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
			pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
			pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
			pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
			pizzaOrderDTO.setStatus(pizzaOrder.getStatus());

			// You may set customer and pizzaList properties if needed.

			pizzaOrderDTOs.add(pizzaOrderDTO);
		}

		return pizzaOrderDTOs;
	}

	/*
	 * @Override public List<PizzaOrderDTO> viewPizzaOrderByCustomerId(Integer
	 * customerId) { // Implement the logic to retrieve pizza orders by customer ID
	 * and convert them // to DTOs. List<PizzaOrder> pizzaOrdersByCustomerId =
	 * pizzaOrderRepository.findByCustomer_CustomerId(customerId);
	 * List<PizzaOrderDTO> pizzaOrderDTOs = new ArrayList<>();
	 * 
	 * for (PizzaOrder pizzaOrder : pizzaOrdersByCustomerId) { PizzaOrderDTO
	 * pizzaOrderDTO = new PizzaOrderDTO();
	 * pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
	 * pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
	 * pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
	 * pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
	 * pizzaOrderDTO.setStatus(pizzaOrder.getStatus());
	 * 
	 * // You may set customer and pizzaList properties if needed.
	 * 
	 * pizzaOrderDTOs.add(pizzaOrderDTO); }
	 * 
	 * return pizzaOrderDTOs; }
	 */

	@Override
	public List<PizzaOrderDTO> viewPizzaOrderByStatus(String status) {
		// Implement the logic to retrieve pizza orders by status and convert them to
		// DTOs.
		List<PizzaOrder> pizzaOrdersByStatus = pizzaOrderRepository.findByStatus(PizzaStatus.valueOf(status));
		List<PizzaOrderDTO> pizzaOrderDTOs = new ArrayList<>();

		for (PizzaOrder pizzaOrder : pizzaOrdersByStatus) {
			PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
			pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
			pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
			pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
			pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
			pizzaOrderDTO.setStatus(pizzaOrder.getStatus());

			// You may set customer and pizzaList properties if needed.

			pizzaOrderDTOs.add(pizzaOrderDTO);
		}

		return pizzaOrderDTOs;
	}

	/*
	 * @Override public List<PizzaOrderDTO>
	 * viewPizzaOrderByCustomerIdAndStatus(Integer customerId, String status) { //
	 * Implement the logic to retrieve pizza orders by customer ID and status, and
	 * // convert them to DTOs. List<PizzaOrder> pizzaOrdersByCustomerIdAndStatus =
	 * pizzaOrderRepository .findByCustomer_CustomerIdAndStatus(customerId,
	 * PizzaStatus.valueOf(status)); List<PizzaOrderDTO> pizzaOrderDTOs = new
	 * ArrayList<>();
	 * 
	 * for (PizzaOrder pizzaOrder : pizzaOrdersByCustomerIdAndStatus) {
	 * PizzaOrderDTO pizzaOrderDTO = new PizzaOrderDTO();
	 * pizzaOrderDTO.setBookingOrderId(pizzaOrder.getBookingOrderId());
	 * pizzaOrderDTO.setDateTimeOfOrder(pizzaOrder.getDateTimeOfOrder());
	 * pizzaOrderDTO.setQuantity(pizzaOrder.getQuantity());
	 * pizzaOrderDTO.setTotalCost(pizzaOrder.getTotalCost());
	 * pizzaOrderDTO.setStatus(pizzaOrder.getStatus());
	 * 
	 * // You may set customer and pizzaList properties if needed.
	 * 
	 * pizzaOrderDTOs.add(pizzaOrderDTO); }
	 * 
	 * return pizzaOrderDTOs; }
	 */

}
