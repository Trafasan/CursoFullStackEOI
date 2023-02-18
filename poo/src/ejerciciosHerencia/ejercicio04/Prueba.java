/**
 * 
 */
package ejerciciosHerencia.ejercicio04;

/**
 * @author Sandra
 *
 */
public class Prueba {
	
	public static void main(String[] args) {
		Empresa.setNumEmpleados(5);
		Empresa empresa = new Empresa();
		empresa.getEmpleados()[0] = new Empleado("Fran", 10000);
		empresa.getEmpleados()[1] = new Empleado("Dani", 20000);
		empresa.getEmpleados()[2] = new Empleado("Paco", 10000);
		Empresa copia = new Empresa(empresa);
		copia.getEmpleados()[0].setNombre("Francisco");
		copia.getDireccion().setNumero(10);
		copia.getEmpleados()[3] = new Empleado("Nuevo", 30000);
		
		System.out.println("Empresa original:");
		System.out.println(empresa);
		System.out.println("Empresa copia:");
		System.out.println(copia);
	}

}
