package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {
	private int fila;
	private char columna;
	
	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	public Posicion() {
		super();
	}
	
	/*
	 
	 */
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	public Posicion(Posicion posicion) {
		setFila(posicion.getFila());
		setColumna(posicion.getColumna());
	}
	
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		if (!(fila < 1 || fila > 8)) {		
			this.fila = fila;
		} else {
			throw new IllegalArgumentException("EXCEPCION_FILA_INCORRECTA");
		}
	}
	public char getColumna() {
		return columna;
	}
	public void setColumna(char columna) {
		int asciiVal = (int) columna;
		if (!(asciiVal < 98 || asciiVal > 105)) {
			this.columna = columna;
		} else {
			throw new IllegalArgumentException("EXCEPCION_COLUMNA_INCORRECTA");
		}
	}
	
	@Override
	public String toString() {
		return "fila="+getFila()+", columna="+getColumna();
		
	}
}


