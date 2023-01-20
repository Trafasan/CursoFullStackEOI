/**
 * 
 */
package ejerciciosEstructurasDeControl;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios06_10 {
	public static void ejercicio06() {
		// Programa que pida al usuario tres números enteros y muestre el mayor de los tres.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el primer número entero: ");
		int n1 = sc.nextInt();
		System.out.print("Introduzca el segundo número entero: ");
		int n2 = sc.nextInt();
		System.out.print("Introduzca el tercer número entero: ");
		int n3 = sc.nextInt();
		if (n1>n2 && n1>n3)
			System.out.println("El número " + n1 + " es el mayor de los tres.");
		else if (n2>n1 && n2>n3)
			System.out.println("El número " + n2 + " es es el mayor de los tres.");
		else if (n3>n1 && n3>n2)
			System.out.println("El número " + n3 + " es es el mayor de los tres.");
		else
			System.out.println("El número mayor se repite dos o más veces");
		sc.close();
	}

	public static void ejercicio07() {
		/*
		 * Programa que pida al usuario una cantidad de horas, de minutos y de segundos (3 números diferentes).
		 * Comprueba que la hora está en el rango de 0 a 23, los minutos y los segundos de 0 a 59.
		 * Si todo es correcto, muestra al usuario la hora en formato HH:MM:SS (2 cifras para cada parte rellenando con 0 a la
		 * izquierda si es una cifra), y si no, muestra un mensaje de error. Pista: Repasa la parte de formatear la salida de texto para números enteros.
		 */
		Scanner sc = new Scanner(System.in);
		int HH, MM, SS;
		System.out.print("Introduzca las horas: ");
		do {
			HH = sc.nextInt();
			if (HH<0 || HH>23) System.out.print("El formato de horas es incorrecto.\nIntroduzca de nuevo las horas: ");
		}while (HH<0 || HH>23);
		
		System.out.print("Introduzca los minutos: ");
		do {
			MM = sc.nextInt();
			if (MM<0 || MM>59) System.out.print("El formato de minutos es incorrecto.\nIntroduzca de nuevo los minutos: ");
		}while (MM<0 || MM>59);
		
		System.out.print("Introduzca los segundos: ");
		do {
			SS = sc.nextInt();
			if (SS<0 || SS>59) System.out.print("El formato de segundos es incorrecto.\nIntroduzca de nuevo los segundos: ");
		}while (SS<0 || SS>59);
		System.out.printf("%02d:%02d:%02d", HH, MM, SS);
		sc.close();
	}

	public static void ejercicio08() {
		/*
		 * Escribe un programa que declare una variable A de tipo entero y asígnale un  valor.
		 * A continuación muestra un mensaje indicando si A es par o impar. Utiliza el operador ternario ( ? : ) dentro de WriteLine para resolverlo.
		 * Si por ejemplo A = 14 la salida será: 14 es par
		 * Si fuese por ejemplo A = 15 la salida será: 15 es impar
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número entero: ");
		int A = sc.nextInt();
		System.out.println(A%2==0?"El número "+A+" es par.":"El número "+A+" es impar.");
		sc.close();
	}

	public static void ejercicio09() {
		/*
		 * Programa que lea una variable entera llamada mes y compruebe con una estructura switch, si el valor corresponde a un mes de 30 días, de 31 o de
		 * 28. Supondremos que febrero tiene 28 días. Se mostrará además de los días, el nombre del mes. Se mostrará un error cuando el mes no sea válido.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el mes: ");
		int mes = sc.nextInt();
		switch (mes) {
		case 1:
			System.out.println("Enero tiene 31 días.");
			break;
		case 2:
			System.out.println("Febrero tiene 28 días.");
			break;
		case 3:
			System.out.println("Marzo tiene 31 días.");
			break;
		case 4:
			System.out.println("Abril tiene 30 días.");
			break;
		case 5:
			System.out.println("Mayo tiene 31 días.");
			break;
		case 6:
			System.out.println("Junio tiene 30 días.");
			break;
		case 7:
			System.out.println("Julio tiene 31 días.");
			break;
		case 8:
			System.out.println("Agosto tiene 31 días.");
			break;
		case 9:
			System.out.println("Septiembre tiene 30 días.");
			break;
		case 10:
			System.out.println("Octubre tiene 31 días.");
			break;
		case 11:
			System.out.println("Noviembre tiene 30 días.");
			break;
		case 12:
			System.out.println("Diciembre tiene 31 días.");
			break;
		default:
			System.out.println("No existe ese mes.");
		}
		sc.close();
	}

	public static void ejercicio10() {
		/*
		 * Crea un programa que lea una letra tecleada por el usuario y diga si se trata de un signo de puntuación (. , ; :), una cifra numérica (del 0 al 9) u otro
		 * carácter, usando "switch" (pista: necesitarás usar un dato de tipo "char").
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca una letra: ");
		char letra = sc.nextLine().charAt(0);
		switch (letra) {
		case '.',',',';',':':
			System.out.println("El caracter tecleado es el signo de puntuación "+letra);
			break;
		case '1','2','3','4','5','6','7','8','9':
			System.out.println("El caracter tecleado es el número "+letra);
			break;
		default:
			System.out.println("El caracter tecleado no es ningún signo de puntuación ni un número.");
		}
		sc.close();
	}
	public static void ejercicio10b() {
		/*
		 * Crea un programa que lea una letra tecleada por el usuario y diga si se trata de un signo de puntuación (. , ; :), una cifra numérica (del 0 al 9) u otro
		 * carácter, usando "switch" (pista: necesitarás usar un dato de tipo "char").
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca una letra: ");
		char letra = sc.nextLine().charAt(0);
		if (Character.isDigit(letra)) System.out.println("La letra tecleada es el número "+letra);
		else System.out.println("La letra tecleada es el caracter "+letra);
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio06();
		// ejercicio07();
		ejercicio08();
		// ejercicio09();
		// ejercicio10();
		// ejercicio10b();
	}

}
