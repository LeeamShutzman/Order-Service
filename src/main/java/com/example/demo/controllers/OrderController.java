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

	/***************************************************************/
	//Constructors, Getters, and Setters

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

	/***************************************************************/
	//Service endpoint mapping

	//Add an Order
	@PostMapping("/add") //localhost:portNum/orders/add
	public Order addOrder(@RequestBody Order order) {
		return orderService.addOrder(order);
	}

	//View all Orders
	@GetMapping("/all") //localhost:portNum/orders/all
	public List<Order> getAllOrders(){
		return orderService.findAll();
	}

	//View Order by ID
	@GetMapping("getOrderByID") //localhost:portNum/orders/getOrderByID?orderID=#
	public Optional<Order> getOrderByID(@RequestParam long orderID) {
		return orderService.findByOrderID(orderID);
	}

	//View Orders by Customer
	@GetMapping("getOrdersByCustomerID") //localhost:portNum/orders/getOrdersByCustomerID?customerID=#
	public List<Order> getOrdersByCustomerID(@RequestParam String customerID) {
		return orderService.findOrdersByCustomerID(customerID);
	}

	//Delete an Order
	@DeleteMapping("delete") //localhost:portNum/orders/delete?orderID=#
	public void deleteOrder(@RequestParam long orderID){
		orderService.deleteOrder(orderID);
	}
	
	
}
