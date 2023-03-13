package com.sandra.projectJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.sandra.projectJdbc.entidades.Categorias;
import com.sandra.projectJdbc.entidades.Departamentos;
import com.sandra.projectJdbc.entidades.Empleados;
import com.sandra.projectJdbc.utilidades.JdbcUtils;

public class App {

	static Scanner sc;
	
	static List<Categorias> categorias = new ArrayList<Categorias>();
	static List<Empleados> empleados = new ArrayList<Empleados>();
	static List<Departamentos> departamentos = new ArrayList<Departamentos>();
	
	public static void cargarCategorias() {
		ResultSet rs = JdbcUtils.devolverResultSet("SELECT * FROM categorias");
		if (rs!=null) {
	    	try {
				while(rs.next()) categorias.add(new Categorias(rs.getInt("categoria"), rs.getString("titulo"),
						rs.getInt("salario"), rs.getInt("trienio")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// Listar las categorías
	public static void apartado1() {
		if(!categorias.isEmpty()) categorias.clear();
    	cargarCategorias();
    	categorias.forEach(System.out::println);
	}
	
	public static void cargarEmpleadosPreparedStatement() {
		String sql = "SELECT * FROM empleados";
		List<Object> parametros = new ArrayList<>();
		ResultSet rs = JdbcUtils.devolverResultSetPreparedStatement(sql, parametros);
    	try {
			while(rs.next()) empleados.add(new Empleados(rs.getInt("num"), rs.getString("nombre"), rs.getInt("edad"),
					rs.getInt("departamento"), rs.getInt("categoria"), rs.getDate("contrato").toLocalDate()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Listar los empleados que tengan al menos 40 años contratados antes del 1 de enero de 1998 (usa PreparedStatement)
	public static void apartado2() {
		if(!empleados.isEmpty()) empleados.clear();
    	cargarEmpleadosPreparedStatement();
    	empleados.stream().filter(e->e.getEdad()>=40).filter(e->e.getContrato().isBefore(LocalDate.of(1998, 1, 1))).forEach(System.out::println);
	}
	
	public static Departamentos insertarDepartamento() {
		System.out.print("Introduzca el nombre del departamento: ");
		String nombre = sc.nextLine();
		System.out.print("Introduzca el número del departamento: ");
		int deptno = Integer.parseInt(sc.nextLine());
		List<Object> parametros = new ArrayList<>();
		Collections.addAll(parametros, deptno, nombre);
		int registros = JdbcUtils.PreparedStatementDML("INSERT INTO departamentos (deptno, nombre) VALUES(?, ?)", parametros);
		System.out.println("Se ha insertado "+registros+" registro");
		return registros!=-1 ? new Departamentos(deptno, nombre) : null;
	}
	
	public static void cargarDepartamentosPreparedStatement() {
		String sql = "SELECT * FROM departamentos";
		List<Object> parametros = new ArrayList<>();
		ResultSet rs = JdbcUtils.devolverResultSetPreparedStatement(sql, parametros);
    	try {
			while(rs.next()) departamentos.add(new Departamentos(rs.getInt("deptno"), rs.getString("nombre")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void borrarDepartamento(Departamentos dept) {
		List<Object> parametros = new ArrayList<>();
		Collections.addAll(parametros, dept.getDeptno(), dept.getNombre());
		int registros = JdbcUtils.PreparedStatementDML("DELETE FROM departamentos WHERE deptno=? and nombre=?", parametros);
		System.out.println("Se ha borrado "+registros+" registro");
	}
	
	/* Inserta un departamento (pregunta al usuario usando la consola por un nombre de departamento
	 * y un número). Lista los departamentos para comprobar que se ha insertado. A continuación borra el
	 * departamento que acabas de insertar */
	public static void apartado3() {
		Departamentos newDept = insertarDepartamento();
		if(!departamentos.isEmpty()) departamentos.clear();
		cargarDepartamentosPreparedStatement();
    	departamentos.stream().forEach(System.out::println);
    	if(newDept!=null) {
    		System.out.println("El departamento se ha insertado correctamente, por lo que ahora se procederá a borrarlo");
    		borrarDepartamento(newDept);
    	}
    	else System.out.println("El departamento no se ha insertado correctamente");
	}
	
	public static void menu() {
		int opcion;
		do {
			System.out.println("MENÚ PROGRAMA");
			System.out.println("1. Listar categorías"
					+"\n2. Listar empleados que tengan al menos 40 años contratados antes del 1 de enero de 1998"
					+"\n3. Insertar un departamento. Listar departamentos y eliminar el departamento insertado previamente"
					+"\n4. Salir");
			System.out.print("Introduzca una opción: ");
			try {
				opcion = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				opcion = 0;
			}
			switch (opcion) {
			case 1 -> apartado1();
			case 2 -> apartado2();
			case 3 -> apartado3();
			case 4 -> System.out.println("Hasta pronto :)");
			default -> System.err.println("El dato introducido no es válido");
			}
			if(opcion>0 && opcion<4) System.out.println();
		} while (opcion != 4);
	}
	
    public static void main(String[] args) {
        if (JdbcUtils.conexion()) {
        	sc = new Scanner(System.in);
        	menu();
    		sc.close();
            JdbcUtils.desconexion();
        }
    }
}
