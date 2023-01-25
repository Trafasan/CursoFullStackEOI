/**
 * 
 */
package ejerciciosArrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios01_05 {
	public static void ejercicio01() {
		/*
		 * Crea un array con los nombres de los meses. A continuación pide al usuario un número del 1 al 12.
		 * Muéstrale el nombre del mes correspondiente sin usar estructuras condicionales (es decir, a partir de los valores del array).
		 */
		Scanner sc = new Scanner(System.in);
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		System.out.print("Introduzca el número del mes: ");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println("El nombre del mes introducido es "+meses[n-1]);
		sc.close();
	}

	public static void ejercicio02() {
		/*
		 * Crea un array de enteros con 10 posiciones. A continuación pide al usuario que vaya introduciendo uno a uno los 10 números por consola.
		 * Muestra lo siguiente:
		 * a. La lista de números introducidos
		 * b. La suma de los números
		 * c. La media de los números
		 * d. El mayor y el menor de los números (crea un máximo y un mínimo provisional que será igual al primer número del array,
		 * después vas comparando con el resto de posiciones).
		 */
		Scanner sc = new Scanner(System.in);
		int[] nums = new int [10];
		for (int i=0; i<nums.length; i++) {
			System.out.print("Introduzca un número ("+(i+1)+"/"+nums.length+"): ");
			nums[i] = Integer.parseInt(sc.nextLine());
		}
		int suma=0;
		System.out.print("\nLista de números:");
		for (int x:nums) {
			System.out.print(" "+x);
			suma+=x;
		}
		int nMax = nums[0], nMin = nums[0];
		for (int i=1; i<nums.length; i++) {
			if (nums[i-1]<nums[i]) nMax = nums[i];
			if (nums[i-1]>nums[i]) nMin = nums[i];
		}
		System.out.println("\nLa suma de todos los números es: "+suma);
		double media = (double) suma/nums.length;
		System.out.println("La media de los números es: "+media);
		System.out.println("El número mayor es: "+nMax);
		System.out.println("El número menor es: "+nMin);
		sc.close();
	}
	
	public static void ejercicio02OrdenarConSort() {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int [10];
		for (int i=0; i<nums.length; i++) {
			System.out.print("Introduzca un número ("+(i+1)+"/"+nums.length+"): ");
			nums[i] = Integer.parseInt(sc.nextLine());
		}
		Arrays.sort(nums);
		int nMin = nums[0], nMax = nums[nums.length-1];
		System.out.println("El número mayor es: "+nMax);
		System.out.println("El número menor es: "+nMin);
		sc.close();
	}

	public static void ejercicio03() {
		/*
		 * Pide al usuario 10 números con decimales (double). Usa un array para almacenarlos.
		 * Muestra la media y los números que están por encima de esa media.
		 */
		Scanner sc = new Scanner(System.in);
		double[] nums = new double [10];
		double suma=0;
		for (int i=0; i<nums.length; i++) {
			System.out.print("Introduzca un número ("+(i+1)+"/"+nums.length+"): ");
			nums[i] = Integer.parseInt(sc.nextLine());
			suma+=nums[i];
		}
		double media = suma/nums.length;
		System.out.println("Media: "+media);
		System.out.print("Números que superan la media:");
		for (double x:nums) {
			if (x>media) System.out.print(" "+x);
		}
		sc.close();
	}

	public static void ejercicio04() {
		/*
		 * Crea un programa que almacene en una tabla el número de días que tiene cada mes (de un año no bisiesto),
		 * pida al usuario que te indique un mes (ej. 2 para febrero) y un día (ej. el día 15).
		 * Muéstrale qué número de día es dentro del año (por ejemplo, el 15 de febrero sería el día número 46,
		 * y el 31 de diciembre sería el día 365).
		 */
		Scanner sc = new Scanner(System.in);
		int[][] diasPorMes = new int [12][];
		
		for(int i = 0; i < diasPorMes.length; i++) {
			switch (i) {
			// Para los meses 1, 3, 5, 7, 8, 10 y 12;
			case 0, 2, 4, 6, 7, 9, 11 -> diasPorMes[i] = new int[31];
			// Para el mes 2
			case 1 -> diasPorMes[i] = new int[28];
			// Para el mes 4, 6, 9 y 11
			case 3, 5, 8, 10 -> diasPorMes[i] = new int[30];
			}
			for (int j = 0; j < diasPorMes[i].length; j++) {
				diasPorMes[i][j] = (j+1);
			}
		}
		
		// Comprobación de que se formó la tabla, no lo pide el ejercicio
		String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		for (int i = 0; i < diasPorMes.length; i++) {
			// System.out.print(meses[i]+":");
			System.out.printf("%-10s|", meses[i]);
			for (int j = 0; j < diasPorMes[i].length; j++) {
				System.out.print(" "+diasPorMes[i][j]);
			}
			System.out.println();
		}
		
		System.out.print("\nIntroduzca el número del mes: ");
		int mes = Integer.parseInt(sc.nextLine());
		System.out.print("Introduzca el dia: ");
		int dia = Integer.parseInt(sc.nextLine());
		int contadorDias = 0;
		for (int i = 0; i < diasPorMes.length; i++) {
			for (int j = 0; j < diasPorMes[i].length; j++) {
				contadorDias++;
				if (i == (mes-1) && j == (dia-1)) break;
			}
			if (i == (mes-1)) break;
		}
		System.out.println("\nEl día introducido es el día "+contadorDias+" del año.");
		// Gracias al array del apartado opcional se puede imprimir la misma línea de la siguiente manera
		System.out.println("El día "+dia+" de "+meses[mes-1].toLowerCase()+" es el día "+contadorDias+" del año.");
		sc.close();
	}

	public static void ejercicio05() {
		/*
		 * Crea 2 arrays, uno para almacenar notas de alumnos y otro para almacenar sus nombres.
		 * A continuación pregunta al usuario cuántos alumnos hay en total.
		 * En función del número de alumnos pide sus nombres y sus notas y guárdalos en los respectivos arrays.
		 * Recorre ambos arrays mostrando el nombre de cada alumno y su nota.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el número de alumnos: ");
		int nAlumnos = Integer.parseInt(sc.nextLine());
		double notas[] = new double [nAlumnos];
		String nombres[] = new String [nAlumnos];
		for (int i=0; i<nAlumnos; i++) {
			System.out.print("\nIntroduzca el nombre del alumno "+(i+1)+": ");
			nombres[i] = sc.nextLine();
			System.out.print("Introduzca el nombre del alumno "+(i+1)+": ");
			notas[i] = Double.parseDouble(sc.nextLine());
		}
		for (int i=0; i<nAlumnos; i++) {
			System.out.println("Nota de "+nombres[i]+": "+notas[i]);
		}
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio01();
		// ejercicio02();
		// ejercicio02OrdenarConSort();
		// ejercicio03();
		// ejercicio04();
		// ejercicio05();
	}

}
