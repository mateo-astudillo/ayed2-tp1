package com.mast;

/**
 * Perfume
 */
public class Perfume {
	private String id; // Máximo 10 caracteres alfanuméricos
	private final short MIN_ID = 0;
	private final short MAX_ID = 10;
	private String name; // Entre 3 y 50 caracteres
	private String brand; // Entre 2 y 30 caracteres
	private double price; // Positivo mayor a 0
	private int stock; // Valor no negativo

	public Perfume() {

	}

	private boolean validLength(short min, short max, String toValidate) {
		int l = toValidate.length();
		if (l < min || l > max)
			return false;
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
		for (char c: id.toCharArray()) {
			if (!Character.isLetterOrDigit(c))
				return false;
		}
		return validLength(MIN_ID, MAX_ID, id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
}
