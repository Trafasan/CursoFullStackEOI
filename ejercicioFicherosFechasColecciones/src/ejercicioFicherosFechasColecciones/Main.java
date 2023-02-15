package ejercicioFicherosFechasColecciones;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	/*
	 * Somos una entidad financiera que trabaja con varios bancos y que quiere
	 * ofrecer productos a sus clientes dependiendo de ciertas características del
	 * mismo. Se pedirá por consola el dni-cif del cliente, a partir de ese momento
	 * buscaremos en una ruta (que tendremos definida como una variable global)
	 * todos los ficheros txt que recogen información de los clientes en los
	 * diferentes bancos. Hemos conseguido que todos los bancos nos envíen toda la
	 * información en un formato unificado de este tipo:
	 * 
	 * dni-cif;nombre_cliente;fecha_nacimiento(dd/mm/aaaa);código_país;saldo
	 * 
	 * El programa al recibir un dni-cif hará lo siguiente:
	 * 
	 * Sacar un mensaje de bienvenida en el idioma del cliente (en español para los
	 * clientes de España y en inglés para el resto) donde incluya su nombre (puedes
	 * coger el primero que encuentres).
	 * 
	 * La hora actual (en formato "largo", y poniendo el día antes que el mes para
	 * los clientes españoles y el mes antes que el día para el resto)
	 * 
	 * Posteriormente, comprobará si el cliente tiene más de una fecha de nacimiento
	 * en los ficheros, en cuyo caso, sacará por pantalla las mismas para que el
	 * cliente seleccione cuál es la correcta (si solo hay una no preguntará).
	 * 
	 * Una vez confirmada la fecha de nacimiento, buscaremos en otro fichero de
	 * productos (donde tenemos criterios de que productos ofrecer basándonos en el
	 * saldo y la edad del cliente) acorde al siguiente formato:
	 * 
	 * edad_mínima;edad_maxima;saldo_mínimo;saldo_máximo;nombre_producto
	 * 
	 * (si el cliente puede acceder a más de un producto financiero, mostraremos
	 * aquel cuyo saldo mínimo sea mayor). Para obtener el saldo del cliente deberás
	 * sumar (puede haber saldos negativos), su saldo de todos los bancos.
	 * 
	 * Nota: Intenta estructurar en clases el proyecto Maven. Utiliza las clases ya
	 * vistas en el curso hasta el momento.
	 * 
	 * Se adjuntan datos de 3 bancos (caixa, santander y sabadell) y el fichero de
	 * productos (productosofertados)
	 */
	
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
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca su DNI-CIF: ");
		String dni = sc.nextLine();
		String[] datosCaixa = buscarCliente("caixa.txt", dni);
		String[] datosSabadell = buscarCliente("sabadell.txt", dni);
		String[] datosSantander = buscarCliente("santander.txt", dni);
		if (datosCaixa != null) {
			mensajeBienvenida(datosSabadell);
			fechaActualFormateada(datosSantander);
			LocalDate fechaCaixa = fechaNacimiento(datosCaixa);
			LocalDate fechaSabadell = fechaNacimiento(datosSabadell);
			LocalDate fechaSantander = fechaNacimiento(datosSantander);
			LocalDate fechaCorrecta = fechaCaixa;
			if (!fechasIguales(fechaCaixa, fechaSabadell, fechaSantander)) {
				List<LocalDate> fechasAElegir = comparacionFechas(fechaCaixa, fechaSabadell, fechaSantander);
				System.out.println("Se han encontrado diferentes fechas de nacimiento en sus cuentas:");
				fechasAElegir.forEach(e->System.out.println(e.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
				System.out.print("Eliga cuál de ellas es la correcta: ");
				fechaCorrecta = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			}
			int edad = Period.between(fechaCorrecta, LocalDate.now()).getYears();
			double sumaSaldos = sumaSaldos(datosCaixa, datosSabadell, datosSantander);
			List<String> productos = buscarProductos("productosofertados.txt", edad, sumaSaldos);
			if (productos.size() != 0) {
				List<Double> saldosMin = listaSaldosMin(productos); // Divide en dos la lista
				String producto = productos.get(0);
				if (productos.size() != 1) producto = productos.get(saldosMin.indexOf(saldoMinimoMasAlto(saldosMin)));
				System.out.println("¿Le interesaría la "+producto+"?");
			}
			else System.out.println("Lo sentimos. No tenemos ningún producto que ofrecerle");
		}
		else System.err.println("No se ha reconocido el DNI-CIF introducido.");
		sc.close();
	}

}
