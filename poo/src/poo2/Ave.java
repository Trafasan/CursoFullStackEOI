package poo2;

import java.util.Random;

public class Ave extends Animal implements IHablador, IAnidar{
	private boolean puedeVolar;

	public Ave(boolean puedeVolar) {
		super();
		this.puedeVolar = puedeVolar;
	}
	
	public Ave(String nombre, double peso, boolean puedeVolar) {
		super(nombre, peso);
		this.puedeVolar = puedeVolar;
		}

	public boolean isPuedeVolar() {
		return puedeVolar;
	}

	public void setPuedeVolar(boolean puedeVolar) {
		this.puedeVolar = puedeVolar;
	}

	public void ponerHuevos() {
		int numHuevos = new Random().nextInt(6) + 1;
		System.out.printf("He puesto %d huevo"+((numHuevos != 1)?"s":"")+" y peso %.2f kilos.\n", numHuevos, getPeso());
		// System.out.printf("He puesto %d huevos.\n", numHuevos);
	}
	
	@Override
	public void comer() {
		// Definimos que un ave aumenta su peso un 5% siempre al comer
		setPeso(getPeso() * 1.05);
		System.out.printf("Pio pio. He comido y ahora peso %.2f kilos\n", getPeso());
	}
	
	@Override
	public String tipoAnimal() {
		return "Ave";
	}
	
	@Override
	public String rugido() {
		return "Pío Pío";
	}

	@Override
	public void hablar() {
		System.out.println("pio pio");
	}

	@Override
	public void gritar() {
		System.out.println("PIO PIO");
	}
	
	@Override
	public int pollitos(String nombre) {
		if(nombre.equals("Animal desconocido")) {
			return 2;
		} else if(nombre.equals("Gallina")) {
			return 3;
		} else {
			return 4;
		}
	}
}
