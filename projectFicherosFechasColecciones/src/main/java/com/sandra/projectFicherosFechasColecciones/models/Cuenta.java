package com.sandra.projectFicherosFechasColecciones.models;

import java.time.LocalDate;

public class Cuenta {
	// Atributos en el orden en el que se encuentran en los ficheros
	private String nombre_cliente;
	private LocalDate fechaNacimientoCliente;// Se encuentra en formato String dd/MM/yyyy
	private String codigo_pais;
	private double saldo;
	
	public Cuenta() {
		
	}
	
	public Cuenta(String nombre_cliente, LocalDate fechaNacimiento, String codigo_pais, double saldo) {
		super();
		this.nombre_cliente = nombre_cliente;
		this.fechaNacimientoCliente = fechaNacimiento;
		this.codigo_pais = codigo_pais;
		this.saldo = saldo;
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
	
	
}
