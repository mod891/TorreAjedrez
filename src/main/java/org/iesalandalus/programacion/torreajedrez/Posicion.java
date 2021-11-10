package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	private int fila;
	private char columna;
	
	public Posicion() {
	//	super();
		
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
		if (fila < 1 || fila > 8) {			
			this.fila = fila;
		} else {
			new IllegalArgumentException("EXCEPCION_FILA_INCORRECTA");
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
			new IllegalArgumentException("EXCEPCION_COLUMNA_INCORRECTA");
		}
	}
	
}


