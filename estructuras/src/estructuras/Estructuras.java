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
	
	public static void menuDoWhile() {
		Scanner sc = new Scanner (System.in);
		int opcion = -1;
		do {
			System.out.println("1. Primera opción");
			System.out.println("2. Segunda opción");
			System.out.println("3. Tercera opción");
			System.out.println("4. Cuarta opción");
			System.out.println("0. Salir");
			System.out.print("Seleccione una opción: ");
			opcion=sc.nextInt();
			sc.nextLine();
			switch (opcion) {
			case 1 -> System.out.println("Has elegido la primera opción.\n");
			case 2 -> System.out.println("Has elegido la segunda opción.\n");
			case 3 -> System.out.println("Has elegido la tercera opción.\n");
			case 4 -> System.out.println("Has elegido la cuarta opción.\n");
			case 0 -> System.out.println("Hasta pronto");
			default -> System.out.println("La opción seleccionada no es correcta.\n");
			}
		}while(opcion!=0);
		sc.close();
	}
	
	public static void offTopicBloqueTexto() {
		String texto = "Primera línea\n"+
				"Segunda línea\n"+
				"\t\tTercera línea";
		System.out.println(texto);
		
		String texto2 = """
				Primera línea
				Segunda línea \
				en dos partes
				""";
		System.out.println(texto2);
	}
	
	public static void numeroPrimoConBreak() {
		Scanner sc = new Scanner (System.in);
		boolean esPrimo = true;
		System.out.print("Inserte un número: ");
		int N = sc.nextInt();
		for (int x=2; x<(N/2); x++) {
			if(N%x == 0) {
				esPrimo = false;
				break; // Este break rompe el bucle for para que no se repita más
			}
		}
		System.out.println(esPrimo ? "El número "+N+" es un número primo." : "El número "+N+" no es un número primo.");
		sc.close();
	}
	
	public static void ejemploBreak() {
		Scanner sc = new Scanner (System.in);
		for (int i=0; i<5; i++) {
			System.out.print("Introduzca la contraseña: ");
			String password = sc.nextLine();
			if (password.contains("kk")) break;
			System.out.println("Gracias por introducir su contraseña");
		}
		sc.close();
	}
	
	public static void ejemploContinue() {
		Scanner sc = new Scanner (System.in);
		for (int i=0; i<5; i++) {
			System.out.print("Introduzca la contraseña: ");
			String password = sc.nextLine();
			if (password.contains("kk")) continue; // Este continue pasa a la siguiente iteración del bucle
			System.out.println("Gracias por introducir su contraseña");
		}
		sc.close();
	}

	public static void main(String[] args) {
		// ejemploIfElse();
		// ejemploDoWhile();
		// ejemploFechas();
		// menuDoWhile();
		// offTopicBloqueTexto();
		// numeroPrimoConBreak();
		// ejemploBreak();
		// ejemploContinue();
	}

}