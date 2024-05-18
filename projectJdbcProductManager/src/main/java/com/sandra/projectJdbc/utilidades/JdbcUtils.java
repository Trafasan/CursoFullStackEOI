package com.sandra.projectJdbc.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcUtils {
	final static String URI = "jdbc:mysql://localhost:3306/product-manager";
	final static String USER = "root";
	final static String PASSWORD = "";
	
	public static Connection con;
	public static Statement st;
	public static PreparedStatement ps;
	public static ResultSet rs;
	
	public static boolean apartado1(int idCategory, String nameCategory, int idProduct, String reference, String nameProduct, double price) {
		try {
			con.setAutoCommit(false);
			try {
				List<Object> parametrosC = new ArrayList<>();
				Collections.addAll(parametrosC, idCategory, nameCategory);
				int registrosC = JdbcUtils.PreparedStatementDML("INSERT INTO category VALUES(?, ?)", parametrosC);
				if (registrosC!=-1) System.out.println("Los datos de la nueva categoría son correctos");
				List<Object> parametrosP = new ArrayList<>();
				Collections.addAll(parametrosP, idProduct, reference, nameProduct, price, idCategory);
				int registrosP = JdbcUtils.PreparedStatementDML("INSERT INTO product VALUES(?, ?, ?, ?, ?)", parametrosP);
				if (registrosP!=-1) System.out.println("Los datos del nuevo producto son correctos");
				con.commit();
			} catch (SQLException e) {
				con.rollback();
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	public static boolean apartado2(int idCategory) {
		try {
			con.setAutoCommit(false);
			try {
				// "DELETE FROM product WHERE category=?"
				List<Object> parametros = new ArrayList<>();
				parametros.add(idCategory);
				int registrosP = JdbcUtils.PreparedStatementDML("DELETE FROM product WHERE category=?", parametros);
				System.out.println(registrosP == 1 ? "Se ha borrado "+registrosP+" producto" : "Se han borrado "+registrosP+" productos");
				
				int registrosC = JdbcUtils.PreparedStatementDML("DELETE FROM category WHERE id=?", parametros);
				if (registrosC!=-1) System.out.println("La categoría se ha borrado correctamente");
				con.commit();
			} catch (SQLException e) {
				con.rollback();
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Método que conecta con la base de datos.
	 * @return True si conecta correctamente, False si falla la conexión
	 */
	public static boolean conexion() {
    	con = null;
    	try {
    		con = DriverManager.getConnection(URI, USER, PASSWORD);
    		return true;
    	} catch (SQLException e) {
    		e.printStackTrace();
		}
    	return false;
    }
	
	/**
	 * Método que desconecta con la base de datos.
	 * @return True si desconecta correctamente, False si falla la desconexión
	 */
	public static boolean desconexion() {
		try {
			if(!con.isClosed()) {
				con.close();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Dada una sentencia sql devuelve un ResultSet con el contenido de los datos solicitados
	 * @param sql. Sentencia SELECT que solicita información
	 * @return ResultSet con los resultados o NULL si la sql es incorrecta
	 */
	public static ResultSet devolverResultSet(String sql) {
		try {
			st = con.createStatement();
			return st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Dada una sentencia de modificación de datos (Insert, Update o Delete)
	 * la ejecuta sobre la Base de Datos y me devuelve el número de registros afectados
	 * @param sql Sentencia de modificación
	 * @return Número de registros afectados. En caso de error devolveré -1.
	 */
	public static int statementDML(String sql) {
		try {
			st = con.createStatement();  
			return st.executeUpdate(sql);   			
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * Dada una sql y una lista de Objetos con sus parámetros a cambiar por las '?'
	 * nos devuelve el ResultSet de los resultados al ejecutar la Select
	 * @param sql String con la SQL con las '?' para que puedan bindeadas (enlazadas)
	 * @param parametros Lista con los parámetros
	 * @return ResultSet de la respuesta de la Select y null en caso de error
	 */
	public static ResultSet devolverResultSetPreparedStatement(String sql, List<Object> parametros) {
		if(parametros.size()!=countMatches(sql, '?')) return null; // Esto significa que no coinciden los parámetros con el número de parámetros esperado
		try {
			ps = con.prepareStatement(sql);
			for(int i=1; i<=parametros.size(); i++) {
				ps.setObject(i, parametros.get(i-1));
			}
			return ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Dada una sql y una lista de Objetos con sus parámetros a cambiar por las '?'
	 * nos devuelve el ResultSet de los resultados al ejecutar la Select
	 * @param sql String con la SQL con las '?' para que puedan bindeadas (enlazadas)
	 * @param parametros Lista con los parámetros
	 * @return número de registros afectados, -1 en caso de error
	 */
	public static int PreparedStatementDML(String sql, List<Object> parametros) {
		if(parametros.size()!=countMatches(sql, '?')) return -1; // Esto significa que no coinciden los parámetros con el número de parámetros esperado
		try {
			ps = con.prepareStatement(sql);
			for(int i=1; i<=parametros.size(); i++) {
				ps.setObject(i, parametros.get(i-1));
			}
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return -1;
		}
	}
	
	private static int countMatches(String sql, char caracterBuscado) {
		return (int)sql.chars().filter(e->e==caracterBuscado).count();
	}
}
