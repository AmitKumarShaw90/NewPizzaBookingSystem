package com.onlinepizza.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinepizza.entity.PizzaOrder;
import com.onlinepizza.util.PizzaStatus;

@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {

	List<PizzaOrder> findByStatus(PizzaStatus status);

	Optional<PizzaOrder> findById(Integer bookingOrderId);

	List<PizzaOrder> findByDateTimeOfOrderBetween(LocalDateTime atStartOfDay, LocalDateTime atTime);

	/*
	 * List<PizzaOrder> findByCustomer_CustomerIdAndStatus(Integer customerId,
	 * PizzaStatus status);
	 */
}
