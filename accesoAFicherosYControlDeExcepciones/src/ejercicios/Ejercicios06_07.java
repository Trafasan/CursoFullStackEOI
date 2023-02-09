/**
 * 
 */
package ejercicios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios06_07 {
	public static void ejercicio06() {
		/*
		 * Haz lo mismo que el ejercicio anterior pero en lugar de pedir que adivine la palabra directamente, muestra una cantidad de asteriscos
		 * de igual longitud que la palabra elegida (pista: puedes concatenar tantos asteriscos en una cadena nueva como longitud tenga la palabra).
		 * A continuación pide al usuario una letra repetidamente:
		 * a. Si la letra está en la palabra, sustituye los asteriscos por dicha letra en la posición correspondiente.
		 * Cuando las palabras sean iguales habrá ganado.
		 * b. Si no está, informa al usuario que ha fallado y muestra cuantos intentos le quedan. En total tiene 7.
		 * Palabra: ****
		 * Dime letra: a
		 * Palabra: *a*a
		 * Dime letra: s
		 * Palabra: *asa
		 * Dime letra: c
		 * Palabra: casa
		 * Enhorabuena!, has acertado
		 */
		Path archivo = Paths.get("archivosEjercicios", "ejercicio05.txt");
		try {
			List<String> lineas = Files.readAllLines(archivo);
			Scanner sc = new Scanner (System.in);
			final int maxIntentos = 7;
			int intentos = maxIntentos;
			String cadenaElegida = devolverAzar(lineas);
			String respuesta = "*".repeat(cadenaElegida.length());
			// System.out.println(cadenaElegida);
			do {
				System.out.print("Introduzca una letra: ");
				char letra = sc.nextLine().charAt(0);
				boolean acierto = false;
				for (int i=0; i<cadenaElegida.length(); i++) {
					if (Character.toLowerCase(letra) == cadenaElegida.charAt(i) || Character.toUpperCase(letra) == cadenaElegida.charAt(i)) {
						respuesta = new StringBuilder(respuesta).replace(i, (i+1), Character.toString(cadenaElegida.charAt(i))).toString();
						acierto = true;
					}
				}
				if (acierto) {
					System.out.println(respuesta);
					if (respuesta.equals(cadenaElegida)) {
						System.out.println("Felicidades. Has acertado");
						break;
					}
				}
				else {
					intentos--;
					String contestacion;
					if (intentos == 1) contestacion = "Le queda un intento";
					else if (intentos == 0) contestacion = "No le quedan intentos. La respuesta correcta era "+cadenaElegida;
					else contestacion = "Le quedan "+intentos+" intento";
					System.out.println("Fallaste. "+contestacion);
				}
			} while (intentos!=0);
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("¡El archivo " + archivo + " no existe!");
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
	}
	public static String devolverAzar(List<String> cadenas) {
		int n = new Random().nextInt(cadenas.size());
		String cadenaElegida = cadenas.get(n);
		return cadenaElegida;
	}

	public static void ejercicio07() {
		/*
		 * Haz un programa que pregunte al usuario por el nombre de un fichero y muestra su contenido.
		 * Observa que cuando el fichero no existe lanza una excepción.
		 * Captúrala e informa de que el fichero no existe al usuario.
		 */
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca la ruta del archivo txt: ");
		String ruta = sc.nextLine();
		System.out.print("Introduzca el nombre del archivo txt: ");
		String archivo = sc.nextLine();
		sc.close();
		try {
			leerArchivos07(Paths.get(obtenerRutaArchivo07(ruta, archivo)));
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage()+ " no encontrado");
		}
	}
	/**
	 * Obtención de la localización de un archivo txt a partir de su ubicación y su nombre.
	 * @param ruta Ubicación del archivo.
	 * @param archivo Nombre del archivo.
	 * @return Variable {@code String} con la localización de un archivo txt.
	 * @throws IOException
	 */
	public static String obtenerRutaArchivo07(String ruta, String archivo) throws IOException {
		String rutaArchivo = ruta+"\\"+archivo+".txt";
		return rutaArchivo;
	}
	/**
	 * Imprime por consola el contenido de un archivo.
	 * @param rutaArchivo Ruta del archivo que se quiere imprimir.
	 * @throws IOException
	 */
	public static void leerArchivos07(Path rutaArchivo) throws IOException {
		Files.readAllLines(rutaArchivo).forEach(l->System.out.println(l));
	}

	public static void main(String[] args) {
		ejercicio06();
		// ejercicio07();
	}

}
