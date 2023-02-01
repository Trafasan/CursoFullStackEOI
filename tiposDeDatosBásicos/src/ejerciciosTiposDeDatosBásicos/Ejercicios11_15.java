/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios11_15 {
	public static void ejercicio11() {
		/*
		 * Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit.
		 * La fórmula correspondiente para pasar de grados centígrados a fahrenheit es:
		 * F = 32 + ( 9 * C / 5)
		 */
		Scanner sc = new Scanner (System.in);
		float grados;
		System.out.print("Inserte la temperatura en grados Celsius: ");
		grados = sc.nextFloat();
		sc.nextLine();
		grados = 32+(9*grados/5);
		System.out.println("La temperatura en grados Fahrenheit es "+grados);
		sc.close();
	}

	public static void ejercicio12() {
		/*
		 * Programa que lea un número entero de 3 cifras y muestre por separado las cifras del número.
		 * Nota: Recuerda que la división entre enteros da como resultado la parte entera de la división (sin decimales).
		 * Si por ejemplo N = 123 la operación N/10 da como resultado 12 y no 12.3
		 * Recuerda que el operador % obtiene el resto de la división.
		 */
		Scanner sc = new Scanner (System.in);
		int n;
		do {
			System.out.print("Inserte un número de tres cifras: ");
			n = sc.nextInt();
			sc.nextLine();
		} while(n<100 || n>999);
		int n1 = n/100;
		int n2 = (n-n1*100)/10;
		int n3 = n-n/10*10;
		System.out.println("Primera cifra: "+n1);
		System.out.println("Segunda cifra: "+n2);
		System.out.println("Tercera cifra: "+n3);
		sc.close();
	}

	public static void ejercicio13() {
		/*
		 * Programa que pida por teclado la fecha de nacimiento de una persona (dia, mes, año) y calcule su número de la suerte.
		 * El número de la suerte se calcula sumando el día, mes y año de la fecha de nacimiento y a continuación sumando las cifras obtenidas en la suma.
		 * Por ejemplo: Si la fecha de nacimiento es 12/07/1980 Calculamos el número de la suerte así:
		 * 12+7+1980 = 1999 1+9+9+9 = 28 Número de la suerte: 28
		 */
		Scanner sc = new Scanner (System.in);
		int dd, mm, yyyy;
		System.out.println("Inserte su fecha de nacimiento");
		System.out.print("Día: ");
		dd = sc.nextInt();
		System.out.print("Mes: ");
		mm = sc.nextInt();
		System.out.print("Año: ");
		yyyy = sc.nextInt();
		sc.nextLine();
		int n = dd+mm+yyyy;
		int n1 = n/1000;
		int n2 = (n-n1*1000)/100;
		int n3 = (n-n/100*100)/10;
		int n4 = n-n/10*10;
		int suerte = n1+n2+n3+n4;
		System.out.println("Su número de la suerte es "+suerte);
		sc.close();
	}

	public static void ejercicio14() {
		// Pregunta al usuario su edad e infórmale de cuantos años tendrá dentro de 15.
				Scanner sc = new Scanner (System.in);
				int edad;
				System.out.print("Inserte su edad: ");
				edad = sc.nextInt();
				sc.nextLine();
				edad += 15;
				System.out.println("Dentro de 15 años, tendrá "+edad+" años.");
				sc.close();
	}

	public static void ejercicio15() {
		/*
		 * Pregunta al usuario el nombre de 3 productos con sus respectivos precios. Debes mostrar dichos datos formateados por la consola.
		 * El nombre tendrá 15 caracteres, el precio 12 (con 2 decimales) y finalmente, muestra el precio con IVA (21%), también con 12 caracteres y 2 decimales.
		 * El nombre debe estar alineado a la izquierda (espacios a la derecha) y los precios a la derecha.
		 * Ejemplo de salida:
		 * NOMBRE		PRECIO		CON IVA
		 * Consola 		279,95€		338,74€
		 * Coche azul	24300,00€	29403,00€
		 * Lámpara		45,50€		55,06€
		 */
		Scanner sc = new Scanner (System.in);
		String[] nombre = new String[3];
		double[] precio = new double[3];
		for (int i=0; i<3; i++) {
			System.out.print("Inserte el nombre del producto ("+(i+1)+"/3): ");
			nombre[i] = sc.nextLine();
			// Si se pone solo next(), solo devuelve el string hasta el espacio, por lo que da error
			// Ese error se soluciona poniendo entrada.nextLine();
			System.out.print("Inserte su precio: ");
			precio[i] = Double.parseDouble(sc.next().replace(',', '.'));
			sc.nextLine();
		}
		double[] iva = new double[3];
		for (int i=0; i<3; i++) {
			iva[i] = precio[i]*1.21;
		}
		System.out.printf("%-15s%12s%12s\n", "NOMBRE", "PRECIO", "CON IVA");
		for (int i=0; i<3; i++) {
			System.out.printf("%-15s%11.2f€%11.2f€\n", nombre[i], precio[i], iva[i]);
		}
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio11();
		// ejercicio12();
		// ejercicio13();
		// ejercicio14();
		// ejercicio15();
	}

}
