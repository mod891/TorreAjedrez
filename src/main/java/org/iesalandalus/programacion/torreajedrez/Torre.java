package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

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
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
	
			boolean puedeMover = true;
			char nuevaColumna;
			Posicion posActual = getPosicion();
			
			if (pasos > 0) {
				if (direccion != null) {
					
					switch (direccion) {
					
					case ARRIBA:// ^ fila++ max:8
						if (posActual.getFila()+pasos <= 8 ) {
							Posicion nuevaPosicion = new Posicion(posActual.getFila()+pasos,posActual.getColumna());
							setPosicion(nuevaPosicion);
						} else puedeMover = false;
						break;
					case ABAJO: // ↓ fila-- min:1
						if (posActual.getFila()-pasos >= 1 ) {

							Posicion nuevaPosicion = new Posicion(posActual.getFila()-pasos,posActual.getColumna());
							setPosicion(nuevaPosicion);	
						} else puedeMover = false;
						
						break;
					case IZQUIERDA:// min:a ← ←
						if ((int) posActual.getColumna()-pasos >= 97 ) {			
							nuevaColumna = (char) ((int) posActual.getColumna()-pasos);				
							Posicion nuevaPosicion = new Posicion(posActual.getFila(),nuevaColumna);
							setPosicion(nuevaPosicion);
						} else puedeMover = false;
						break;
					case DERECHA: // → → max:h
						if ((int) posActual.getColumna()+pasos <= 104 ) {
							nuevaColumna = (char) ((int) posActual.getColumna()+pasos);						
							Posicion nuevaPosicion = new Posicion(posActual.getFila(),nuevaColumna);
							setPosicion(nuevaPosicion);												
						} else puedeMover = false;
						
						break;
					}
					
					if (!puedeMover) 
						throw new OperationNotSupportedException("la torre se sale del tablero");
			
				} else {
					throw new NullPointerException("direccion es null");
				}
			} else {
				throw new IllegalArgumentException("Los pasos "+pasos+" deben ser positivos");
			}
	}
	// enrocas a la derecha la torre se mueve a la izquierda y viceversa
	public void enrocar(Direccion direccion)  throws OperationNotSupportedException {
		if (direccion == null) 
			throw new NullPointerException("Torre.enrocar:direccion null");
		
		if (getColor() == Color.NEGRO) {
			
			if (direccion == Direccion.DERECHA) {
				if (getPosicion().getFila() == 8 && getPosicion().getColumna() == 'h' )
					mover(Direccion.IZQUIERDA,2);
					
			} else if (direccion == Direccion.IZQUIERDA) {
				if (getPosicion().getFila() == 8 && getPosicion().getColumna() == 'a' )
					mover(Direccion.DERECHA,3);			
			} else {
				throw new OperationNotSupportedException("Movimiento no valido: el enroque es izquierda o derecha");
			}
		
		} else if (getColor() == Color.BLANCO)  {
			
			if (direccion == Direccion.DERECHA) {
				if (getPosicion().getFila() == 1 && getPosicion().getColumna() == 'h' )
					mover(Direccion.IZQUIERDA,2);
					
			} else if (direccion == Direccion.IZQUIERDA) {
				if (getPosicion().getFila() == 1 && getPosicion().getColumna() == 'a' )
					mover(Direccion.DERECHA,3);			
				
			} else {
				throw new OperationNotSupportedException("Movimiento no valido: el enroque es izquierda o derecha");
			}
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}


	@Override
	public String toString() {
		return "Color:"+getColor()+" "+getPosicion().toString(); 
	}
	
	
}

