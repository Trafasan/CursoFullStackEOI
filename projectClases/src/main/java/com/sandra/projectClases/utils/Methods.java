package com.sandra.projectClases.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.sandra.projectClases.models.Cuenta;
import com.sandra.projectClases.models.CuentaCaixa;
import com.sandra.projectClases.models.CuentaSabadell;
import com.sandra.projectClases.models.CuentaSantander;

/**
 * Hello world!
 *
 */
public class Methods {	
	
	public static List<Cuenta> unirListas(List<CuentaCaixa> datosCaixa, List<CuentaSabadell> datosSabadell, List<CuentaSantander> datosSantander) {
		List<Cuenta> cuentasBancos = new ArrayList<Cuenta>();
		cuentasBancos.addAll(datosCaixa);
		cuentasBancos.addAll(datosSabadell);
		cuentasBancos.addAll(datosSantander);
		return cuentasBancos;
	}
	
	// Retocar estos métodos para que se asemeje a lo que pide el ejercicio
	public static double sumaSaldos(Map<String, Cuenta> datosCaixa, Map<String, Cuenta> datosSabadell, Map<String, Cuenta> datosSantander, String dni) {
		return datosCaixa.get(dni).getSaldo()+datosSabadell.get(dni).getSaldo()+datosSantander.get(dni).getSaldo();
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
