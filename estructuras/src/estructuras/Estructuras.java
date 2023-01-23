package estructuras;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class Estructuras {
	public static void ejemploIfElse() {
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
	
	public static void ejemploDoWhile() {
		Scanner sc = new Scanner (System.in);
		String password = "1234";
		int intentos = 0;
		boolean adivina = false;
		do {		
			System.out.print("Introduzca la contraseña (Tienes " + (3-intentos) + " intento" + (intentos!=2?"s":"") +"):");
			String respuesta = sc.nextLine();			
			if(respuesta.equals(password))  adivina = true;
			else System.out.println("Fallaste");
			intentos++;
		} while(!adivina && intentos<3); // !adivina es lo mismo que adivina==false	
		System.out.println(adivina?"Acertaste":"Gastaste todas tus intentos");
		sc.close();
	}
	
	public static void ejemploFechas() {
		LocalDate fecha = LocalDate.now();
		while (fecha.isBefore(LocalDate.parse("2023-03-31"))) {
			if (fecha.getDayOfWeek()!=DayOfWeek.SATURDAY && fecha.getDayOfWeek()!=DayOfWeek.SUNDAY) System.out.println(fecha);
			fecha = fecha.plusDays(1);
		}
		System.out.println("Has acabado el curso");
	}

	public static void main(String[] args) {
		// ejemploIfElse();
		// ejemploDoWhile();
		// ejemploFechas();
	}

}