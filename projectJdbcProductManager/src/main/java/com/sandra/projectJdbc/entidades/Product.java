package com.sandra.projectJdbc.entidades;

public class Product {
	private int id;
	private String reference;
	private String name;
	private double price;
	private int category;
	
	public Product() {
		
	}

	public Product(int id, String reference, String name, double price, int category) {
		super();
		this.id = id;
		this.reference = reference;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Producto "+id
				+"\n· Número de referencia: "+reference
				+"\n· Nombre: "+name
				+"\n· Precio: "+String.format("%.2f€", price)
				+"\n· ID de la categoría: "+category;
	}
	
}
