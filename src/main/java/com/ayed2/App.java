package com.ayed2;

import java.util.Scanner;

public class App {
	private static final Scanner SCANNER = new Scanner(System.in);
	private static final int MAX = 1000;
	private static Perfume perfumes[] = new Perfume[MAX];
	public static void main(String[] args) {
		// Perfumes para probar
		perfumes[472] = new Perfume("BCD234", "J'adore", "Dior", 290.000, 100);
		perfumes[128] = new Perfume("EFG567", "Light Blue", "Dolce & Gabbana", 210.000, 50);
		perfumes[819] = new Perfume("HIJ890", "Alien", "Thierry Mugler", 260.000, 60);
		perfumes[305] = new Perfume("KLM123", "Santal 33", "Le Labo", 350.000, 50);
		perfumes[674] = new Perfume("NOP456", "Miss Dior", "Dior", 280.000, 75);
		perfumes[241] = new Perfume("QRS789", "Angel", "Thierry Mugler", 240.000, 100);
		perfumes[953] = new Perfume("TUV012", "Si", "Giorgio Armani", 230.000, 30);
		perfumes[387] = new Perfume("WXY345", "Mon Guerlain", "Guerlain", 270.000, 50);
		perfumes[562] = new Perfume("ZAB678", "Olympea", "Paco Rabanne", 250.000, 80);
		perfumes[719] = new Perfume("CDE901", "Chloé", "Chloé", 220.000, 75);
		perfumes[146] = new Perfume("FGH234", "Daisy", "Marc Jacobs", 200.000, 50);
		perfumes[883] = new Perfume("IJK567", "Libre", "Yves Saint Laurent", 300.000, 90);
		perfumes[321] = new Perfume("LMN890", "My Way", "Giorgio Armani", 260.000, 60);
		perfumes[598] = new Perfume("PQR123", "Bloom", "Gucci", 240.000, 100);

		String option = "";
		while (true) {
			menu();
			option = SCANNER.nextLine();
			switch (option) {
				case "1":
					insert(perfumes);
					break;
				case "2":
					readById(perfumes);
					break;
				case "3":
					readByName(perfumes);
					break;
				case "4":
					readByBrand(perfumes);
					break;
				case "5":
					update(perfumes);
					break;
				case "6":
					delete(perfumes);
					break;
				default:
					SCANNER.close();
					return;
			}
		}
	}

	private static void askPerfume(Perfume p) {
		String id, name, brand, aux;
		double price = 0;
		int stock = -1;

		do {
			System.out.println("Inserte el id del perfume");
			id = SCANNER.nextLine();
		} while (!p.validId(id) && searchById(id) == null); // ineficiente
		do {
			System.out.println("Inserte el nombre del perfume");
			name = SCANNER.nextLine();
		} while (!p.validName(name));
		do {
			System.out.println("Inserte la marca del perfume");
			brand = SCANNER.nextLine();
		} while (!p.validBrand(brand));
		do {
			System.out.println("Inserte el precio del perfume");
			aux = SCANNER.nextLine();
			try {
				price = Double.valueOf(aux);
			} catch(Exception e) {
				continue;
			}
		} while (!p.validPrice(price));
		do {
			System.out.println("Inserte el stock del perfume");
			aux = SCANNER.nextLine();
			try {
				stock = Integer.valueOf(aux);
			} catch(Exception e) {
				continue;
			}
		} while (!p.validStock(stock));

		p.setId(id);
		p.setName(name);
		p.setBrand(brand);
		p.setPrice(price);
		p.setStock(stock);
	}

	private static Perfume searchById(String id) {
		for (int i = 0; i < MAX; i++) {
			if (perfumes[i] == null)
				continue;
			if (perfumes[i].getId().equals(id))
				return perfumes[i];
		}
		return null;
	}
	
	private static void insert(Perfume[] perfumes) {
		System.out.println("Insertar Perfume");
		for (int i = 0; i < MAX; i++) {
			if (perfumes[i] == null) {
				perfumes[i] = new Perfume();
				askPerfume(perfumes[i]);
				return;
			}
		}
		System.out.println("Memoria llena");
	}

	private static void readById(Perfume[] perfumes) {
		System.out.println("Ingrese el id a buscar");
		String id = SCANNER.nextLine();
		Perfume p = searchById(id);
		if (p != null)
			System.out.println(p);
	}

	private static void readByName(Perfume[] perfumes) {
		System.out.println("Ingrese el nombre a buscar");
		String name = SCANNER.nextLine();
		for (int i = 0; i < MAX; i++) {
			if (perfumes[i] == null)
				continue;
			if (perfumes[i].getName().equals(name))
				System.out.println(perfumes[i]);
		}
	}

	private static void readByBrand(Perfume[] perfumes) {
		System.out.println("Ingrese la marca a buscar");
		String brand = SCANNER.nextLine();
		for (int i = 0; i < MAX; i++) {
			if (perfumes[i] == null)
				continue;
			if (perfumes[i].getBrand().equals(brand))
				System.out.println(perfumes[i]);
		}
	}

	private static void update(Perfume[] perfumes) {
		System.out.println("Actualizar datos del Perfume");
		System.out.println("Ingrese el id a buscar");
		String id = SCANNER.nextLine();
		Perfume p = searchById(id);
		if (p != null)
			askPerfume(p);
	}

	private static void delete(Perfume[] perfumes) {
		System.out.println("Insertar Perfume");
	}

	private static void menu() {
		String options = """
				1 Insertar Perfume
				2 Buscar Perfume por id
				3 Buscar Perfume por nombre
				4 Buscar Perfume por marca
				5 Modificar Perfume
				6 Eliminar Perfume
				7 Salir
				""";
		System.out.print(options);
	}
}
