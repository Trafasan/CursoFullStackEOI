/**
 * 
 */
package ejerciciosTiposDeDatosBásicos;

/**
 * @author Sandra
 *
 */
public class Ejercicio4 {

	public static void main(String[] args) {
		/*
		 * Crea 4 variables de tipo double con los valores que quieras. A continuación muestra sus valores por consola usando 4 instrucciones para imprimir por
		 * consola y sin generar ningún salto de línea (todos los valores se verán en una sola línea)
		 * A continuación, muestra el resultado de sumar las 2 primeras variables, multiplicar el resultado por la tercera y dividir por la cuarta.
		 * Pista: la suma tiene menos prioridad que la multiplicación, por lo que necesitarás agrupar dicha operación entre paréntesis.
		 */
		double n1 = 7.01, n2 = 5.63, n3 = 2.49, n4 = 1.84;
		System.out.print(n1+" ");
		System.out.print(n2+" ");
		System.out.print(n3+" ");
		System.out.print(n4+"\n");
		double resultado = (n1+n2)*n3/n4;
		System.out.println("("+n1+" + "+n2+") · "+n3+" / "+n4+" = "+resultado);
	}

}
