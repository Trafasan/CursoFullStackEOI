package ejerciciosHerencia.ejercicio06;

public class Circulo implements IFigura{
	private double radio;
	
	public Circulo() {
		
	}
	
	public Circulo(double radio) {
		this.radio = radio;
	}
	
	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	@Override
	public double getPerimetro() {
		return 2*Math.PI*radio;
	}

	@Override
	public double getArea() {
		return Math.PI*Math.pow(radio, 2);
	}

}
