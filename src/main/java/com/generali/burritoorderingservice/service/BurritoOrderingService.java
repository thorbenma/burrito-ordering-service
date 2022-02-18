package com.generali.burritoorderingservice.service;

import com.generali.burritoorderingservice.model.Orders;

public interface BurritoOrderingService {

	Orders createOrder(Orders order);

	Orders getOrder(Long orderId);

}
