package com.sandra.projectFicherosFechasColecciones;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.sandra.projectFicherosFechasColecciones.models.Cuenta;
import com.sandra.projectFicherosFechasColecciones.utils.UICuenta;

/**
 * Hello world!
 *
 */
public class App {
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
	public static void gestionDatosFicheros() {
		final String nombreFicheroCaixa = "caixa.txt";
		final String nombreFicheroSabadell = "sabadell.txt";
		final String nombreFicheroSantander = "santander.txt";
		Scanner sc = new Scanner (System.in);
		System.out.print("Introduzca su DNI-CIF: ");
		String dni = sc.nextLine();
		Map<String, Cuenta> datosCaixa = UICuenta.getMap(nombreFicheroCaixa);
		Map<String, Cuenta> datosSabadell = UICuenta.getMap(nombreFicheroSabadell);
		Map<String, Cuenta> datosSantander = UICuenta.getMap(nombreFicheroSantander);
		if (datosCaixa.containsKey(dni)) {
			UICuenta.mensajeBienvenidaConFecha(datosCaixa, dni);
			Set<LocalDate> fechasNacimiento = UICuenta.fechasNacimiento(datosCaixa, datosSabadell, datosSantander, dni);
			LocalDate fechaCorrecta = UICuenta.fechaCorrecta(fechasNacimiento, sc);
			int edad = Period.between(fechaCorrecta, LocalDate.now()).getYears();
			double sumaSaldos = UICuenta.sumaSaldos(datosCaixa, datosSabadell, datosSantander, dni);
			List<String> productos = UICuenta.buscarProductos("productosofertados.txt", edad, sumaSaldos);
			System.out.println(UICuenta.ofrecerProducto(productos));
		}
		else System.err.println("No se ha reconocido el DNI-CIF introducido.");
		sc.close();
	}
	
	public static void main(String[] args) {
		gestionDatosFicheros();
    }
}
