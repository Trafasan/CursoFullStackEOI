package com.sandra.projectClases.utilidades;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.sandra.projectClases.entidades.Cuenta;
import com.sandra.projectClases.entidades.CuentaCaixa;
import com.sandra.projectClases.entidades.CuentaSabadell;
import com.sandra.projectClases.entidades.CuentaSantander;

public class Utils {	
	
	public static List<Cuenta> unirListas(List<CuentaCaixa> datosCaixa, List<CuentaSabadell> datosSabadell, List<CuentaSantander> datosSantander) {
		return new ArrayList<>(Arrays.asList(datosCaixa, datosSabadell, datosSantander)).stream().flatMap(e->e.stream()).collect(Collectors.toList());
	}
	
	public static double getSumaSaldosCliente(List<Cuenta> cuentasBancos, String dni) {
		return cuentasBancos.stream().filter(e->e.getDni_cif().equals(dni)).mapToDouble(e->e.getSaldo()).sum();
	}
	
	private static Map<Double, String> getMapaCuentas(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		return cuentasCaixa.stream().collect(Collectors.toMap(e -> Utils.getSumaSaldosCliente(cuentasBancos, e.getDni_cif()), Cuenta::getNombre_cliente));
	}
	public static void imprimirListadoOrganizadoConPartitioningBy(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		Map<Boolean, List<Entry<Double, String>>> mapaCuentas = getMapaCuentas(cuentasCaixa, cuentasBancos).entrySet().stream().collect(Collectors.partitioningBy(e->e.getKey()<0));
		System.out.println("Son morosos: ");
		mapaCuentas.get(true).forEach(e->System.out.printf("· %s (%.2f€)\n", e.getValue(), e.getKey()));
		System.out.println("No son morosos: ");
		mapaCuentas.get(false).forEach(e->System.out.printf("· %s (%.2f€)\n", e.getValue(), e.getKey()));
	}
	
	private static List<String> getListaPersonasMorosas(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		return cuentasCaixa.stream().filter(e->Utils.getSumaSaldosCliente(cuentasBancos, e.getDni_cif())<0).map(e->e.getNombre_cliente()).collect(Collectors.toList());
	}
	private static List<String> getListaPersonasNoMorosas(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		return cuentasCaixa.stream().filter(e->Utils.getSumaSaldosCliente(cuentasBancos, e.getDni_cif())>=0).map(e->e.getNombre_cliente()).collect(Collectors.toList());
	}
	public static void imprimirListadoOrganizadoConListString(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		System.out.println("Personas morosas: "+getListaPersonasMorosas(cuentasCaixa, cuentasBancos).stream().collect(Collectors.joining(", ")));
		System.out.println("Personas no morosas: "+getListaPersonasNoMorosas(cuentasCaixa, cuentasBancos).stream().collect(Collectors.joining(", ")));
	}
	
	private static List<CuentaCaixa> getListaCuentasPersonasMorosas(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		cuentasCaixa.removeIf(e->Utils.getSumaSaldosCliente(cuentasBancos, e.getDni_cif())>=0);
		return cuentasCaixa;
	}
	private static List<CuentaCaixa> getListaCuentasPersonasNoMorosas(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		cuentasCaixa.removeIf(e->Utils.getSumaSaldosCliente(cuentasBancos, e.getDni_cif())<0);
		return cuentasCaixa;
	}
	public static void imprimirListadoOrganizadoConListCuenta(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		System.out.println("Personas morosas: "+getListaCuentasPersonasMorosas(cuentasCaixa, cuentasBancos).stream().map(e->e.getNombre_cliente()).collect(Collectors.joining(", ")));
		System.out.println("Personas no morosas: "+getListaCuentasPersonasNoMorosas(cuentasCaixa, cuentasBancos).stream().map(e->e.getNombre_cliente()).collect(Collectors.joining(", ")));
	}
	
	public static Entry<Double, String> cuentaSaldoMax(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos) {
		return getMapaCuentas(cuentasCaixa, cuentasBancos).entrySet().stream().max(Comparator.comparingDouble(e->e.getKey())).orElseGet(null);
	}
	
	public static void clientesFiltradosPorCadena(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos, String cadena) {
		getMapaCuentas(cuentasCaixa, cuentasBancos).entrySet().stream().filter(e->e.getValue().toLowerCase().contains(cadena.toLowerCase())).forEach(e->System.out.printf("· %s (%.2f€)\n", e.getValue(), e.getKey()));
	}
	
	@SuppressWarnings("unchecked")
	public static void imprimirDatosCliente(List<CuentaCaixa> cuentasCaixa, List<Cuenta> cuentasBancos, int posicion) {
		try {
			String nombreCliente = getMapaCuentas(cuentasCaixa, cuentasBancos).entrySet().stream()
					.sorted(Comparator.comparingDouble(c -> ((Entry<Double, String>) c).getKey()).reversed()).skip(posicion).limit(1)
					.map(e->e.getValue()).collect(Collectors.toList()).get(0);
			cuentasCaixa.stream().filter(c->c.getNombre_cliente().equals(nombreCliente)) .forEach(c->System.out.println(
					"Nombre del cliente: "+c.getNombre_cliente()+"\nDNI-CIF: "+c.getDni_cif()+"\nFecha de nacimiento: "
							+c.getFechaNacimientoCliente().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		} catch (IndexOutOfBoundsException e) {
			System.err.println("La posición no se encuentra dentro del rango establecido");
		}
	}
}
