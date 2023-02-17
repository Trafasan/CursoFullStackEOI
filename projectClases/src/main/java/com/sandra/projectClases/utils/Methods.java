package com.sandra.projectClases.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.sandra.projectClases.models.Cuenta;
import com.sandra.projectClases.models.CuentaCaixa;
import com.sandra.projectClases.models.CuentaSabadell;
import com.sandra.projectClases.models.CuentaSantander;

public class Methods {	
	
	public static List<Cuenta> unirListas(List<CuentaCaixa> datosCaixa, List<CuentaSabadell> datosSabadell, List<CuentaSantander> datosSantander) {
		List<Cuenta> cuentasBancos = new ArrayList<Cuenta>();
		cuentasBancos.addAll(datosCaixa);
		cuentasBancos.addAll(datosSabadell);
		cuentasBancos.addAll(datosSantander);
		return cuentasBancos;
	}
	
	public static void impresionListaUnida(List<Cuenta> cuentasBancos) {
		for (Cuenta cuenta:cuentasBancos) {
			if (cuenta instanceof CuentaCaixa) System.out.println("Cuenta de CaixaBank\n"+cuenta);
			else if (cuenta instanceof CuentaSabadell) System.out.println("Cuenta del banco Sabadell\n"+cuenta);
			else System.out.println("Cuenta del banco Santander\n"+cuenta);
		}
	}
	
	private static int numeroAleatorio(List<Cuenta> cuentasBancos) {
		return new Random().nextInt(cuentasBancos.size());
		
	}
	public static void borrarCuenta(List<Cuenta> cuentasBancos) {
		cuentasBancos.remove(numeroAleatorio(cuentasBancos));
	}
	
	public static void impresionCuentaBorrada(List<Cuenta> cuentasBancos, List<CuentaCaixa> cuentasCaixa, List<CuentaSabadell> cuentasSabadell, List<CuentaSantander> cuentasSantander) {
		if (!cuentasBancos.containsAll(cuentasCaixa)) {
    		System.out.println("Se ha borrado esta cuenta de CaixaBank:");
    		for (CuentaCaixa cuenta:cuentasCaixa)
    			if (!cuentasBancos.stream().filter(e->e instanceof CuentaCaixa).toList().contains(cuenta)) 
    				System.out.println(cuenta);
    	}
    	else if (!cuentasBancos.containsAll(cuentasSabadell)) {
    		System.out.println("Se ha borrado esta cuenta del banco Sabadell:");
    		for (CuentaSabadell cuenta:cuentasSabadell)
    			if (!cuentasBancos.stream().filter(e->e instanceof CuentaSabadell).toList().contains(cuenta))
    				System.out.println(cuenta);
    	}
    	else {
    		System.out.println("Se ha borrado esta cuenta del banco Santander:");
    		for (CuentaSantander cuenta:cuentasSantander)
    			if (!cuentasBancos.stream().filter(e->e instanceof CuentaSantander).toList().contains(cuenta))
    				System.out.println(cuenta);
    	}
	}
}
