package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	private int fila;
	private char columna;
	
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

	/**
	 * 
	 * @param o objeto a comparar
	 * @return true si el estado interno de o es igual al propio
	 */
	
	@Override 
	// public boolean equals(Posicion o)
	public boolean equals(Object o) { // Object que es superclase de los objetos
		if (o == this) return true; // si es el propio objeto, este es igual a si mismo
		if (!(o instanceof Posicion))// si no son objetos de la misma clase devolver falso y no comparar valor interno 
			return false; 	
		
		Posicion posicion = (Posicion) o;
		return o.getFila() == getFila() // this.getFila() this.fila
				&& o.getColumna() == getColumna();
	
		// https://www.geeksforgeeks.org/overriding-equals-method-in-java/
		// https://mkyong.com/java/java-how-to-overrides-equals-and-hashcode/
		//https://picodotdev.github.io/blog-bitix/2016/12/como-implementar-correctamente-y-por-que-los-metodos-equals-y-hashcode-de-los-objetos-java/
		// equal compara el valor interno de los objetos, el estado de la variables de clase y devuelve true si son iguales
	}
	/**
	 * 
	 */
	@Override
	public int hashCode {
		return hashCode();
	}
		/*
		 En el lenguaje de programación Java un HashCode es un identificador de 32 bits
		  que se almacena en un Hash en la instancia de la clase.
		   Toda clase debe proveer de un método hashCode() que permite recuperar el Hash Code asignado, por defecto, por la clase Object. 
		
		 */
	
	}
}
