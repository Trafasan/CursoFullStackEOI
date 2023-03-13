package com.sandra.projectJdbc.entidades;

public class Departamentos {
	private int deptno;
	private String nombre;
	
	public Departamentos() {
		
	}

	public Departamentos(int deptno, String nombre) {
		super();
		this.deptno = deptno;
		this.nombre = nombre;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Departamento "+deptno+"\n· Nombre: "+nombre;
	}
	
	
}
