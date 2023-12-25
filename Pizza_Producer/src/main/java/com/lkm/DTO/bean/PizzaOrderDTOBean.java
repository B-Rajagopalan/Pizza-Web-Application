package com.lkm.DTO.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.lkm.validation.ContactNumberAnnotation;

public class PizzaOrderDTOBean 
{
	private int orderId;
	@NotEmpty
	private String pizzaName;
	@NotNull
	@Min(value=1)
	private Integer quantity;
	@NotNull
	private Double bill;
	@NotEmpty
	@ContactNumberAnnotation
	private String customerContactNumber;
	
	public PizzaOrderDTOBean(String pizzaName,Integer quantity,Double bill,
			String customerContactNumber) {
		super();
		this.pizzaName = pizzaName;
		this.quantity = quantity;
		this.bill = bill;
		this.customerContactNumber = customerContactNumber;
	}
	
	public PizzaOrderDTOBean() {}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	public String getCustomerContactNumber() {
		return customerContactNumber;
	}
	public void setCustomerContactNumber(String customerContactNumber) {
		this.customerContactNumber = customerContactNumber;
	}
}
