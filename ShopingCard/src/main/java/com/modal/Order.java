package com.modal;

public class Order extends Product {

	
	private int orderId;
	private int Userid;
	private int quantity;
	private String date;
	public Order() {
		
	}
	public Order(int orderId, int userid, int quantity, String date) {
		super();
		this.orderId = orderId;
		Userid = userid;
		this.quantity = quantity;
		this.date = date;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getUserid() {
		return Userid;
	}
	public void setUserid(int userid) {
		Userid = userid;
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", Userid=" + Userid + ", quantity=" + quantity + ", date=" + date + "]";
	}
}
