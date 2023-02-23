package com.sandra.programacionFuncional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

import com.sandra.programacionFuncional.ejercicios.Ejercicios;
import com.sandra.programacionFuncional.entidades.Usuario;
public class App {
	
	static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public static void poblar() {
		usuarios.clear();
		usuarios.add(new Usuario(1,"Fran",30000));
		usuarios.add(new Usuario(2,"Ángel",20000));
		usuarios.add(new Usuario(3,"Miguel Ángel",40000));
		usuarios.add(new Usuario(4,"David",30000));
		usuarios.add(new Usuario(5,"Enrique",50000));
		usuarios.add(new Usuario(6,"Naomi",-30000));
		usuarios.add(new Usuario(1,"Fran",30000));
		usuarios.add(new Usuario(7,"Francisco",100000));
	}
	
	public static void descargar() {
		usuarios.clear();
	}
	
	// Para recorrer los elementos de una lista...
	public static void forEach() {
		// Final
		
		// Programación estructural
		for(int i = 0; i<usuarios.size(); i ++) System.out.println(i + ". " + usuarios.get(i).toString());
		for(Usuario usuario : usuarios) System.out.println(usuario);
		
		// Programación funcional (3 posibilidades)
		usuarios.forEach(e->System.out.println(e));
		usuarios.forEach(System.out::println);
		usuarios.stream().forEach(e->System.out.println(e));
	}
	
	// Para filtrar los elementos de una lista...
	public static void filter() {
		// No final
		usuarios.stream().filter(e->e.getSueldo()>30000).forEach(e->System.out.println(e));
		usuarios.stream().filter(e->e.getSueldo()>30000 && e.getSueldo()<50000).forEach(e->System.out.println(e));
		usuarios.stream().filter(e->e.getSueldo()>30000).filter(e->e.getSueldo()<50000).forEach(e->System.out.println(e));
		
		// Creación de una sublista con .collect()
		List<Usuario> ricos = usuarios.stream().filter(e->e.getSueldo()>=50000).collect(Collectors.toList());
		System.out.println("Los ricos son:");
		ricos.forEach(e->System.out.println(e));		
	}
	
	public static void map() {
		// No final
		List <String> nombres = usuarios.stream().map(e->e.getNombre()).collect(Collectors.toList());
		nombres.forEach(e->System.out.println(e));
		// Para filtrar enteros, se puede utilizar mapToInt
		usuarios.stream().filter(e->e.getSueldo()>40000).mapToInt(e->e.getId()).filter(e->e<6).forEach(e->System.out.println(e));
		Set<String> nombresDistintos = usuarios.stream().map(e->e.getNombre()).collect(Collectors.toSet());
		System.out.println("Nombres distintos: ");
		nombresDistintos.forEach(e->System.out.println(e));
	}
	
	public static void toSet() {
		Set<Usuario> usuariosDistintos = usuarios.stream().collect(Collectors.toSet());
		usuariosDistintos.forEach(e->System.out.println(e));
	}
	
	public static void sumAvg() {
		double sumaSueldos = usuarios.stream().mapToDouble(e->e.getSueldo()).sum();
		System.out.println("La suma de todos los sueldos es: "+sumaSueldos);
		
		// Los OptionalDouble son datos que pueden contener valor o no
		OptionalDouble mediaOpcional = usuarios.stream().mapToDouble(e->e.getSueldo()).average();
		System.out.println("La media es: "+mediaOpcional.getAsDouble());
		
		descargar();
		OptionalDouble mediaOpcional2 = usuarios.stream().mapToDouble(e->e.getSueldo()).average();
		// Para que no de error cuando se quiera obtener el valor...
		if(mediaOpcional2.isPresent()) System.out.println("La media es: "+mediaOpcional2.getAsDouble());
		else System.out.println("La lista está vacía y por lo tanto no hay media");
		
		poblar();
		double mediaSegura = usuarios.stream().mapToDouble(e->e.getSueldo()).average().orElse(0); // Valor por defecto en caso de no contener valor
		System.out.println("La media segura es: "+mediaSegura);
		
		descargar();
		double mediaSegura2 = usuarios.stream().mapToDouble(e->e.getSueldo()).average().orElse(0); // Valor por defecto en caso de no contener valor
		System.out.println("La media segura es: "+mediaSegura2);
	}
	
