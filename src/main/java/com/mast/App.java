package com.mast;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	private static final Scanner SCANNER = new Scanner(System.in);
	public static void main(String[] args) {
		final int MAX = 1000;
		Perfume perfumes[] = new Perfume[MAX];
		// Scanner scanner = new Scanner(System.in);

		String option = "";
		while (true) {
			menu();
			option = SCANNER.nextLine();
			switch (option) {
				case "1":
					insert(perfumes);
					break;
				case "2":
					read(perfumes);
					break;
				case "3":
					update(perfumes);
					break;
				case "4":
					delete(perfumes);
					break;
				default:
					SCANNER.close();
					return;
			}
		}
	}
	
	private static void insert(Perfume[] perfumes) {
		System.out.println("Insertar Perfume");

	}

	private static void read(Perfume[] perfumes) {
		System.out.println("Buscar Perfume");
	}

	private static void update(Perfume[] perfumes) {
		System.out.println("Insertar Perfume");
	}

	private static void delete(Perfume[] perfumes) {
		System.out.println("Insertar Perfume");
	}

	private static void menu() {
		String options = """
				1 Insertar Perfume
				2 Buscar Perfume
				3 Modificar Perfume
				4 Eliminar Perfume
				5 Salir
				""";
		System.out.print(options);
	}
}
