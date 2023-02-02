/**
 * 
 */
package ejercicios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios01_05 {
	public static void ejercicio01() {
		/*
		 * A partir de un archivo de texto que contenga un número en cada línea. Lee
		 * todos los números y calcula la suma. Muestra los números separados por ‘+’ y
		 * el resultado final.
		 */
		Path archivo = Paths.get("archivosEjercicios", "ejercicio01.txt");
		try {
			List<String> lineas = Files.readAllLines(archivo);
			int[] nums = new int[lineas.size()];
			int suma = 0;
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(lineas.get(i));
				suma += nums[i];
			}
			System.out.print(String.join(" + ", lineas) + " = " + suma);
		} catch (FileNotFoundException e) {
			System.err.println("¡El archivo " + archivo + " no existe!");
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
	}

	public static void ejercicio02() {
		/*
		 * Crea un programa que vaya leyendo lo que el usuario escribe en consola y lo
		 * escriba en un fichero (línea a línea). Terminará cuando el usuario escriba la
		 * palabra ‘FIN’.
		 */
		Scanner sc = new Scanner(System.in);
		Path archivo = Paths.get("archivosEjercicios", "ejercicio02.txt");
		String linea;
		do {
			System.out.print("Introduzca la cadena que quiera escribir en el fichero: ");
			linea = sc.nextLine();
			if (!linea.equals("FIN")) {
				try {
					Files.writeString(archivo, linea + "\n", StandardOpenOption.APPEND);
				} catch (IOException e) {
					System.err.println("Error escribiendo: " + e.getMessage());
				}
			}
		} while (!linea.equals("FIN"));
		sc.close();
	}

	public static void ejercicio03() {
		/*
		 * Lee los datos de un fichero que contenga en cada línea el nombre de un alumno
		 * y su nota, separadas por punto y coma (Ejemplo → Pepito;6.75). Al final del
		 * todo informa de la media, quien tiene la nota más alta y quien la más baja.
		 */
		Path archivo = Paths.get("archivosEjercicios", "ejercicio03.txt");
		String alumNotaMax = "";
		String alumNotaMin = "";
		try {
			List<String> lineas = Files.readAllLines(archivo);
			double[] notas = new double [lineas.size()];
			double notaMax = 0;
			double notaMin = 10;
			for (int i=0; i<lineas.size(); i++) {
				String[] datoAlumno = lineas.get(i).split(";");
				String nombre = datoAlumno[0];
				notas[i] = Double.parseDouble(datoAlumno[1].replace(',', '.'));
				if(notas[i] > notaMax) {
					notaMax = notas[i];
					alumNotaMax = nombre;
				}
				else if(notas[i] < notaMin) {
					notaMin = notas[i];
					alumNotaMin = nombre;
				}
			}
			double media = Arrays.stream(notas).average().getAsDouble();
			System.out.printf("Media de la clase: %.2f\n", media);
			System.out.printf("El alumno con la nota más alta es %s con un %.2f.\n", alumNotaMax, notaMax);
			System.out.printf("El alumno con la nota más baja es %s con un %.2f.", alumNotaMin, notaMin);
			
		} catch (FileNotFoundException e) {
			System.err.println("¡El archivo " + archivo + " no existe!");
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
	}
	 
	public static void ejercicio04() {

	}

	public static void ejercicio05() {

	}

	public static void main(String[] args) {
		// ejercicio01();
		// ejercicio02();
		ejercicio03();
		// ejercicio04();
		// ejercicio05();
	}

}
