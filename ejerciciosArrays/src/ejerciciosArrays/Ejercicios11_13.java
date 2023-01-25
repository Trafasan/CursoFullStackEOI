/**
 * 
 */
package ejerciciosArrays;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios11_13 {
	public static void ejercicio11() {
		/*
		 * Crea un array de cadenas que almacenará nombres de alumnos, y crea otro array de enteros de 2 dimensiones.
		 * La primera dimensión indicará el alumno (se corresponderá con la posición del array de nombres) y la segunda sus notas.
		 * Crea 4 alumnos con 4 notas cada uno. A continuación muestra los nombres de lo alumnos y su nota media.
		 */
		String[] alumnos = {"Sandra", "Jorge", "María", "Alejandro"};
		// Orden de las notas:Primer alumno-----Segundo alumno-------Tercer alumno-------Cuarto alumno----
		double[][] notas = {{9.5, 8.7, 9, 10},{8.7, 9.5, 8.1, 9},{5.3, 4.7, 5.4, 4.6},{7.3, 6.8, 7, 7.4}};
		// Cálculo de la media
		double[] sumaNotas = new double[notas.length];
		double[] medias = new double[notas.length];
		for (int i = 0; i < alumnos.length; i++) {
			for (int j = 0; j < notas.length; j++) {
				sumaNotas[i]+=notas[i][j];
			}
			medias[i] = sumaNotas[i]/notas.length;
		}
		// Impresión de la tabla
		for (int i = 0; i < alumnos.length; i++) {
			System.out.printf("%-10s|", alumnos[i]);
			for (int j = 0; j < notas.length; j++) {
				System.out.printf("%6.2f", notas[i][j]);
				sumaNotas[i]+=notas[i][j];
			}
			System.out.printf("|%6.2f", medias[i]);
			System.out.println();
		}
	}

	public static void ejercicio12() {
		/*
		 * Haz lo mismo que en el ejercicio anterior pero pidiendo al usuario por consola cuantos alumnos quiere almacenar.
		 * Por cada alumno pide su nombre y 4 notas. Muestra los nombres y sus notas medias.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el número de alumnos que quiera almacenar: ");
		final int numAlumnos = Integer.parseInt(sc.nextLine());
		String[] alumnos = new String [numAlumnos];
		final int numNotas = 4;
		double[][] notas = new double [numAlumnos][numNotas];
		// Cálculo de la media
		double[] sumaNotas = new double[notas.length];
		double[] medias = new double[notas.length];
		for (int i = 0; i < numAlumnos; i++) {
			System.out.print("\nIntroduzca el nombre del alumno nº"+(i+1)+": ");
			alumnos[i] = sc.nextLine();
			for (int j = 0; j < numNotas; j++) {
				System.out.print("Introduzca la nota nº"+(j+1)+" de "+alumnos[i]+": ");
				notas[i][j] = Double.parseDouble(sc.nextLine());
				sumaNotas[i]+=notas[i][j];
			}
			medias[i] = sumaNotas[i]/notas.length;
		}
		// Impresión de la tabla
		System.out.println();
		for (int i = 0; i < alumnos.length; i++) {
			System.out.printf("%-10s|", alumnos[i]);
			for (int j = 0; j < notas.length; j++) {
				System.out.printf("%6.2f", notas[i][j]);
				sumaNotas[i]+=notas[i][j];
			}
			System.out.printf("|%6.2f", medias[i]);
			System.out.println();
		}
		sc.close();
	}

	public static void ejercicio13() {
		/*
		 * Crea un array bidimensional de cadenas. En este array almacenaremos productos con sus respectivos datos.
		 * La primera dimensión hará referencia a la posición de cada producto. Y para cada producto (segunda dimensión),
		 * almacenaremos lo siguiente (son cadenas todo): Nombre, precio y cantidad (3 campos).
		 * Recorre los productos, y muéstralos en formato de tabla, con el nombre, precio, cantidad y precio total.
		 * Ten en cuenta que los datos están almacenados como cadenas y deberás convertir el precio a número decimal y la cantidad a número entero.
		 * Ejemplo de tabla (formatea con longitud fija para cada campo):
		 * NOMBRE PRECIO CANT TOTAL
		 * ------------------------------------------------
		 * Mesa 99,50€ 3 298,50€
		 * Silla 14,95€ 4 59,80€
		 */
		String[][] datosProductos = {{"Mesa", "99.50", "3"},{"Silla", "14.95", "4"}};
		double cambioPrecio = Double.parseDouble(datosProductos[0][1]);
		int cambioCantidad = Integer.parseInt(datosProductos[0][2]);
		System.out.printf("%-15s%-10s%-10s%-10s", "NOMBRE", "PRECIO", "CANT", "TOTAL");
		//datosProductos[0][1];
	}

	public static void main(String[] args) {
		// ejercicio11();
		// ejercicio12();
		ejercicio13();
	}

}
