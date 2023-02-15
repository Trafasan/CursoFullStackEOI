package com.sandra.projectFicherosFechasColecciones.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class UIApp {	
	final private static String ruta = "ficheros";
	
	private static Path getRutaFichero(String nombreFichero) {
		return Paths.get(ruta, nombreFichero);
	}
	
	public static String[] buscarCliente(String nombreFichero, String dni) {
		Path archivo = getRutaFichero(nombreFichero);
		try {
			List<String> lineas = Files.readAllLines(archivo);
			for (String linea:lineas) {
				String[] datosCliente = linea.split(";");
				if (datosCliente[0].equals(dni)) return datosCliente;
			}
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
		return null;
	}
	
	public static void mensajeBienvenida(String[] datos) {
		String nombre_cliente = datos[1];
		String codigo_pais = datos[3];
		if (codigo_pais.equals("ES")) System.out.println("Bienvenid@ "+nombre_cliente);
		else System.out.println("Welcome "+nombre_cliente);
	}
	
	public static void fechaActualFormateada(String[] datos) {
		String codigo_pais = datos[3];
		if (codigo_pais.equals("ES")) System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
		else System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")));
		// Cambiar para que la fecha sea Miércoles, 15 de febrero de 2023...
		// Mirar cómo sería en formato inglés
	}
	
	public static LocalDate fechaNacimiento(String[] datos) {
		return LocalDate.parse(datos[2], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	public static boolean fechasIguales(LocalDate fechaCaixa, LocalDate fechaSabadell, LocalDate fechaSantander) {
		if (fechaCaixa.equals(fechaSabadell) && fechaCaixa.equals(fechaSantander) && fechaSabadell.equals(fechaSantander)) return true;
		else return false;
	}
	
	public static List<LocalDate> comparacionFechas(LocalDate fechaCaixa, LocalDate fechaSabadell, LocalDate fechaSantander) {
		List<LocalDate> fechasAElegir = new ArrayList<LocalDate>();
		if (fechaCaixa.equals(fechaSabadell) || fechaSantander.equals(fechaSabadell)) Collections.addAll(fechasAElegir, fechaCaixa, fechaSantander);
		else if (fechaCaixa.equals(fechaSantander)) Collections.addAll(fechasAElegir, fechaCaixa, fechaSabadell);
		else Collections.addAll(fechasAElegir, fechaCaixa, fechaSabadell, fechaSantander);
		return fechasAElegir;
	}
	
	public static double sumaSaldos(String[] datosCaixa, String[] datosSabadell, String[] datosSantander) {
		return Double.parseDouble(datosCaixa[4])+Double.parseDouble(datosSabadell[4])+Double.parseDouble(datosSantander[4]);
	}
	
	public static List<String> buscarProductos(String nombreFichero, int edad, double saldo) {
		Path archivo = getRutaFichero(nombreFichero);
		List<String> productos = new ArrayList<String>();
		try {
			List<String> lineas = Files.readAllLines(archivo);
			for (String linea:lineas) {
				String[] datosProducto = linea.split(";");
				int eMin = Integer.parseInt(datosProducto[0]);
				int eMax = Integer.parseInt(datosProducto[1]);
				double sMin = Double.parseDouble(datosProducto[2]);
				double sMax = Double.parseDouble(datosProducto[3]);
				if (eMin<=edad && edad<=eMax && sMin<=saldo && saldo<=sMax) {
					productos.add(datosProducto[2]);
					productos.add(datosProducto[4]);
				}
			}
			return productos;
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
		return null;
	}
	
	public static List<Double> listaSaldosMin(List<String> productos) {
		List<Double> saldosMin = new ArrayList<Double>();
		for (int i=0; i<productos.size(); i++) {
			saldosMin.add(Double.parseDouble(productos.get(i)));
			productos.remove(i);
		}
		return saldosMin;
	}
	public static double saldoMinimoMasAlto(List<Double> saldosMin) {
		return Collections.max(saldosMin);
	}
}
