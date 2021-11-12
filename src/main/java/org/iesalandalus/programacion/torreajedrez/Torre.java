package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	private Color color;
	private Posicion posicion;
	
	public Torre() {}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Posicion getPosicion() {
		return posicion;
	}
	public void setPosicion(Posicion posicion) {
		//if null 	NullPointerException + mover
		this.posicion = posicion;
	}
	
	
}

