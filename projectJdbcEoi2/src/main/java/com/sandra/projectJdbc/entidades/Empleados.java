package com.sandra.projectJdbc.entidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Empleados {
	private int num;
	private String nombre;
	private int edad;
	private int departamento;
	private int categoria;
	private LocalDate contrato;
	
	public Empleados() {
		
	}

	public Empleados(int num, String nombre, int edad, int departamento, int categoria, LocalDate contrato) {
		super();
		this.num = num;
		this.nombre = nombre;
		this.edad = edad;
		this.departamento = departamento;
		this.categoria = categoria;
		this.contrato = contrato;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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
		this.edad = edad;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public LocalDate getContrato() {
		return contrato;
	}

	public void setContrato(LocalDate contrato) {
		this.contrato = contrato;
	}

	@Override
	public String toString() {
		return "Empleado "+num
				+"\n· Nombre: "+nombre+"\n· Edad: "+edad+"\n· Departamento: "+departamento
				+"\n· Categoría: "+categoria+"\n· Fecha del contrato: "+contrato.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}
	
	
}