	public static void find() {
		// Final
		
		// FindFirst devuelve el primero que encuentre
		Optional<Usuario> usuario = usuarios.stream().filter(e->e.getSueldo()>45000).findFirst();
		if(usuario.isPresent())	System.out.println("El primer usuario que gana más de 45000 es "+usuario.get().getNombre());
		else System.out.println("Nadie gana esa cantidad");
		
		Usuario usuario2 = usuarios.stream().filter(e->e.getSueldo()>45000).findFirst().orElse(null);
		if(usuario2!=null) System.out.println("El primer usuario que gana más de 45000 es "+usuario2.getNombre());
		else System.out.println("Nadie gana esa cantidad");

		Usuario usuario3 = usuarios.stream().filter(e->e.getSueldo()>450000).findFirst().orElse(new Usuario(1, "Sin datos", 0));
		System.out.println(usuario3.getNombre());

		// FindAny devuelve cualquiera
		Usuario usuario4 = usuarios.stream().filter(e->e.getSueldo()>45000).findAny().orElse(new Usuario(1, "Sin datos", 0));
		System.out.println(usuario4.getNombre()+" gana más de 45000");
	}
	
	public static void flatMap() {
		List <String> clase1 = new ArrayList<>(Arrays.asList("Fran", "Dani"));
		List <String> clase2 = new ArrayList<>(Arrays.asList("Paco", "Pepe"));
		List<List<String>> todasClases = new ArrayList<>(Arrays.asList(clase1, clase2));
		todasClases.forEach(e->System.out.println(e));
		List<String> todosAlumnos = todasClases.stream().flatMap(e->e.stream()).collect(Collectors.toList());
		todosAlumnos.forEach(e->System.out.println(e));
	}
	// El peek hace lo mismo que el forEach, pero es no final
	public static void peek() {
		usuarios.stream().forEach(e->System.out.println(e));
		System.out.println("Cambiando el sueldo:");
		usuarios.stream().peek(e->e.setSueldo(e.getSueldo()+1000)).forEach(e->System.out.println(e));
	}
	
	// Parte la lista original en dos sublistas
	public static void partitioningBy() {
		Map<Boolean, List<Usuario>> sublistas = usuarios.stream().collect(Collectors.partitioningBy(e->e.getSueldo()>35000));
		System.out.println("Ganan más de 35000:");
		sublistas.get(true).forEach(e->System.out.println(e));
		System.out.println("Ganan menos de 35000:");
		sublistas.get(false).forEach(e->System.out.println(e));
	}
	
	// Agrupa por la condición que le digamos
	public static void groupingBy() {
		Map<Character, List<Usuario>> agenda = usuarios.stream().collect(Collectors.groupingBy(e->e.getNombre().charAt(0)));
		if (agenda.containsKey('Á')) {
			System.out.println("Nombres que comienzan por A:");
			agenda.get('Á').forEach(e->System.out.println(e));
		}
		if (agenda.containsKey('F')) {
			System.out.println("Nombres que comienzan por F:");
			agenda.get('F').forEach(e->System.out.println(e));
		}
		
		// Para recorrer todas las listas (las vocales con acento no se cuentan
		for (int i = (int)'A';i<=(int)'Z';i++) {
			if(agenda.containsKey((char)i)) {
				System.out.println("Nombres que comienzan por "+(char)i+":");
				agenda.get((char)i).forEach(e->System.out.println(e));
			}
		}
	}
	
	public static void count() {
		// Final
		long numRicos = usuarios.stream().filter(e->e.getSueldo()>40000).count();
		System.out.println("El número de ricos es "+numRicos);
	}
	
	public static void skipYLimit() {
		// No finales
		usuarios.stream().sorted(Comparator.comparingDouble(Usuario::getSueldo).reversed()).skip(2).limit(3).forEach(e->System.out.println(e));
	}
	
