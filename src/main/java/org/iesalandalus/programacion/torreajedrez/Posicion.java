package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {
	private int fila;
	private char columna;
	private static final int ASCII_A = 97;
	private static final int ASCII_H = 104;
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

	}
	public Posicion(int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	public Posicion(Posicion posicion) {
		if (posicion == null) throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
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
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}
	}
	public char getColumna() {
		return columna;
	}
	public void setColumna(char columna) {
		int asciiVal = (int) columna;
		
		if (!(asciiVal < ASCII_A || asciiVal > ASCII_H)) {
			this.columna = columna;
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
	}
	
	@Override
	public String toString() {
		return "fila="+getFila()+", columna="+getColumna();
		
	}
}


