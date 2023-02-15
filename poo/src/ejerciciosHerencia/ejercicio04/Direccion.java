package ejerciciosHerencia.ejercicio04;

public class Direccion {
	private String nombre_calle;
	private int numero;
	
	public Direccion() {
		
	}

	public Direccion(String nombre_calle, int numero) {
		super();
		this.nombre_calle = nombre_calle;
		this.numero = numero;
	}
	
	public Direccion(Direccion d) {
		super();
		this.nombre_calle = d.nombre_calle;
		this.numero = d.numero;
	}

	public String getNombre_calle() {
		return nombre_calle;
	}

	public void setNombre_calle(String nombre_calle) {
		this.nombre_calle = nombre_calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Nombre de la calle: "+nombre_calle+"\nNúmero: "+numero;
	}
	
	
}
