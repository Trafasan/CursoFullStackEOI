package estructuras;

import java.util.Scanner;

public class Estructuras {
	public static void ejemplo() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduce tu equipo preferido: ");
		String equipo = sc.nextLine();
		
		if (equipo.equalsIgnoreCase("Barcelona")) {
			System.out.println("Visca el Barça");
		} else if (equipo.equalsIgnoreCase("Madrid")) {
			System.out.println("Hala Madrid");
		}
		System.out.println("Bienvenido a nuestro programa de fútbol");
		sc.close();
	}

	public static void main(String[] args) {
		ejemplo();
	}

}