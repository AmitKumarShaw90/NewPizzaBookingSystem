package com.onlinepizza.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlinepizza.dto.PizzaOrderDTO;
import com.onlinepizza.services.PizzaOrderService;

@RestController
@RequestMapping("/pizza-order")
public class PizzaOrderController {

	@Autowired
	PizzaOrderService pizzaOrderService;

	@PostMapping("/book")
	public ResponseEntity<PizzaOrderDTO> bookPizzaOrder(@RequestBody PizzaOrderDTO orderDTO) {
		PizzaOrderDTO bookedOrder = pizzaOrderService.bookPizzaOrder(orderDTO);
		return ResponseEntity.ok(bookedOrder);
	}

	@PutMapping("/update")
	public ResponseEntity<PizzaOrderDTO> updatePizzaOrder(@RequestBody PizzaOrderDTO orderDTO) {
		PizzaOrderDTO updatedOrder = pizzaOrderService.updatepizzaOrder(orderDTO);
		if (updatedOrder != null) {
			return ResponseEntity.ok(updatedOrder);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/cancel/{pizzaOrderId}")
	public ResponseEntity<PizzaOrderDTO> cancelPizzaOrder(@PathVariable Integer pizzaOrderId) {
		PizzaOrderDTO canceledOrder = pizzaOrderService.cancelPizzaOrder(pizzaOrderId);
		if (canceledOrder != null) {
			return ResponseEntity.ok(canceledOrder);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewById/{pizzaOrderId}")
	public ResponseEntity<PizzaOrderDTO> viewPizzaOrderById(@PathVariable Integer pizzaOrderId) {
		PizzaOrderDTO orderDTO = pizzaOrderService.viewPizzaOrderById(pizzaOrderId);
		if (orderDTO != null) {
			return ResponseEntity.ok(orderDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<PizzaOrderDTO>> viewAllPizzaOrders() {
		List<PizzaOrderDTO> allOrders = pizzaOrderService.viewAllPizzaOrders();
		return ResponseEntity.ok(allOrders);
	}

	@GetMapping("/viewByStartAndEndDate")
	public ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByStartAndEndDate(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
		List<PizzaOrderDTO> ordersInRange = pizzaOrderService.viewPizzaOrderByStartAndEndDate(startDate, endDate);
		return ResponseEntity.ok(ordersInRange);
	}

	@GetMapping("/viewByDate")
	public ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByDate(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
		List<PizzaOrderDTO> ordersOnDate = pizzaOrderService.viewPizzaOrderByDate(date);
		return ResponseEntity.ok(ordersOnDate);
	}

	/*
	 * @GetMapping("/viewByCustomerId/{customerId}") public
	 * ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByCustomerId(@PathVariable
	 * Integer customerId) { List<PizzaOrderDTO> ordersByCustomerId =
	 * pizzaOrderService.viewPizzaOrderByCustomerId(customerId); return
	 * ResponseEntity.ok(ordersByCustomerId); }
	 */

	@GetMapping("/viewByStatus/{status}")
	public ResponseEntity<List<PizzaOrderDTO>> viewPizzaOrderByStatus(@PathVariable String status) {
		List<PizzaOrderDTO> ordersByStatus = pizzaOrderService.viewPizzaOrderByStatus(status);
		return ResponseEntity.ok(ordersByStatus);
	}

	/*
	 * @GetMapping("/viewByCustomerIdAndStatus") public
	 * ResponseEntity<List<PizzaOrderDTO>>
	 * viewPizzaOrderByCustomerIdAndStatus(@RequestParam Integer customerId,
	 * 
	 * @RequestParam String status) { List<PizzaOrderDTO>
	 * ordersByCustomerIdAndStatus = pizzaOrderService
	 * .viewPizzaOrderByCustomerIdAndStatus(customerId, status); return
	 * ResponseEntity.ok(ordersByCustomerIdAndStatus); }
	 */
}
