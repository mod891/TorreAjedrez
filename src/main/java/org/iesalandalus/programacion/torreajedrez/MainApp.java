package org.iesalandalus.programacion.torreajedrez;

public class MainApp {

	public static void main(String[] args) {
		
		Posicion posicion = new Posicion();
		Torre torre = null;//new Torre(); 
		/*
		torre = new Torre(Color.BLANCO); 
		try {
		torre = new Torre(Color.NEGRO); 
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());	}
		System.out.println(torre.toString());
		
		*/
		//public Torre(Color color, char columna) {
		
		try {
			//torre = new Torre(Color.NEGRO,'k');
			torre = new Torre(Color.BLANCO,'b'); 
			torre = new Torre(Color.NEGRO);
//			torre = new Torre(Color.NEGRO,'a'); 
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());	
			}
		System.out.println(torre.toString());
	}

}
