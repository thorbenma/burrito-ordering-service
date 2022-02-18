package com.generali.burritoorderingservice;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.generali.burritoorderingservice.model.Extras;
import com.generali.burritoorderingservice.model.Orders;
import com.generali.burritoorderingservice.model.Vegetables;
import com.generali.burritoorderingservice.service.BurritoOrderingService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BurritoOrderingServiceApplication.class)
public class BurritoOrderingServiceApplicationTests {
	@Autowired
	private BurritoOrderingService service;
	
	@Before
	public void before(){
		Orders order = new Orders();
		order.setTortilla("corn");
		order.setProtein("bean");
		
		Vegetables v = new Vegetables();
		v.setName("cabbage");
		v.setOrder(order);
		Vegetables v1 = new Vegetables();
		v1.setName("corn");
		v1.setOrder(order);
		Set<Vegetables> set= new HashSet<Vegetables>();
		set.add(v); set.add(v1);
		order.setVegetables(set);
		
		Extras e= new Extras();
		e.setName("avocado");
		e.setOrder(order);
		Set<Extras> setE= new HashSet<Extras>();
		setE.add(e);
		order.setExtras(setE);
		
		order.setSalsa("mild");
		this.service.createOrder(order);
	}
	
	@Test
	public void getOrderById() {
		Orders order = service.getOrder(new Long(1));
		assertTrue(order.getId()>0);
	}
	@Test
	public void getOrderCompareSize() {
		Orders order = service.getOrder(new Long(1));
		assertTrue(order.getVegetables().size()==2);
		assertTrue(order.getExtras().size()==1);
	}
	@Test
	public void getOrderCompareVegetables() {
		Orders order = service.getOrder(new Long(1));
		List<String> vegetables = new ArrayList<String>();
		vegetables.add("cabbage"); vegetables.add("corn");
		for(Vegetables v: order.getVegetables()) {
			assertTrue(vegetables.contains(v.getName()));
		}
	}
	@Test
	public void getOrderCompareExtras() {
		Orders order = service.getOrder(new Long(1));
		List<String> extras = new ArrayList<String>();
		extras.add("avocado");
		for(Extras e: order.getExtras()) {
			assertTrue(extras.contains(e.getName()));
		}
	}
}
