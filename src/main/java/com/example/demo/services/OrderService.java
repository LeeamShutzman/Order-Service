package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Order;
import com.example.demo.models.Product;
import com.example.demo.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	public OrderRepository getOrderRepository() {
		return orderRepository;
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	public List<Order> findAll(){
		return orderRepository.findAll();
	}
	
	public Order add(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> findByCustomerID(String customerID){
		return orderRepository.findByCustomerID(customerID);
	}

	public void deleteById(long orderId){
		orderRepository.deleteById(orderId);
	}
	
	public Optional<Order> findByID(long orderId) {
		return orderRepository.findById(orderId);
	}
	
}

