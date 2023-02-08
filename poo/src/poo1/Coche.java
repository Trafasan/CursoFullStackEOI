package poo1;

import java.util.Objects;

public class Coche {
	
	// Propiedades o atributos
	private int numeroRuedas;
	private String marca;
	private String modelo;
	private String matricula;
	private double precio;
	
	
	// Constructores
	public Coche() {
		
	}

	public Coche(int numeroRuedas, String marca, String modelo, String matricula, double precio) {
		super();
		this.setNumeroRuedas(numeroRuedas);
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.setPrecio(precio);
	}
	
	public Coche(int numeroRuedas, String marca, String modelo, double precio) {
		super();
		this.setNumeroRuedas(numeroRuedas);
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = "0000-ZZZ";
		this.setPrecio(precio);
	}
	
	public Coche(Coche c) { // Copia del Coche c
		super();
		this.setNumeroRuedas(c.numeroRuedas);
		this.marca = c.marca;
		this.modelo = c.modelo;
		this.matricula = c.matricula;
		this.setPrecio(c.precio);
	}
	
	
	// Getters y Setters
	public int getNumeroRuedas() {
		return numeroRuedas;
	}

	public void setNumeroRuedas(int numeroRuedas) {
		if (numeroRuedas == 4 || numeroRuedas == 5) this.numeroRuedas = numeroRuedas;
		else this.numeroRuedas = 4;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		if (this.matricula==null) return "Sin matrícula";
		else return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio<0) this.precio = 0;
		else this.precio = precio;
	}

	@Override
	public String toString() {
		return "Coche [numeroRuedas = " + getNumeroRuedas() + ", marca = " + getMarca() + ", modelo = " + getModelo() + ", matricula = "
				+ getMatricula() + ", precio = " + getPrecio() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(marca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(marca, other.marca);
	}
	
	
	
}
