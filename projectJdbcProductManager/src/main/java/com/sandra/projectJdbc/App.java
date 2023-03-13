package com.sandra.projectJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sandra.projectJdbc.entidades.Category;
import com.sandra.projectJdbc.entidades.Product;
import com.sandra.projectJdbc.utilidades.JdbcUtils;

public class App {

	static Scanner sc;
	
	static List<Category> categorias = new ArrayList<Category>();
	static List<Product> productos = new ArrayList<Product>();
	
	// Inserta una categoría y un producto asociado a dicha categoría usando una transacción
	public static void apartado1() {
		try {
			System.out.println("Introduzca a continuación los datos de la nueva categoría");
			System.out.print("ID: ");
			int idCategory = Integer.parseInt(sc.nextLine());
			System.out.print("Nombre: ");
			String nameCategory = sc.nextLine();
			System.out.println("Introduzca a continuación los datos del nuevo producto asociado a la categoría");
			System.out.print("ID: ");
			int idProduct = Integer.parseInt(sc.nextLine());
			System.out.print("Número de referencia: ");
			String reference = sc.nextLine();
			System.out.print("Nombre: ");
			String nameProduct = sc.nextLine();
			System.out.print("Precio: ");
			double price = Double.parseDouble(sc.nextLine());
			JdbcUtils.apartado1(idCategory, nameCategory, idProduct, reference, nameProduct, price);
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
		}
	}
	
	public static void cargarCategorias() {
		ResultSet rs = JdbcUtils.devolverResultSet("SELECT * FROM category");
		if (rs!=null) {
	    	try {
				while(rs.next()) categorias.add(new Category(rs.getInt("id"), rs.getString("name")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/* Muestra las categorías por pantalla y que el usuario seleccione una. A continuación borra
	 * todos los productos de esa categoría y la propia categoría usando una transacción*/
	public static void apartado2() {
		if(!categorias.isEmpty()) categorias.clear();
    	cargarCategorias();
    	categorias.forEach(System.out::println);
    	System.out.print("Seleccione una categoría: ");
    	int id = Integer.parseInt(sc.nextLine());
    	JdbcUtils.apartado2(id);
	}
	
	public static void cargarProductos() {
		ResultSet rs = JdbcUtils.devolverResultSet("SELECT * FROM product");
		if (rs!=null) {
	    	try {
				while(rs.next()) productos.add(new Product(rs.getInt("id"), rs.getString("reference"),
						rs.getString("name"), rs.getDouble("price"), rs.getInt("category")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Product obtenerProducto(int idP, int idC) {
		List<Product> productos = new ArrayList<Product>();
		String sql = "SELECT * FROM product WHERE id=? and category=?";
		List<Object> parametros = new ArrayList<>();
		Collections.addAll(parametros, idP, idC);
		ResultSet rs = JdbcUtils.devolverResultSetPreparedStatement(sql, parametros);
    	try {
			while(rs.next()) productos.add(new Product(rs.getInt("id"), rs.getString("reference"),
					rs.getString("name"), rs.getDouble("price"), rs.getInt("category")));
			
	    	if (productos.size()==1) return productos.get(0);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;
	}
	
	public static void actualizarProducto(double price, int idP, int idC) {
		List<Object> parametros = new ArrayList<>();
		Collections.addAll(parametros, price, idP, idC);
		int registros = JdbcUtils.PreparedStatementDML("UPDATE product SET price=? WHERE id=? and category=?", parametros);
		System.out.println("Se ha actualizado "+registros+" registro");
	}
	
	/* Muestra las categorías por pantalla y que el usuario seleccione una. A continuación muestra
	 * todos los productos de dicha categoría para que el usuario seleccione uno. Finalmente, pregunta al
	 * usuario por un nuevo precio para ese producto y modificalo*/
	public static void apartado3() {
		if(!categorias.isEmpty()) categorias.clear();
    	cargarCategorias();
    	categorias.forEach(System.out::println);
    	System.out.print("Seleccione una categoría: ");
    	int idC = Integer.parseInt(sc.nextLine());
    	
		if(!productos.isEmpty()) productos.clear();
    	cargarProductos();
    	productos = productos.stream().filter(e->e.getCategory() == idC).collect(Collectors.toList());
    	if (productos.size()!=0) {
        	System.out.println("Productos en la categoría "+idC+":");
        	productos.forEach(System.out::println);
        	System.out.print("Seleccione un producto: ");
        	int idP = Integer.parseInt(sc.nextLine());
        	Product producto = obtenerProducto(idP, idC);
        	if(producto!=null) {
        		System.out.printf("Introduzca el nuevo precio del producto (Precio actual: %.2f€): ", producto.getPrice());
        		double price = Double.parseDouble(sc.nextLine());      	
            	actualizarProducto(price, idP, idC);
        	}
        	else System.out.println("No se ha encontrado el producto");
    	}
    	else System.out.println("No se ha encontrado ningún producto en la categoría "+idC);
	}
	
	public static List<Product> obtenerListProductos(int category) {
		List<Product> productos = new ArrayList<Product>();
		String sql = "SELECT * FROM product category=?";
		List<Object> parametros = new ArrayList<>();
		Collections.addAll(parametros, category);
		ResultSet rs = JdbcUtils.devolverResultSetPreparedStatement(sql, parametros);
    	try {
			while(rs.next()) productos.add(new Product(rs.getInt("id"), rs.getString("reference"),
					rs.getString("name"), rs.getDouble("price"), rs.getInt("category")));
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return productos;
	}
	
	public static Map<Category, List<Product>> obtenerMap() {
		if(!categorias.isEmpty()) categorias.clear();
    	cargarCategorias();
		if(!productos.isEmpty()) productos.clear();
    	cargarProductos();
		Map<Category, List<Product>> mapa = new HashMap<>();
    	for (Category categoria:categorias) 
    		mapa.put(categoria, productos.stream().filter(e->e.getCategory()==categoria.getId()).collect(Collectors.toList()));
		return mapa;
	}
	
	/* Crea las clases Producto y Categoria con los mismos campos que hay en la tablas. A
	 * continuación crea un Map<Categoria, List<Producto>> que almacene por cada categoría (clave)
	 * un listado de productos (valores). Posteriormente, recorrelo y muestra su contenido */
	public static void apartado4() {
		Map<Category, List<Product>> mapa = obtenerMap();
		for (Category categoria : mapa.keySet()) {
			System.out.println(categoria);
			mapa.get(categoria).forEach(System.out::println);
		}
	}
	
    public static void main(String[] args) {
        if (JdbcUtils.conexion()) {
        	sc = new Scanner(System.in);
        	// apartado1();
        	// apartado2();
        	// apartado3();
        	apartado4();
    		sc.close();
            JdbcUtils.desconexion();
        }
    }
}
