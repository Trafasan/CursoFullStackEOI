package ejercicioFicherosFechasColecciones;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	public static Path getRutaFichero(String nombreFichero) {
		return Paths.get(ruta, nombreFichero);
	}
	
	public static void leerFichero(String nombreFichero) {
		try {
			Files.readAllLines(getRutaFichero(nombreFichero)).forEach(l->System.out.println(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca su DNI-CIF: ");
		String dni = sc.nextLine();
		/*leerFichero("caixa.txt");
		leerFichero("productosofertados.txt");
		leerFichero("sabadell.txt");
		leerFichero("santander.txt");*/
		Path archivo = getRutaFichero("caixa.txt");
		try {
			List<String> lineas = Files.readAllLines(archivo);
			for (String linea:lineas) {
				String[] datos = linea.split(";");
				String dni_cif = datos[0];
				String nombre_cliente = datos[1];
				LocalDate fechaNacimiento = LocalDate.parse(datos[2], DateTimeFormatter.ofPattern("dd/MM/yyyy")); // fecha_nacimiento(dd/mm/aaaa)
				// System.out.println(fechaNacimiento);
				String codigo_pais = datos[3]; 
				Double saldo = Double.parseDouble(datos[4]);
				if (dni_cif.equals(dni)) {
					if (codigo_pais.equals("ES")) {
						System.out.println("Bienvenid@ "+nombre_cliente);
						System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
					}
					else {
						System.out.println("Welcome "+nombre_cliente);
						System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")));
					}
				}
			}
		} catch (NoSuchFileException e) {
			System.err.println("No existe el archivo "+e.getMessage());
		} catch (IOException e) {
			System.err.println("Error leyendo el archivo " + archivo);
		}		
		
		sc.close();

	}

}
