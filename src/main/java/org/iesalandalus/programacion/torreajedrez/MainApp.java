package org.iesalandalus.programacion.torreajedrez;

public class MainApp {

	public static void main(String[] args) {
		
		Posicion posicion = new Posicion();
		Torre torre = new Torre(); 
		torre = new Torre(Color.BLANCO); 
		torre = new Torre(Color.NEGRO); 
		System.out.println(torre.toString());
	}

}
