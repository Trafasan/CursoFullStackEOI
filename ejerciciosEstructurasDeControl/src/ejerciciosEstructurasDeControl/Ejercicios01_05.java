/**
 * 
 */
package ejerciciosEstructurasDeControl;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios01_05 {
	public static void ejercicio01() {
		// Programa que lea un número entero por teclado y calcule si es par o impar. Un número es par si el resto (%) de dividir entre 2 da 0.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número entero: ");
		int n = sc.nextInt();
		if (n % 2 == 0)
			System.out.println("El número " + n + " es par.");
		else
			System.out.println("El número " + n + " es impar.");
		sc.close();
	}

	public static void ejercicio02() {
		// Programa que lea un número entero y muestre si el número es múltiplo de 10 (si el resto de la división entre 10 da 0).
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número entero: ");
		int n = sc.nextInt();
		if (n % 10 == 0)
			System.out.println("El número " + n + " es múltiplo de 10.");
		else
			System.out.println("El número " + n + " no es múltiplo de 10.");
		sc.close();
	}

	public static void ejercicio03() {
		/*
		 * Programa que lea un carácter por teclado y compruebe si es una letra mayúscula. Una letra mayúscula es aquella que está entre la ‘A’ y la ‘Z’.
		 * Recuerda que se pueden comparar los caracteres como si fueran números. Utiliza cadena.charAt(0) para acceder al primer carácter recibido.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca una letra: ");
		String cadena = sc.nextLine();
		char letra = cadena.charAt(0);
		boolean esMayus = Character.isUpperCase(letra);
		if (esMayus)
			System.out.println("La letra " + letra + " es mayúscula.");
		else
			System.out.println("La letra " + letra + " es minúscula.");
		sc.close();
	}

	public static void ejercicio04() {
		// Programa que le pida 2 cadenas de texto al usuario y compruebe si son iguales.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la primera cadena: ");
		String c1 = sc.nextLine();
		System.out.print("Introduzca la segunda cadena: ");
		String c2 = sc.nextLine();
		if (c1.equals(c2))
			System.out.println("Las dos cadenas son iguales.");
		else
			System.out.println("Las dos cadenas no son iguales.");
		sc.close();
	}

	public static void ejercicio05() {
		/*
		 * Programa que lea dos números por teclado y muestre el resultado de la división del primer número por el segundo.
		 * Se debe comprobar que el divisor no puede ser cero.
		 */
		Scanner sc = new Scanner(System.in);
		double n1, n2;
		System.out.print("Introduzca el primer número: ");
		n1 = Double.parseDouble(sc.nextLine().replace(',', '.'));
		System.out.print("Introduzca el segundo número: ");
		do {
			n2 = Double.parseDouble(sc.nextLine().replace(',', '.'));
			if (n2 == 0) System.out.print("El divisor no puede ser 0.\nIntroduzca de nuevo el segundo número: ");
		}while (n2 == 0);
		
		System.out.println(n1+"/"+n2+" = "+(n1/n2));
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio01();
		// ejercicio02();
		// ejercicio03();
		// ejercicio04();
		// ejercicio05();
	}

}
