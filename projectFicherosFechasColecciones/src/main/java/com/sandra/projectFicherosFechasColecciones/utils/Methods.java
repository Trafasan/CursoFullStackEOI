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
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.sandra.projectFicherosFechasColecciones.models.Cuenta;

/**
 * Hello world!
 *
 */
public class Methods {	
	final private static String ruta = "ficheros";
	
	private static Path getRutaFichero(String nombreFichero) {
		return Paths.get(ruta, nombreFichero);
	}
	
	public static Map<String, Cuenta> getMap(String nombreFichero) {
		Path archivo = getRutaFichero(nombreFichero);
		Map<String, Cuenta> datosCliente = new HashMap<>();
		try {
			List<String> lineas = Files.readAllLines(archivo);
			for (String linea:lineas) {
				List<String> datosLinea = new ArrayList<>(Arrays.asList(linea.split(";")));
				datosCliente.put(datosLinea.get(0), // dni_cif
						new Cuenta(datosLinea.get(1), //nombre_cliente
								LocalDate.parse(datosLinea.get(2), DateTimeFormatter.ofPattern("dd/MM/yyyy")), // fechaNacimiento
								datosLinea.get(3), // codigo_pais
								Double.parseDouble(datosLinea.get(4)))); // saldo
			}
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}
		return datosCliente;
	}
	
	public static void mensajeBienvenidaConFecha(Map<String, Cuenta> datosCliente, String dni) {
		String nombre_cliente = datosCliente.get(dni).getNombre_cliente();
		String codigo_pais = datosCliente.get(dni).getCodigo_pais();
		if (codigo_pais.equals("ES")) {
			System.out.println("Bienvenid@ "+nombre_cliente);
			String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("eeee',' dd 'de' MMMM 'de' yyyy\n'Hora: 'HH:mm:ss")).toString();
			System.out.println(fecha.toUpperCase().charAt(0) + fecha.substring(1,fecha.length()));
		}
		else {
			System.out.println("Welcome "+nombre_cliente);
			System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("eeee',' MMMM dd',' yyyy\n'Time: 'HH:mm:ss", Locale.UK)));
		}
	}
	
	private static LocalDate fechaNacimiento(Map<String, Cuenta> datosCliente, String dni) {
		return datosCliente.get(dni).getFechaNacimientoCliente();
	}
	
	public static Set<LocalDate> fechasNacimiento(Map<String, Cuenta> datosCaixa, Map<String, Cuenta> datosSabadell, Map<String, Cuenta> datosSantander, String dni) {
		Set<LocalDate> fechasNacimiento = new HashSet<>();
		Collections.addAll(fechasNacimiento, fechaNacimiento(datosCaixa, dni), fechaNacimiento(datosSabadell, dni), fechaNacimiento(datosSantander, dni));
		return fechasNacimiento;
	}
	
	public static LocalDate fechaCorrecta(Set<LocalDate> fechasNacimiento, Scanner sc) {
		if(fechasNacimiento.size() != 1) {
			System.out.println("Se han encontrado diferentes fechas de nacimiento en sus cuentas:");
			fechasNacimiento.forEach(e->System.out.println(e.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
			System.out.print("Eliga cuál de ellas es la correcta: ");
			return LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		else return ((LocalDate[]) fechasNacimiento.toArray(new LocalDate[0]))[0]; // Probar con 222
	}
	
	public static double sumaSaldos(Map<String, Cuenta> datosCaixa, Map<String, Cuenta> datosSabadell, Map<String, Cuenta> datosSantander, String dni) {
		return datosCaixa.get(dni).getSaldo()+datosSabadell.get(dni).getSaldo()+datosSantander.get(dni).getSaldo();
	}
	
	public static List<String> buscarProductos(String nombreFichero, int edad, double saldo) {
		Path archivo = getRutaFichero(nombreFichero);
		List<String> productos = new ArrayList<String>();
		try {
			List<String> lineas = Files.readAllLines(archivo);
			for (String linea:lineas) {
				List<String> datosProducto = new ArrayList<>(Arrays.asList(linea.split(";")));
				int eMin = Integer.parseInt(datosProducto.get(0));
				int eMax = Integer.parseInt(datosProducto.get(1));
				double sMin = Double.parseDouble(datosProducto.get(2));
				double sMax = Double.parseDouble(datosProducto.get(3));
				if (eMin<=edad && edad<=eMax && sMin<=saldo && saldo<=sMax) {
					productos.add(datosProducto.get(2));
					productos.add(datosProducto.get(4));
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
	
	private static List<Double> listaSaldosMin(List<String> productos) {
		List<Double> saldosMin = new ArrayList<Double>();
		for (int i=0; i<productos.size(); i++) {
			saldosMin.add(Double.parseDouble(productos.get(i)));
			productos.remove(i);
		}
		return saldosMin;
	}
	private static double saldoMinimoMasAlto(List<Double> saldosMin) {
		return Collections.max(saldosMin);
	}
	
	public static String ofrecerProducto(List<String> productos) {
		if (productos.size() != 0) {
			List<Double> saldosMin = listaSaldosMin(productos); // Divide en dos la lista
			String producto = productos.get(0);
			if (productos.size() != 1) producto = productos.get(saldosMin.indexOf(saldoMinimoMasAlto(saldosMin)));
			return "¿Le interesaría la "+producto+"?";
		}
		else return "Lo sentimos. No tenemos ningún producto que ofrecerle";
	}
}
