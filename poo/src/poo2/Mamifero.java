package poo2;

public class Mamifero extends Animal{
	private boolean carnivoro;
	
	public Mamifero(String nombre, double peso, boolean carnivoro) {
		super(nombre, peso);
		this.carnivoro = carnivoro;
	}
	
	@Override
	public void comer() {
		super.comer();
		System.out.println("He comido: " + (carnivoro ? "carne" : "hierba")+".");
	}
	
	@Override
	public String tipoAnimal() {
		return "Mamífero";
	}
	
	@Override
	public String rugido() {
		return "Grrruuuuuaaa";
	}
}
