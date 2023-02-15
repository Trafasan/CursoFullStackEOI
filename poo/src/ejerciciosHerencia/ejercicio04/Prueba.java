/**
 * 
 */
package ejerciciosHerencia.ejercicio04;

import java.util.Collections;

/**
 * @author Sandra
 *
 */
public class Prueba {
	
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		Collections.addAll(empresa.getEmpleados(), new Empleado("Fran", 10000), new Empleado("Dani", 20000), new Empleado("Paco", 10000));
		Empresa copia = new Empresa(empresa);
		copia.getEmpleados().get(0).setNombre("Francisco");
		copia.getDireccion().setNumero(10);
		copia.getEmpleados().add(new Empleado("Nuevo", 30000));
		
		System.out.println("Empresa original:");
		System.out.println(empresa);
		System.out.println("Empresa copia:");
		System.out.println(copia);
	}

}
