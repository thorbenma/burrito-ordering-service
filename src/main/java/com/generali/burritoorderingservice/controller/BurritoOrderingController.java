package com.generali.burritoorderingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.generali.burritoorderingservice.model.Orders;
import com.generali.burritoorderingservice.service.BurritoOrderingService;

@Controller
public class BurritoOrderingController {
	
	@Autowired
	private BurritoOrderingService service;

	@PostMapping("/orders")
	@ResponseBody
	public Orders createOrder(@RequestBody Orders order) {
		return service.createOrder(order);
	}
	
	@GetMapping("/orders/{orderId}")
	@ResponseBody
	public Orders getOrder(@PathVariable Long orderId) {
		return service.getOrder(orderId);
	}

}
