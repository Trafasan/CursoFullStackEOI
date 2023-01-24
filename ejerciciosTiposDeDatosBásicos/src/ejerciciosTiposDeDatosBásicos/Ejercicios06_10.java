/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios06_10 {
	public static void ejercicio06() {
		/*
		 * Programa que declare cuatro variables enteras A, B, C y D y asígnale un valor a cada una. A continuación escribe las instrucciones necesarias para que:
		 * a. B tome el valor de C
		 * b. C tome el valor de A
		 * c. A tome el valor de D
		 * d. D tome el valor de B
		 * Si por ejemplo: A = 1, B = 2, C = 3 y D = 4, el programa debe mostrar:
		 * Valores iniciales: A = 1 B = 2 C = 3 D = 4
		 * B toma el valor de C -> B = 3
		 * C toma el valor de A -> C = 1
		 * A toma el valor de D -> A = 4
		 * D toma el valor de B -> D = 2
		 */
		
		int A=1, B=2, C=3, D=4;
		int Bi = B;
		System.out.println("Valores iniciales: A = "+A+" B = "+B+" C = "+C+" D = "+D);
		B=C;
		System.out.println("B toma el valor de C -> B = "+B);
		C=A;
		System.out.println("C toma el valor de A -> C = "+C);
		A=D;
		System.out.println("A toma el valor de D -> A = "+A);
		D=Bi;
		System.out.println("D toma el valor de B -> D = "+D);
	}

	public static void ejercicio07() {
		/*
		 * Crea un programa donde definimos 2 variables de tipo carácter. Muestra la posición de cada carácter en la tabla unicode y la diferencia entre ambos
		 * caracteres. Si los caracteres son ‘b’ y ‘k’, la salida sería:
		 * 'b' tiene la posición 98
		 * 'k' tiene la posición 107
		 * Diferencia entre 'b' y 'k': 9
		 */
		char letra1 = 'b', letra2 = 'k';
		int pos1 = letra1, pos2 = letra2;
		System.out.println(letra1+" tiene la posición "+pos1);
		System.out.println(letra2+" tiene la posición "+pos2);
		System.out.println("Diferencia entre "+letra1+" y "+letra2+": "+(letra2-letra1));
	}

	public static void ejercicio08() {
		/*
		 * ¿Cuál sería el resultado de las siguientes operaciones? a=5; b=++a; c=a++; b=b*5; a=a*2;
		 * Calcúlalo a mano y luego crea un programa que lo resuelva, para ver si habías hallado la solución correcta.
		 */
		int a = 5;
		System.out.println("Valor inicial de a: "+a);
		int b = ++a; // Primero aumenta el valor de a y luego se igualan los valores
		System.out.println("Valor de b: "+b);
		int c = a++; // Primero se igualan los valores y luego aumenta el valor de a
		System.out.println("Valor de c: "+c);
		b = b*5;
		System.out.println("Valor de b: "+b);
		a=a*2;
		System.out.println("Valor de a: "+a);
	}

	public static void ejercicio09() {
		// Pregúntale al usuario su nombre y muestra un mensaje saludándole con su nombre.
				Scanner sc = new Scanner (System.in);
				String nombre;
				System.out.print("¿Cuál es su nombre? ");
				nombre = sc.nextLine();
				System.out.println("Hola "+nombre);
				sc.close();
	}

	public static void ejercicio10() {
		// Escribe un programa que lee un número entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese número.
				Scanner sc = new Scanner (System.in);
				int n;
				System.out.print("Inserte un número: ");
				n = sc.nextInt();
				sc.nextLine();
				int n2 = n*2, n3 = n*3;
				System.out.println("El doble de ese número es "+n2);
				System.out.println("El triple de ese número es "+n3);
				sc.close();
	}

	public static void main(String[] args) {
		// ejercicio06();
		// ejercicio07();
		// ejercicio08();
		// ejercicio09();
		// ejercicio10();
	}

}
