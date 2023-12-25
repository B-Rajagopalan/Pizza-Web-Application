package com.lkm.circuit.breaker;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import com.lkm.dto.bean.PizzaOrderDTOBean;
import com.lkm.feign.client.MyFeignClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
@Component
public class Resilience4jController 
{
	private static final String RESILIENCE4J_INSTANCE_NAME = "myCircuitBreaker";
	
	@Autowired
	private MyFeignClient myFeignClient;
	
	@CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = "customFallBack")
	public ResponseEntity<String> addPizza(PizzaOrderDTOBean pizzaBean)
	{
		return myFeignClient.addPizza(pizzaBean);
	}
	
	@CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = "customFallBack")
	public ResponseEntity<List<PizzaOrderDTOBean>> getPizzaDetails()
	{
		return myFeignClient.getPizzaDetails();
		
	}
	
	@CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = "customFallBack")
	public ResponseEntity<List<PizzaOrderDTOBean>> getallDetailsByPizzaName(String pizzaName)
	{
		return myFeignClient.getallDetailsByPizzaName(pizzaName);
		
	}
	
	@CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = "customFallBack")
	public ResponseEntity<List<PizzaOrderDTOBean>> getOrderDetailsByContactNumber(String contactNumber)
	{
		return myFeignClient.getOrderDetailsByContactNumber(contactNumber);
		
	}
	
	public ResponseEntity<String> customFallBack(Exception e)
	{
		return new ResponseEntity<String>("Unexpected Error",HttpStatus.OK);
		
	}

}
