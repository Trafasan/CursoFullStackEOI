package poo2;

public class Persona implements IHablador{
	String nombre;
	
	@Override
	public void hablar() {
		System.out.println("Hola, me llamo " + nombre);
	}
	
	@Override
	public void gritar() {
		System.out.println("HOLA, ME LLAMO " + nombre);
	}
}
