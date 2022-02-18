package com.generali.burritoorderingservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.generali.burritoorderingservice.model.Orders;

public interface BurritoOrderingRepository extends CrudRepository<Orders, Long>{

}
