package com.sandra.projectFicherosFechasColecciones.models;

import java.time.LocalDate;

public class Cuenta {
	// Atributos en el orden en el que se encuentran en los ficheros
	private String dni_cif;
	private String nombre_cliente;
	private LocalDate fechaNacimiento;// Se encuentra en formato dd/MM/yyyy
	private String codigo_pais;
	private double saldo;
	
	public Cuenta() {
		
	}
	
	public Cuenta(String nombre_cliente, LocalDate fechaNacimiento, String codigo_pais, double saldo) {
		super();
		this.nombre_cliente = nombre_cliente;
		this.fechaNacimiento = fechaNacimiento;
		this.codigo_pais = codigo_pais;
		this.saldo = saldo;
	}

	public Cuenta(String dni_cif, String nombre_cliente, LocalDate fechaNacimiento, String codigo_pais, double saldo) {
		super();
		this.dni_cif = dni_cif;
		this.nombre_cliente = nombre_cliente;
		this.fechaNacimiento = fechaNacimiento;
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

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
