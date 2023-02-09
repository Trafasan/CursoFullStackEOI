package ejemplosJugadorEquipo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Jugador {
	
	private String nombre;
	private int edad;
	private double sueldo;
	
	public Jugador() {
		
	}
	
	public Jugador(String nombre, int edad, double sueldo) {
		this.nombre = nombre;
		this.setEdad(edad);
		this.setSueldo(sueldo);
	}
	// Constructor de copia
	public Jugador(Jugador j) {
		this.nombre = j.nombre;
		this.setEdad(j.edad);
		this.setSueldo(j.sueldo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		if (edad<0) this.edad = Math.abs(edad);
		else this.edad = edad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		if (sueldo<0) this.sueldo = Math.abs(sueldo);
		else this.sueldo = sueldo;
	}
	
	public String nombreOculto() {
		/*String resultado;
		int numLetras = nombre.length();
		resultado = nombre.substring(0,2) + "*".repeat(numLetras-2);
		return resultado;*/
		
		return nombre.substring(0,2) + "*".repeat(nombre.length()-2);	
	}
	public static void ejemploListaJugadores() {
		// Creo una lista vacía para almacenar los jugadores
		List<Jugador> jugadores = new ArrayList<Jugador>();
		
		Jugador fran = new Jugador("Fran", 45, 50000);
		Jugador david = new Jugador("David", 20, 60000);
		Jugador barbara = new Jugador("Bárbara", 23, 70000);
		Jugador camila = new Jugador("Camila", 22, 80000);
		Jugador joseLuis = new Jugador("José Luis", 18, 60000);
		Jugador enrique = new Jugador("Enrique", 15, 50000);
		Jugador atenea = new Jugador("Atenea", 20, 40000);
		Jugador angel = new Jugador("Ángel", 22, 1000000);
		Jugador nestor = new Jugador();
		nestor.setNombre("Néstor");
		nestor.setEdad(-20);
		nestor.setSueldo(-50000);
		Jugador francisco = new Jugador(fran);
		
		// Meter jugadores en la lista
		jugadores.add(fran);
		jugadores.add(david);
		jugadores.add(barbara);
		jugadores.add(camila);
		jugadores.add(joseLuis);
		jugadores.add(enrique);
		jugadores.add(atenea);
		jugadores.add(angel);
		jugadores.add(nestor);		
		jugadores.add(francisco);
		jugadores.add(new Jugador("Naomi",20,80000));
		
		// Imprmir todos los jugadores
		jugadores.forEach(e->System.out.println(e));
		jugadores.forEach(e->System.out.println(e.nombreOculto() + " gana " + e.getSueldo()));
		// Filtra e imprime:
		System.out.println("Jugadores que ganan más de 60000 euros");
		jugadores.stream()
			.filter(e->e.getSueldo()>60000)
			.forEach(e->System.out.println(e));
		// Filtra e imprime:
		System.out.println("Jugadores que ganan entre 50000 y 70000 euros y su nombre tenga más de 5 letras");
		jugadores.stream()
			.filter(e->e.getSueldo()>=50000 && e.getSueldo()<=70000)
			.filter(e->e.getNombre().length()>5)
			.forEach(e->System.out.println(e));
		// Filtra e imprime:
		System.out.println("Jugadores que tengan una 'N' en su nombre");
		jugadores.stream()
			.filter(e->e.getNombre().toLowerCase().contains("n"))
			.forEach(e->System.out.println(e));		
	}

	@Override
	public String toString() {
		return nombre+"\nEdad: "+edad+"\nSueldo: "+sueldo+"€\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(edad, nombre, sueldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return edad == other.edad && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
	}
	
}
