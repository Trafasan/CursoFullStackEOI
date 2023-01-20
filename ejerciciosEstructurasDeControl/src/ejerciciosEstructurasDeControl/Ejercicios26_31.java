/**
 * 
 */
package ejerciciosEstructurasDeControl;

import java.util.Scanner;

/**
 * @author Sandra
 *
 */
public class Ejercicios26_31 {
	public static void ejercicio26() {
		// Haz lo mismo pero con una escalera de subida (para generar los huecos debes escribir el carácter de espacio).
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca un número: ");
		int n = sc.nextInt();
		for (int x=1; x<=n; x++) {
			for (int y=n; y>x; y--) {
				System.out.print(' ');
			}
			for (int z=x; z>0; z--) {
				System.out.print('#');
			}
			System.out.print("\n");
		}
		sc.close();
	}

	public static void ejercicio27() {
		// Pide al usuario un ancho y un alto y dibuja un rectángulo vacío.
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el ancho: ");
		int ancho = sc.nextInt();
		System.out.print("Introduzca el alto: ");
		int alto = sc.nextInt();
		for (int x=1; x<=alto; x++) {
			if (x == 1 || x == alto) {
				for (int y=0; y<ancho; y++) {
					System.out.print('#');
				}
			}
			else {
				int vacio = ancho-2;
				System.out.print('#');
				for (int z=0; z<vacio; z++) {
					System.out.print(' ');
				}
				System.out.print('#');
			}
			System.out.print("\n");
		}
		sc.close();
	}

	public static void ejercicio28() {
		/*
		 * Pide al usuario un número que será la altura de una pirámide. Dibuja una pirámide con asteriscos con dicha altura.
		 * Pista: El ancho (base) de la pirámide será: (altura * 2 – 1), y la posición del primer asterisco será el
		 * mismo que la altura si empiezas el bucle en 1 (o una menos si lo quieres empezar en 0).
		 * Crea 2 variables auxiliares con la posición del primer asterisco, una la irás decrementando y otra incrementando.
		 * Si la posición actual está entre esas 2 variables dibujas un asterisco, y si no, un espacio.
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la altura: ");
		int altura = sc.nextInt();
		int ancho = altura*2-1;
		int asterisco = 1;	
		for (int x=1; x<=altura; x++) {
			int espacio = (ancho-asterisco)/2;
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			for (int z=0; z<asterisco; z++) {
				System.out.print('#');
			}
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			asterisco += 2;
			System.out.print("\n");
		}
		sc.close();
	}

	public static void ejercicio29() {
		// Intenta hacer lo mismo pero con una pirámide hueca
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la altura: ");
		int altura = sc.nextInt();
		int ancho = altura*2-1;
		int asterisco = 1;	
		for (int x=1; x<=altura; x++) {
			int espacio = (ancho-asterisco)/2;
			if (x==1) {
				for (int y=0; y<espacio; y++) {
					System.out.print(' ');
				}
				for (int z=0; z<asterisco; z++) {
					System.out.print('#');
				}
				for (int y=0; y<espacio; y++) {
					System.out.print(' ');
				}
			}
			else if (x==altura) {
				for (int z=0; z<asterisco; z++) {
					System.out.print('#');
				}
			}
			else {
				int hueco = asterisco - 2;
				for (int y=0; y<espacio; y++) {
					System.out.print(' ');
				}
				System.out.print('#');
				for (int z=0; z<hueco; z++) {
					System.out.print(' ');
				}
				System.out.print('#');
				for (int y=0; y<espacio; y++) {
					System.out.print(' ');
				}
			}
			asterisco += 2;
			System.out.print("\n");
		}
		sc.close();
	}

	public static void ejercicio30() {
		// Dibuja ahora una pirámide invertida
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca la altura: ");
		int altura = sc.nextInt();
		int ancho = altura*2-1;
		int asterisco = ancho;	
		for (int x=altura; x>=1; x--) {
			int espacio = (ancho-asterisco)/2;
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			for (int z=0; z<asterisco; z++) {
				System.out.print('#');
			}
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			asterisco -= 2;
			System.out.print("\n");
		}
		sc.close();
	}
	
	public static void ejercicio31() {
		/*
		 * Ahora dibuja un rombo (puedes dibujar una pirámide y posteriormente una pirámide invertida).
		 * Pide al usuario el ancho del rombo, que deberá ser un número impar (sigue pidiéndole un número hasta que introduzca uno impar).
		 * Si quieres hacerlo con 2 pirámides, la altura de la primera sería (ancho + 1) / 2
		 */
		Scanner sc = new Scanner(System.in);
		System.out.print("Introduzca el ancho: ");
		int ancho = sc.nextInt();
		int altura = (ancho+1)/2;
		int asterisco = 1;	
		for (int x=1; x<altura; x++) {
			int espacio = (ancho-asterisco)/2;
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			for (int z=0; z<asterisco; z++) {
				System.out.print('#');
			}
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			asterisco += 2;
			System.out.print("\n");
		}
		for (int x=altura; x>=1; x--) {
			int espacio = (ancho-asterisco)/2;
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			for (int z=0; z<asterisco; z++) {
				System.out.print('#');
			}
			for (int y=0; y<espacio; y++) {
				System.out.print(' ');
			}
			asterisco -= 2;
			System.out.print("\n");
		}
		sc.close();
	}

	public static void main(String[] args) {
		// ejercicio26();
		// ejercicio27();
		// ejercicio28();
		// ejercicio29();
		// ejercicio30();
		ejercicio31();
	}

}
