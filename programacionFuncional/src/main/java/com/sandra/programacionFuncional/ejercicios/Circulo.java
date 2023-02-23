package com.sandra.programacionFuncional.ejercicios;

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

	@Override
	public String toString() {
		return "Área: "+String.format("%.2f", getArea())+".\tPerímetro: "+String.format("%.2f", getPerimetro())+"\n";
	}

}
