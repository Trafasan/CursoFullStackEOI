/**
 * 
 */
package ejercicios;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios21_25 {
	public static void ejercicio21() {
		// Pide al usuario un número y dile los divisores de dicho número (resto da cero).
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int n = sc.nextInt();
		System.out.print("Múltiplos del número "+n+": ");
		for (int x=1; x <= n; x++) {
			if (n%x == 0 && n != x) System.out.print(x+", ");
			else if (n == x) System.out.print(x);
		}
		sc.close();
	}

	public static void ejercicio22() {
		// Escribe en una misma línea los números del 1 al 9, 5 veces:
		for (int x=0; x<5; x++) {
			for (int y=1; y<=9; y++) {
				System.out.print(y);
			}
		}
	}

	public static void ejercicio23() {
		//Escribe los números del 1 al 9, después del 1 al 8, del 1 al 7, y así sucesivamente en líneas diferentes.
		for (int x=9; x>0; x--) {
			for (int y=1; y<=x; y++) {
				System.out.print(y);
			}
			System.out.print("\n");
		}
	}

	public static void ejercicio24() {
		// Pide al usuario un número y dibuja un cuadrado (mismo alto que ancho) con asteriscos según el número recibido.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int n = sc.nextInt();
		for (int x=0; x<n; x++) {
			for (int y=0; y<n; y++) {
				System.out.print('#');
			}
			System.out.print("\n");
		}
		sc.close();
	}

	public static void ejercicio25() {
		// Pide al usuario un número y dibuja una escalera de bajada con asteriscos. La base será igual al número recibido.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int n = sc.nextInt();
		for (int x=1; x<=n; x++) {
			for (int y=0; y<x; y++) {
				System.out.print('#');
			}
			System.out.print("\n");
		}
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio21();
		// ejercicio22();
		// ejercicio23();
		// ejercicio24();
		// ejercicio25();
	}

}
