package com.ayed2;

/**
 * Perfume
 */
public class Perfume {
	private String id; // Máximo 10 caracteres alfanuméricos
	private static final short MIN_ID = 0;
	private static final short MAX_ID = 10;
	private String name; // Entre 3 y 50 caracteres
	private static final short MIN_NAME = 3;
	private static final short MAX_NAME = 50;
	private String brand; // Entre 2 y 30 caracteres
	private static final short MIN_BRAND = 2;
	private static final short MAX_BRAND = 30;
	private double price; // Positivo mayor a 0
	private int stock; // Valor no negativo

	public Perfume() {

	}

	public Perfume(String id, String name, String brand, double price, int stock) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.stock = stock;
	}

	private boolean validLength(short min, short max, String toValidate) {
		int l = toValidate.length();
		if (l < min || l > max)
			return false;
		return true;
	}

	private boolean validLetterOrDigit(String toValidate) {
		for (char c: toValidate.toCharArray()) {
			if (!Character.isLetterOrDigit(c))
				return false;
		}
		return true;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (validId(id))
			this.id = id;
	}

	public boolean validId(String id) {
		return validLength(MIN_ID, MAX_ID, id) && validLetterOrDigit(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (validName(name))
			this.name = name;
	}

	public boolean validName(String name) {
		return validLength(MIN_NAME, MAX_NAME, name) && validLetterOrDigit(name);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		if (validBrand(brand))
			this.brand = brand;
	}

	public boolean validBrand(String brand) {
		return validLength(MIN_BRAND, MAX_BRAND, brand) && validLetterOrDigit(brand);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (validPrice(price))
			this.price = price;
	}

	public boolean validPrice(double price) {
		if (price <= 0)
			return false;
		return true;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		if (validStock(stock))
			this.stock = stock;
	}

	public boolean validStock(int stock) {
		if (stock < 0)
			return false;
		return true;
	}

	@Override
	public String toString() {
		String p = "ID: " + this.id + "\n" +
			"NOMBRE: " + this.name + "\n" +
			"MARCA: " + this.brand + "\n" +
			"PRECIO: $" + this.price + "\n" +
			"STOCK: " + this.stock + "\n";
		return p;
	}}
