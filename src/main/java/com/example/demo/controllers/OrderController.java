package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Category;
import com.example.demo.models.Order;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.services.OrderService;

@RestController
@RequestMapping("orders") //localhost:portNum/categories
public class OrderController {
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping("/all") //localhost:portNum/categories/all
	public List<Order> getAllOrders(){
		return orderService.findAll();
	}
	
	
	@GetMapping()
	public List<Order> getOrdersByCustomer(@RequestParam String customerID) {
		return orderService.findByCustomerID(customerID);
	}
	
	
	@GetMapping("OrderID{id}")
	public Optional<Order> getOrderByID(@PathVariable("id") long OrderID) {
		return orderService.findByID(OrderID);
		
	}

	
	@PostMapping("/add") //localhost:portNum/categories/add
	public Order addOrder(@RequestBody Order order) {
		return orderService.add(order);
	}
	

	@DeleteMapping("/deleteProduct{id}") //localhost:portNum/orders/deleteProduct
	public void deleteById(@PathVariable("id") long orderID){
		orderService.deleteById(orderID);
	}
	
	
}
