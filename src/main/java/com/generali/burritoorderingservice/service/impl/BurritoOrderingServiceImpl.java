package com.generali.burritoorderingservice.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generali.burritoorderingservice.model.Extras;
import com.generali.burritoorderingservice.model.Orders;
import com.generali.burritoorderingservice.model.Vegetables;
import com.generali.burritoorderingservice.repository.BurritoOrderingRepository;
import com.generali.burritoorderingservice.service.BurritoOrderingService;

@Service
public class BurritoOrderingServiceImpl implements BurritoOrderingService{

	@Autowired
	private BurritoOrderingRepository repository;
	
	public Orders createOrder(Orders order) {
		order = map(order);
		return repository.save(order);
	}

	private Orders map(Orders order) {
		for(Vegetables v: order.getVegetables()) {
			v.setOrder(order);
			order.getVegetables().add(v);
		}
		for(Extras e: order.getExtras()) {
			e.setOrder(order);
			order.getExtras().add(e);
		}
		return order;
	}

	public Orders getOrder(Long orderId) {
		Optional<Orders> orderOptional= repository.findById(orderId);
		if(orderOptional.isPresent())
			return orderOptional.get();
		return new Orders();
	}
}
