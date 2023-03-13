package com.sandra.projectClases;

import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.sandra.projectClases.entidades.Cuenta;
import com.sandra.projectClases.entidades.CuentaCaixa;
import com.sandra.projectClases.entidades.CuentaSabadell;
import com.sandra.projectClases.entidades.CuentaSantander;
import com.sandra.projectClases.utilidades.Utils;

public class App {
	final static String nombreFicheroCaixa = "caixa.txt";
	final static String nombreFicheroSabadell = "sabadell.txt";
	final static String nombreFicheroSantander = "santander.txt";
	public static Scanner sc;
	/*
	 * En este ejercicio practicaremos algunas de las cosas vistas en programación
	 * funcional, por lo que todos los resultados los tenemos que obtener por esta
	 * técnica. El programa inicialmente cargará los archivos de los diferentes
	 * bancos en la clase Cuenta vista en el ejercicio anterior. Para eso puedes
	 * coger de dicho ejercicio todas las clases que consideres oportunas.
	 * Posteriormente sacarás un menú al usuario con las siguientes opciones:
	 * 
	 * 3. Cliente Preferido. Obtener el nombre de la persona cuyo suma de los saldos
	 * de las cuentas sea mayor.
	 * 
	 * 4. Obtener Clientes por nombre. Pedirá por pantalla una cadena a buscar y
	 * devolverá un listado con los clientes cuyo nombre contiene la cadena buscada
	 * junto con su saldo total en las cuentas.
	 * 
	 * 5. Clientes concretos. Pedirá por pantalla un número que indica su posición
	 * dentro de los que más ganan (es decir, podemos indicar el tercero que más
	 * gane). De él sacará toda su información.
	 */
	
	/*
	 * 1. Obtener saldo cliente. Para ello pedirás un dni por pantalla y devolverás
	 * la suma de todas las cuentas (de todos los bancos) asociadas con ese dni.
	 */
	public static void apartado1(List<Cuenta> cuentasBancos) {
		System.out.print("Introduzca el DNI del cliente del que quiera obtener su saldo total: ");
		String dni = sc.nextLine();
		System.out.printf(Utils.getSumaSaldosCliente(cuentasBancos, dni) != 0 ? "La suma de todos sus saldos es %.2f€\n" :
			"No se ha encontrado a ningún cliente con ese DNI\n", Utils.getSumaSaldosCliente(cuentasBancos, dni));
	}

	/*
	 * 2. Obtener lista morosos y no morosos. Sacaras un listado con aquellas
	 * personas cuya suma de saldos es menor que cero (previamente te habrás creado
	 * una lista con ellos) y de aquellos cuyo saldo es >= 0 (también tendrás una
	 * lista con ellos). Piensa las diferentes formas de obtener esas listas.
	 */
	public static void apartado2(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) { // Tres maneras diferentes de sacar los listados
		Utils.imprimirListadoOrganizadoConPartitioningBy(cuentasCaixa, cuentasBancos);
		// Utils.imprimirListadoOrganizadoConListString(cuentasCaixa, cuentasBancos);
		// Utils.imprimirListadoOrganizadoConListCuenta(cuentasCaixa, cuentasBancos);
	}

	/*
	 * 3. Cliente Preferido. Obtener el nombre de la persona cuyo suma de los saldos
	 * de las cuentas sea mayor.
	 */
	public static void apartado3(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		Entry<Double, String> cuentaSaldoMax = Utils.cuentaSaldoMax(cuentasCaixa, cuentasBancos);
		System.out.printf("El cliente con la mayor suma de saldos es %s\nSaldo: %.2f€\n", cuentaSaldoMax.getValue(), cuentaSaldoMax.getKey());
	}
	
	/*
	 * 4. Obtener Clientes por nombre. Pedirá por pantalla una cadena a buscar y
	 * devolverá un listado con los clientes cuyo nombre contiene la cadena buscada
	 * junto con su saldo total en las cuentas.
	 */
	public static void apartado4(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		System.out.print("Introduzca una cadena para filtrar clientes (no distingue entre letras mayúsculas y minúsculas): ");
		String cadena = sc.nextLine();
		System.out.println("Los clientes cuyos nombres contienen \""+cadena+"\" son los siguientes:");
		Utils.clientesFiltradosPorCadena(cuentasCaixa, cuentasBancos, cadena);
	}
	
	/*
	 * 5. Clientes concretos. Pedirá por pantalla un número que indica su posición
	 * dentro de los que más ganan (es decir, podemos indicar el tercero que más
	 * gane). De él sacará toda su información.
	 */
	public static void apartado5(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		System.out.print("Introduzca la posición del cliente (entre 1 y "+cuentasCaixa.size()+"): ");
		try {
			int posicion = Integer.parseInt(sc.nextLine());
			Utils.imprimirDatosCliente(cuentasCaixa, cuentasBancos, --posicion);
		} catch (NumberFormatException e) {
			System.err.println("El dato introducido no es un número");
		}
	}
	
	public static void tiempoEsperaMenu() {
		long milisegundos = 5000;
		System.err.println("\nEn "+5000/1000+" segundos aparecerá el menú de nuevo. Le agradecemos su paciencia\n");
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public static void menu(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		int opcion;
		do {
			System.out.println("MENÚ PROGRAMA");
			System.out.println("1. Obtener el saldo de un cliente"
					+"\n2. Obtener listado de clientes morosos y no morosos"
					+"\n3. Obtener el nombre del cliente con la mayor suma de saldos"
					+"\n4. Obtener clientes por nombre"
					+"\n5. Obtener un cliente por su posición entre los que más ganan"
					+"\n6. Salir");
			System.out.print("Introduzca una opción: ");
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				opcion = 0;
			}
			switch (opcion) {
			case 1 -> apartado1(cuentasBancos);
			case 2 -> apartado2(cuentasCaixa, cuentasBancos);
			case 3 -> apartado3(cuentasCaixa, cuentasBancos);
			case 4 -> apartado4(cuentasCaixa, cuentasBancos);
			case 5 -> apartado5(cuentasCaixa, cuentasBancos);
			case 6 -> System.out.println("Hasta pronto :)");
			default -> System.err.println("El dato introducido no es válido");
			}
			if(opcion>0 && opcion<6) tiempoEsperaMenu();
		} while (opcion != 6);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		List<CuentaCaixa> cuentasCaixa = CuentaCaixa.getListCuentaCaixa(nombreFicheroCaixa);
		List<CuentaSabadell> cuentasSabadell = CuentaSabadell.getListCuentaSabadell(nombreFicheroSabadell);
		List<CuentaSantander> cuentasSantander = CuentaSantander.getListCuentaSantander(nombreFicheroSantander);
		List<Cuenta> cuentasBancos = Utils.unirListas(cuentasCaixa, cuentasSabadell, cuentasSantander);
		menu(cuentasCaixa, cuentasBancos);
		sc.close();
	}
}