	public static void maxMin() {
		Optional<Usuario> masId = usuarios.stream().max(Comparator.comparingInt(Usuario::getId));
		if (masId.isPresent()) System.out.println("El usuario con id más alto es: "+masId.get().getNombre());
		Optional<Usuario> menosId = usuarios.stream().min(Comparator.comparingInt(Usuario::getId));
		if (menosId.isPresent()) System.out.println("El usuario con id más alto es: "+menosId.get().getNombre());
	}
	
	public static void distinct() {
		// No final
		long nUsuariosDistintos = usuarios.stream().distinct().count();
		System.out.println("El número de usuarios distintos es "+nUsuariosDistintos);
		// List<Usuario> usuariosDistintos = usuarios.stream().distinct().collect(Collectors.toList());
		System.out.println("La lista de sueldos distintos es: ");
		usuarios.stream().mapToDouble(Usuario::getSueldo).sorted().distinct().forEach(e->System.out.println(e));
		System.out.println("La lista de nombres distintos es: ");
		usuarios.stream().map(Usuario::getNombre).distinct().forEach(e->System.out.println(e));
	}
	
	public static void summarizingDouble() {
		// Final
		DoubleSummaryStatistics estadisticas = usuarios.stream().collect(Collectors.summarizingDouble(Usuario::getSueldo));
		System.out.println("Media: "+estadisticas.getAverage());
		System.out.println("Máximo: "+estadisticas.getMax());
		System.out.println("Mínimo: "+estadisticas.getMin());
		System.out.println("Suma: "+estadisticas.getSum());
		System.out.println("Número: "+estadisticas.getCount());
	}
	
	public static void reduce() {
		// Final
		int idsMultiplicados = usuarios.stream().mapToInt(e->e.getId()).reduce(1, (a,b)->a*b);
		System.out.println("La multiplicación de los id's es "+idsMultiplicados);
		String nombres = usuarios.stream().map(e->e.getNombre()).reduce("", (a,b)->a.concat(b).concat("\n"));
		System.out.println(nombres);
	}
	
	public static void joining() {
		// Final
		String nombresDistintos = usuarios.stream().map(e->e.getNombre().toLowerCase()).distinct().sorted().collect(Collectors.joining(", "));
		System.out.println(nombresDistintos);
	}
	
	/**
	 * Es igual a steam pero utilizando procesamiento paralelo.<br>
	 * Nos aprovechamos de los núcleos de nuestro ordenador.
	 */
	public static void parallelStream() {
		long tiempoInicial = System.currentTimeMillis();
		usuarios.forEach(e->convertirMayusculas(e.getNombre()));
		long tiempoFinal = System.currentTimeMillis();
		System.out.println("El tiempo de la operación ha sido: "+(tiempoFinal-tiempoInicial));
		tiempoInicial = System.currentTimeMillis();
		usuarios.parallelStream().forEach(e->convertirMayusculas(e.getNombre()));
		tiempoFinal = System.currentTimeMillis();
		System.out.println("El tiempo de la operación en paralelo ha sido: "+(tiempoFinal-tiempoInicial));
	}
	
	public static String convertirMayusculas(String nombre) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
	
	public static void pruebas() {
    	// poblar();  // Da datos iniciales a la lista
    	// forEach();
    	// filter();
    	// map();
    	// toSet();
    	// sumAvg();
    	// find();
    	// flatMap();
    	// peek();
    	// partitioningBy();
    	// groupingBy();
    	// count();
    	// skipYLimit();
    	// maxMin();
    	// distinct();
    	// summarizingDouble();
    	// reduce();
    	// joining();
    	// parallelStream();
	}
	
    public static void main(String[] args) {
    	// pruebas();
    	// Ejercicios.ejericicio01();
    	// Ejercicios.ejericicio02();
    	// Ejercicios.ejericicio03();
    	Ejercicios.ejericicio04();
    	// Ejercicios.ejericicio05();
    	// Ejercicios.ejericicio06();
    	// Ejercicios.ejericicio07();
    }
}
