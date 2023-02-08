package ejercicio01;

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
