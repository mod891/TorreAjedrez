package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	private Color color;
	private Posicion posicion;
	
	public Torre() {
		setPosicion(new Posicion(8,'h'));
		setColor(Color.NEGRO);
	}
	
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
		if (posicion == null)
		 	throw new NullPointerException("Posicion Nula");
		
		// posicion = new Posicion(posicion); cc 
		this.posicion = posicion;
	}
	@Override
	public String toString() {
		return "Color:"+getColor()+" "+getPosicion().toString(); 
	}
	
	
}

