package com.modal;

public class Product {

	private int id;
	private String name;
	private String category;
	private Double pricec;
	private String image;
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", pricec=" + pricec + ", image="
				+ image + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Double getPricec() {
		return pricec;
	}
	public void setPricec(Double pricec) {
		this.pricec=pricec;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String name, String category,  Double pricec, String image) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.pricec = pricec;
		this.image = image;
	}
}
