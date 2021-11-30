package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

import javax.naming.OperationNotSupportedException;

import org.apache.commons.math3.exception.NullArgumentException;

public class Torre {


	
	private Color color;
	private Posicion posicion;
	
	public Torre() {
		
		setPosicion(new Posicion(8,'h'));
		setColor(Color.NEGRO);
	}
/*	
	public Torre(Torre torre) {
		if (torre == null) 
			throw new NullPointerException("Error: torre es nulo");
		
		setPosicion(torre.getPosicion());
		setColor(torre.getColor());
	}*/
	
	
	public Torre(Color color) {
		
		setColor(color);
		if (color == Color.BLANCO)
			setPosicion(new Posicion(1,'h'));
		else 
			setPosicion(new Posicion(8,'h'));
	}

		 
	public Torre(Color color, char columna) {
		
		
		setColor(color);
		
		Posicion posicion = null;
		
		if (!((int) columna < 97 || (int) columna > 104)) {
			if (color == Color.BLANCO) {
				posicion = new Posicion(1,columna);	
			} else {
				posicion = new Posicion(8,columna);	
			}
			
			setPosicion(posicion);
			
		} else { 
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}		
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		if (color == null)
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
		this.color = color;
	}
	public Posicion getPosicion() {
		return  new Posicion(posicion);
	}
	public void setPosicion(Posicion posicion) {
		
		if (posicion == null)
		 	throw new NullPointerException("Posicion Nula");
			this.posicion = new Posicion(posicion);
	}
	public void mover(Direccion direccion, int pasos) throws OperationNotSupportedException {
	
			boolean puedeMover = true;
			char nuevaColumna;
			Posicion posActual = getPosicion();
			
			if (pasos > 0) {
				if (direccion != null) {
					
					//    ↓   ^   →   ←
					// B  -   +   -   +  
					// N  +   -   +   -   
					
					switch (direccion) {
					
					case ARRIBA:
						if (getColor() == Color.BLANCO) {
							
							if (posActual.getFila() + pasos <= 8 ) {
								Posicion nuevaPosicion = new Posicion(posActual.getFila() + pasos,posActual.getColumna());
								setPosicion(nuevaPosicion);
							} else puedeMover = false;
						} else if (getColor() == Color.NEGRO) {
							
							if (posActual.getFila() - pasos >= 1 ) {
								Posicion nuevaPosicion = new Posicion(posActual.getFila() - pasos,posActual.getColumna());
								setPosicion(nuevaPosicion);
							} else puedeMover = false;
						}
						break;
						
					case ABAJO: 
						if (getColor() == Color.BLANCO) {
							
							if (posActual.getFila() - pasos >= 1 ) {
								Posicion nuevaPosicion = new Posicion(posActual.getFila() - pasos,posActual.getColumna());
								setPosicion(nuevaPosicion);	
							} else puedeMover = false;
						} else if (getColor() == Color.NEGRO) {
							
							if (posActual.getFila() + pasos <= 8 ) {
								Posicion nuevaPosicion = new Posicion(posActual.getFila() + pasos,posActual.getColumna());
								setPosicion(nuevaPosicion);
							}
						}
						break;
						
					case IZQUIERDA:
						if (getColor() == Color.BLANCO) {
							
							if ((int) posActual.getColumna() - pasos >= 97 ) {			
								nuevaColumna = (char) ((int) posActual.getColumna() - pasos);				
								Posicion nuevaPosicion = new Posicion(posActual.getFila(),nuevaColumna);
								setPosicion(nuevaPosicion);
							} else puedeMover = false;
						} else if (getColor() == Color.NEGRO) {
							
							if ((int) posActual.getColumna() + pasos <= 104 ) {			
								nuevaColumna = (char) ((int) posActual.getColumna() + pasos);				
								Posicion nuevaPosicion = new Posicion(posActual.getFila(),nuevaColumna);
								setPosicion(nuevaPosicion);
							} else puedeMover = false;		
						} 
						break;
						
					case DERECHA: 
						if (getColor() == Color.BLANCO) {
							
							if ((int) posActual.getColumna() + pasos <= 104 ) {
								nuevaColumna = (char) ((int) posActual.getColumna() + pasos);						
								Posicion nuevaPosicion = new Posicion(posActual.getFila(),nuevaColumna);
								setPosicion(nuevaPosicion);												
							} else puedeMover = false;
						} else if (getColor() == Color.NEGRO) {
							
							if ((int) posActual.getColumna() - pasos >= 97 ) {			
								nuevaColumna = (char) ((int) posActual.getColumna() - pasos);				
								Posicion nuevaPosicion = new Posicion(posActual.getFila(),nuevaColumna);
								setPosicion(nuevaPosicion);
							} else puedeMover = false;
						}
						break;
					case ENROQUE_LARGO: 
						if (getColor() == Color.NEGRO) {
							enrocar(Direccion.IZQUIERDA);
						} else {
							enrocar(Direccion.DERECHA);
						}
						break;

					case ENROQUE_CORTO: 
						if (getColor() == Color.NEGRO) {
							enrocar(Direccion.DERECHA);
						} else {
							enrocar(Direccion.IZQUIERDA);
						}
						break;
					}
					
					if (!puedeMover) 
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");					
			
				} else {
					throw new NullPointerException("ERROR: La dirección no puede ser nula.");
				}
			} else {
				throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
			}
	}
	// enrocas a la derecha la torre se mueve a la izquierda y viceversa
	public void enrocar(Direccion direccion)  throws OperationNotSupportedException {
		if (direccion == null) 
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		
		if (getColor() == Color.NEGRO) {
			
			if (direccion == Direccion.DERECHA) {
				if (getPosicion().getFila() == 8 && getPosicion().getColumna() == 'h' )
					mover(Direccion.IZQUIERDA,2);
					
			} else if (direccion == Direccion.IZQUIERDA) {
				if (getPosicion().getFila() == 8 && getPosicion().getColumna() == 'a' )
					mover(Direccion.DERECHA,3);			
			} else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
			}
		
		} else if (getColor() == Color.BLANCO)  {
			
			if (direccion == Direccion.DERECHA) {
				if (getPosicion().getFila() == 1 && getPosicion().getColumna() == 'h' )
					mover(Direccion.IZQUIERDA,2);
					
			} else if (direccion == Direccion.IZQUIERDA) {
				if (getPosicion().getFila() == 1 && getPosicion().getColumna() == 'a' )
					mover(Direccion.DERECHA,3);			
				
			} else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
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
		return getPosicion().toString()+", color="+getColor(); 
	}
	
	
}

