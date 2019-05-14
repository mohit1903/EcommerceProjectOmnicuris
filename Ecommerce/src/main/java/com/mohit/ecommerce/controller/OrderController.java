package com.mohit.ecommerce.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.ecommerce.entity.Orders;
import com.mohit.ecommerce.repository.OrderRepository;
import com.mohit.ecommerce.service.OrderService;

@RestController
@RequestMapping(path = "/order")
@Transactional
public class OrderController extends OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping
	public Iterable<Orders> findAll() {
		return orderRepository.findAll();
	}

	@PostMapping(consumes = "application/json")
	public String singleOrder(@RequestBody Orders orders) {

		if (OneOrder(orders))
			return "Order Placed Successfully";
		else
			return "Sorry , Item Not Availaible";
	}

	@PostMapping(consumes = "application/json", path = "/bulk")
	public List<String> bulkOrder(@RequestBody List<Orders> orders) {

		return BulkOrders(orders);
	}

}
