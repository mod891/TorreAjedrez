package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	private Color color;
	private Posicion posicion;
	
	public Torre() {
		setPosicion(new Posicion(8,'h'));
		setColor(Color.NEGRO);
	}
	public Torre(Torre torre) {
		if (torre == null) throw new NullPointerException();
		setPosicion(torre.getPosicion());
		setColor(torre.getColor());
	}
	public Torre(Color color) {
		setColor(color);
		if (color == Color.BLANCO)
			setPosicion(new Posicion(1,'h'));
		else
			setPosicion(new Posicion(8,'h'));
	}
//________________
	public Torre(Color color, char columna) throws IllegalArgumentException {
		
		if (color == null) throw new NullPointerException();
		else setColor(color);
		
		Posicion posicion = null;
		
		if (!((int) columna < 97 || (int) columna > 104)) {
			if (color == color.BLANCO) {
				posicion = new Posicion(1,columna);	
			} else {
				posicion = new Posicion(8,columna);	
			}
			// creará una torre del color dado y colocado en dicha columna
			
			setPosicion(posicion);
			
		} else { 
			throw new IllegalArgumentException("columna '"+columna+"' fuera de rango");
		}
		
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

