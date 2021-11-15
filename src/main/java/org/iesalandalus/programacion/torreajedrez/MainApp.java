package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

public class MainApp {

	public static void main(String[] args) {
		
		Posicion posicion = new Posicion();
		Torre torre1, torre2 ;//new Torre(); 
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
//			torre = new Torre(Color.NEGRO,'a'); 
			torre1 = new Torre(Color.NEGRO);
	//		System.out.println(torre1.toString());
			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());	
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());				
		}
		
		
		try {
			torre2 = new Torre(Color.BLANCO,'a'); 
			System.out.println(torre2.toString());
	
			// torre2.mover(Direccion.IZQUIERDA, 1); a-1 err ←
			// torre2.mover(Direccion.DERECHA, 8); // H+1 err →
			// torre2.mover(Direccion.ARRIBA, 8); // 8+1 err ^
			// torre2.mover(Direccion.ABAJO, 1); //  1-1 err ↓
			torre2.mover(Direccion.ARRIBA, 7); 
			
			System.out.println(torre2.toString());
			//System.out.println(torre2.toString());
			//torre2.mover(Direccion.IZQUIERDA, 1);
			//System.out.println(torre2.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());	
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());				
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());		
		}
		
		
	}
}
