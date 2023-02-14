package poo2;

import java.util.Objects;
import java.util.Random;

public abstract class Animal {
	private double peso;
	private String nombre;

	public Animal() {
		this.peso = 1;
		this.nombre = "Animal desconocido";
	}

	public Animal(String nombre, double peso) {
		this.nombre = nombre;
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void comer() {
		peso += new Random().nextDouble() * 0.5;
		System.out.printf("Ñam ñam. Ahora peso %.2f kilos.\n", peso);
	}
	
	public abstract String tipoAnimal();
	public abstract String rugido();

	@Override
	public String toString() {
		return String.format("%s: %.2f kilos", nombre, peso);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, peso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(peso) == Double.doubleToLongBits(other.peso);
	}
}
