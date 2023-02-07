/**
 * 
 */
package accesoAFicherosYControlDeExcepciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class AccesoAFicherosYControlDeExcepciones {
	public static void leerFicheroJava5(String nombreFichero) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File (nombreFichero);
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
			String linea;
			while ((linea = br.readLine()) != null)System.out.println(linea);
		}
		catch(Exception e){
	         e.printStackTrace();
	      }finally{
	         try{                    
	            if( null != fr ) fr.close();              
	         }catch (Exception e2){ 
	            e2.printStackTrace();
	         }
	      }
	}
	
	/**
	 * Función que nos lee todo el contenido de un fichero y nos imprime sus líneas por completo
	 * utilizando Java 8<br>
	 * Files nos permite trabajar con el contenido de los ficheros<br>
	 * Paths nos permite trabajar con las rutas del ordenador<br>
	 * @param nombreFichero Nombre del fichero en formato texto
	 * @throws IOException
	 * @author Sandra
	 */
	public static void leerFicheroJava8(String nombreFichero) {
		try {
			Files.readAllLines(Paths.get(nombreFichero)).forEach(l->System.out.println(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método que lee un fichero y devuelve sus líneas en una lista
	 * @param ruta Path con la ruta del fichero
	 * @return Lista de cadenas, una por cada línea
	 */
	public static List<String> devolverLineasJava8(Path ruta) {
		try {
			List<String> lineas = Files.readAllLines(ruta, Charset.forName("UTF-8"));
			return lineas;
		} catch (IOException e) {
			System.err.println("No se puede acceder al fichero");
			return null;
		}
	}
	
	/**
	 * Escribe un fichero sobreescribiendo el contenido anterior
	 * @param ruta Path con la ruta del fichero
	 * @param lineas Lista con las líneas
	 * @return True en caso de escritura correcta, false en caso contrario
	 */
	public static boolean escribirLineasJava8(Path ruta, List<String> lineas) {
		try {
			Files.write(ruta, lineas);
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	/**
	 * Escribe un fichero respetando el contenido anterior
	 * @param ruta Path con la ruta del fichero
	 * @param lineas Lista con las líneas
	 * @return True en caso de escritura correcta, false en caso contrario
	 */
	public static boolean anyadirLineasJava8(Path ruta, List<String> lineas) {
		try {
			Files.write(ruta, lineas, StandardOpenOption.APPEND); //Sin el StandardOpenOption.APPEND se borraría el contenido anterior del fichero
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public static int controlarDivisionEntera(int numerador, int denominador) {
		try {
			int resultado = numerador/denominador;
			return resultado;
		} catch (Exception e) {
			System.err.println("No se puede dividir por cero");
			return 0;
		}
	}
	public static void leerImprimir() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca un número: ");
		try {
			int n = Integer.parseInt(sc.nextLine());
			System.out.println(n);
		} catch (NumberFormatException e) {
			System.err.println("No ha introducido un número correcto");
		} finally {
			sc.close();
		}
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * leerFicheroJava5(
		 * "C:\\Users\\Sandra\\Documents\\FullStack\\FullStackJavaEOI\\accesoAFicherosYControlDeExcepciones\\archivosEjercicios\\ejercicio03.txt"
		 * ); System.out.println(); leerFicheroJava8(
		 * "C:\\Users\\Sandra\\Documents\\FullStack\\FullStackJavaEOI\\accesoAFicherosYControlDeExcepciones\\archivosEjercicios\\ejercicio03.txt"
		 * ); System.out.println(); List<String> datosDevueltos =
		 * devolverLineasJava8(Paths.get("archivosEjercicios", "ejercicio03.txt"));
		 * datosDevueltos.stream().filter(e->e.charAt(0)=='A').forEach(e->System.out.
		 * println(e)); System.out.println(); if (datosDevueltos != null)
		 * datosDevueltos.forEach(l->System.out.println(l)); controlarDivisionEntera(10,
		 * 0); leerImprimir(); System.out.println("Fin de lectura de ficheros");
		 */
		
		List<String> lineas = new ArrayList<String>();
		lineas.add("Línea 1");
		lineas.add("Línea 2");
		lineas.add("Línea 3");
		lineas.add("Línea 4");
		List<String> lineas2 = Arrays.asList("Línea 5", "Línea 6", "Línea 7", "Línea 8");
		if (escribirLineasJava8(Paths.get("C:\\Users\\Sandra\\Documents\\FullStack\\FullStackJavaEOI\\accesoAFicherosYControlDeExcepciones\\archivosEjercicios\\prueba.txt"), lineas)) {
			System.out.println("El fichero se sobreescribió correctamente");
		} else {
			System.err.println("Error al sobreescribir en el fichero");
		}
		if (anyadirLineasJava8(Paths.get("C:\\Users\\Sandra\\Documents\\FullStack\\FullStackJavaEOI\\accesoAFicherosYControlDeExcepciones\\archivosEjercicios\\prueba.txt"), lineas2)) {
			System.out.println("Las nuevas líneas se añadieron correctamente");
		} else {
			System.err.println("Error al añadir las nuevas líneas en el fichero");
		}
	}

}
