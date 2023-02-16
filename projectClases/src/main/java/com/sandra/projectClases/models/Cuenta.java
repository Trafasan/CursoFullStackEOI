package com.sandra.projectClases.models;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Objects;

public abstract class Cuenta {
	final private static String ruta = "ficheros";
	
	private String dni_cif;
	private String nombre_cliente;
	private LocalDate fechaNacimientoCliente;// Se encuentra en formato String dd/MM/yyyy
	private String codigo_pais;
	private double saldo;	
	
	public Cuenta() {
		
	}

	public Cuenta(String dni_cif, String nombre_cliente, LocalDate fechaNacimientoCliente, String codigo_pais,
			double saldo) {
		super();
		this.dni_cif = dni_cif;
		this.nombre_cliente = nombre_cliente;
		this.fechaNacimientoCliente = fechaNacimientoCliente;
		this.codigo_pais = codigo_pais;
		this.saldo = saldo;
	}

	public String getDni_cif() {
		return dni_cif;
	}

	public void setDni_cif(String dni_cif) {
		this.dni_cif = dni_cif;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public LocalDate getFechaNacimientoCliente() {
		return fechaNacimientoCliente;
	}

	public void setFechaNacimientoCliente(LocalDate fechaNacimientoCliente) {
		this.fechaNacimientoCliente = fechaNacimientoCliente;
	}

	public String getCodigo_pais() {
		return codigo_pais;
	}

	public void setCodigo_pais(String codigo_pais) {
		this.codigo_pais = codigo_pais;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	public static Path getRutaFichero(String nombreFichero) {
		return Paths.get(ruta, nombreFichero);
	}

	@Override
	public String toString() {
		return "Cuenta2 [dni_cif=" + dni_cif + ", nombre_cliente=" + nombre_cliente + ", fechaNacimientoCliente="
				+ fechaNacimientoCliente + ", codigo_pais=" + codigo_pais + ", saldo=" + saldo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo_pais, dni_cif, fechaNacimientoCliente, nombre_cliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		return Objects.equals(codigo_pais, other.codigo_pais) && Objects.equals(dni_cif, other.dni_cif)
				&& Objects.equals(fechaNacimientoCliente, other.fechaNacimientoCliente)
				&& Objects.equals(nombre_cliente, other.nombre_cliente);
	}
	
	public int compare(Cuenta c1, Cuenta c2) {
		return Integer.parseInt(c1.getDni_cif())-Integer.parseInt(c2.getDni_cif());
	}
	
}
