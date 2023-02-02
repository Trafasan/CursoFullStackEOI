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
import java.util.Random;
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
		/*
		 * Crea un programa que muestre el siguiente menú:
		 * 1) Mostrar productos
		 * 2) Añadir producto
		 * 0) Salir
		 * Trabajaremos con un fichero que contendrá la información de varios productos.
		 * Un producto en cada línea con los datos nombre y precio separados por punto y coma.
		 * La opción 1 mostrará los productos del fichero (formatea la salida para que los precios salgan alineados con 2 decimales).
		 * La opción 2 te pedirá el nombre de un producto y el precio y lo insertará al final del archivo.
		 * Debes mostrar el menú hasta que el usuario seleccione salir.
		 * Cada una de las opciones impleméntalas en funciones separadas que llamarás desde el método main.
		 */
		int numOpcion=0;
		Scanner sc = new Scanner (System.in);
		do {
			menuEjer04("Mostrar productos", "Añadir producto");
			System.out.print("Seleccione una opción: ");
			numOpcion = Integer.parseInt(sc.nextLine());
			switch (numOpcion) {
			case 1 -> mostrarProductos();
			case 2 -> {
				System.out.print("Introduzca el nombre del producto: ");
				String nombre = sc.nextLine();
				System.out.print("Introduzca el precio del producto: ");
				double precio = Double.parseDouble(sc.nextLine().replace(',', '.'));
				anyadirProductos(nombre, precio);
			}
			case 0 -> System.out.println("Hasta pronto :)");
			default -> System.out.println("Opción no reconocida");
			}
		} while (numOpcion != 0);
		sc.close();
	}
	public static void menuEjer04(String...opciones) {
		int numOpcion = 1;
		for (String opcion : opciones) System.out.println(numOpcion++ + ") " + opcion);
		System.out.println("0) Salir");
	}
	public static void mostrarProductos() {
		Path archivo = Paths.get("archivosEjercicios", "ejercicio04.txt");
		try {
			List<String> lineas = Files.readAllLines(archivo);
			for (String linea:lineas) {
				String[] datos = linea.split(";");
				String nombre = datos[0];
				double precio = Double.parseDouble(datos[1].replace(',', '.'));
				System.out.printf("%s: %.2f€\n", nombre, precio);
			}
			
		} catch (FileNotFoundException e) {
			System.err.println("¡El archivo " + archivo + " no existe!");
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
	}
	public static void anyadirProductos(String nombre, double precio) {
		Path archivo = Paths.get("archivosEjercicios", "ejercicio04.txt");
		try {
			Files.writeString(archivo, nombre+';'+precio+"\n", StandardOpenOption.APPEND);
		} catch (IOException e) {
			System.err.println("Error escribiendo: " + e.getMessage());
		}
	}

	public static void ejercicio05() {
		/*
		 * A partir de un archivo que contiene una palabra en cada línea. Carga las palabras en un array y selecciona una al azar.
		 * Pide al usuario que la adivine. Tiene 3 intentos.
		 */
		Path archivo = Paths.get("archivosEjercicios", "ejercicio05.txt");
		try {
			List<String> lineas = Files.readAllLines(archivo);
			Scanner sc = new Scanner (System.in);
			final int maxIntentos = 3;
			mostrarElementos(lineas);
			String cadenaElegida = devolverAzar(lineas);
			boolean acierto = false;
			int intento = 0;
			do {
				intento++;
				System.out.println("Intento nº"+intento+" de "+maxIntentos);
				System.out.print("Introduzca una cadena: ");
				String respuesta = sc.nextLine();
				if (respuesta.equals(cadenaElegida)) {
					acierto = true;
					break;
				}
			} while (intento<maxIntentos);
			String contestacion = ((acierto) ? "Felicidades, acertaste en tu intento nº"+intento : "Se quedó sin intentos. La palabra correcta era "+cadenaElegida)+'.';
			System.out.println(contestacion);
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("¡El archivo " + archivo + " no existe!");
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
	}
	public static void mostrarElementos(List<String> cadenas) {
		System.out.println("Posibles respuestas: "+String.join(", ", cadenas));
	}
	public static String devolverAzar(List<String> cadenas) {
		int n = new Random().nextInt(cadenas.size());
		String cadenaElegida = cadenas.get(n);
		return cadenaElegida;
	}

	public static void main(String[] args) {
		// ejercicio01();
		// ejercicio02();
		// ejercicio03();
		// ejercicio04();
		// ejercicio05();
	}

}
