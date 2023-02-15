package com.modal;

import java.io.Serializable;

public class Cart extends Product {
	
	private int quantity;
	
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int id, String name, String category, Double pricec, String image) {
		super(id, name, category, pricec, image);
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
