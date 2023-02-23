package com.sandra.programacionFuncional.ejercicios;

public class Cuadrado implements IFigura{
	private double lado;
	
	public Cuadrado() {
		
	}

	public Cuadrado(double lado) {
		this.lado = lado;
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	@Override
	public double getPerimetro() {
		return lado*4;
	}

	@Override
	public double getArea() {
		return Math.pow(lado, 2);
		
	}

	@Override
	public String toString() {
		return "Área: "+String.format("%.0f", getArea())+".\tPerímetro: "+String.format("%.0f", getPerimetro())+"\n";
	}

}
