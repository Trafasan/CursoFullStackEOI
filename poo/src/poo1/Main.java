/**
 * 
 */
package poo1;

/**
 * @author Sandra
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Coche miCoche = new Coche();
		miCoche.setNumeroRuedas(6);
		miCoche.setMarca("Seat");
		miCoche.setModelo("Altea");
		miCoche.setPrecio(10000);
		miCoche.setMatricula("0000-ZZZ");
		System.out.println(miCoche);
		System.out.println("Mi coche es un "+miCoche.getMarca()+" "+miCoche.getModelo()+" con matrícula: "+miCoche.getMatricula()+".\n");
		
		Coche z3 = new Coche(40, "BMW", "Z3", "1111-BBB", -20000);
		System.out.println(z3);
		System.out.println("Mi nuevo coche es un "+z3.getMarca()+" "+z3.getModelo()+" con matrícula: "+z3.getMatricula()+".\n");
		
		Coche tercero = new Coche(4, "Mercedes", "Clase A", 15000);
		System.out.println(tercero+"\n");

		System.out.println("Z3 original: "+z3);
		Coche clonz3 = new Coche(z3);
		clonz3.setMatricula("2222-CCC");
		System.out.println("Z3 clonado: "+clonz3);
		
		if(z3.equals(clonz3)) {
			System.out.println("Los coches son iguales.");
		} else {
			System.out.println("Los coches son diferentes.");
		}
	}

}
