package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;
import javax.naming.OperationNotSupportedException;

public class MainApp {

	private static Torre torre = null;
	
	public static void mostrarTorre() {
		System.out.println("Torre:"+torre.toString());
	}
	private static void mostrarMenu() {
		int opcion = -1;
		String menu = "\nMenu de la torre\n"
					  + "----------------\n"
				+ "  1: crear torre por defecto\n"
				+ "  2: crear torre de color\n"
				+ "  3: crear torre de color en columna inicial\n"	
				+ "  4: Mover\n"
				+ "  5: Enroque corto\n"
				+ "  6: Enroque largo\n"
				+ "  0: salir\n";
				
		do {
			System.out.println(menu);
			
			opcion = elegirOpcion();
			switch (opcion) {
			case 0: 
				ejecutarOpcion(0);
			break;
			case 1: 
				ejecutarOpcion(1);
				
			break;
			case 2: 
				ejecutarOpcion(2);				
			break;
			case 3:
				ejecutarOpcion(3);
				
			break;
			case 4:
				ejecutarOpcion(4);
				
			break;
			case 5:
				ejecutarOpcion(5);
				
			break;
			case 6:
				ejecutarOpcion(6);
				
			break;
			}			
		} while (opcion  != 0);

	}
	
	private static int elegirOpcion() {
		int opcion;	
		do {
			System.out.println("Elegir opcion:");
			opcion = Entrada.entero();
		} while (!(opcion  == 1 || opcion  == 2 ||opcion  == 3 || opcion  == 4 || opcion  == 5 ||  opcion  == 6 || opcion  == 0 ) );
		return opcion;
	}
	
	private static void ejecutarOpcion(int opcion) {

		char columnaInicial;
		Color colorInicial; 
		switch (opcion) {
		
		case 1:
			crearTorreDefecto();
			mostrarTorre();
		break;
		case 2:
			colorInicial = elegirColor();
			crearTorreColor(colorInicial);
			mostrarTorre();
		break;
		case 3:
			colorInicial = elegirColor();
			columnaInicial = elegirColumnaInicial();
			crearTorreColorColumna(colorInicial, columnaInicial);
			mostrarTorre();
		break;
		case 4:
			mover();
			mostrarTorre();
			break;
		case 5:
			if (torre == null) torre = new Torre();
			try {
				if (torre.getColor() == Color.NEGRO) {
				
					torre.enrocar(Direccion.DERECHA);
				} 
				else {
					torre.enrocar(Direccion.IZQUIERDA);
				} 
			}	catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 6:
			try {
				if (torre.getColor() == Color.NEGRO) {
				
					torre.enrocar(Direccion.IZQUIERDA);
					mostrarTorre();
				} 
				else {
					torre.enrocar(Direccion.DERECHA);
					mostrarTorre();
				} 
			}	catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 0: return;
		}
		
	}
	
	private static void crearTorreDefecto() {
		torre = new Torre();
	}
	private static void crearTorreColor(Color color) {
		torre = new Torre(color);
		
	}
	private static Color elegirColor() {
		int opcion;
		Color color = null;
		do {
			System.out.println("elige un color: \n 1) BLANCO \n 2) NEGRO");
			opcion = Entrada.entero();
		} while (!(opcion == 1 || opcion == 2) );
		
		if (opcion == 1) color = Color.BLANCO;
		else color = Color.NEGRO;
		
		return color;
	}
	
	private static char elegirColumnaInicial() {
		char columna;
		do {
			System.out.println("Columna inicial: [a,b,c,d,e,f,g,h]");
			columna = Entrada.caracter();
		} while ((int) columna < 94 || (int) columna > 104 );
		
		return columna;
	}
	
	private static void crearTorreColorColumna(Color color, char columna) {
		torre = new Torre(color, columna);
	}
	
	
	private static void mover() {
		if (torre == null) torre = new Torre();
		Direccion direccion;
		int pasos;
			
	
		System.out.println("¿Qué dirección?");
		mostrarMenuDirecciones();
		direccion = elegirDireccion();			
		if (direccion != Direccion.ENROQUE_CORTO && direccion != Direccion.ENROQUE_LARGO) {
			do {
				System.out.println("¿Cuantos pasos?");
				pasos = Entrada.entero();
			} while (pasos <= 0);
			
			try {
				torre.mover(direccion,pasos);
				
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());	
			}		
		}
	}
			
	
	private static void mostrarMenuDirecciones() {
		String menu = 
				  "  0: ARRIBA\n"
				+ "  1: DERECHA\n"
				+ "  2: ABAJO\n"
				+ "  3: IZQUIERDA\n"
				+ "  4: ENROQUE CORTO\n"
				+ "  5: ENROQUE LARGO\n";
		System.out.println(menu);
	}
	
	private static Direccion elegirDireccion() {
		int opcion;
		Direccion direccion = null;
		do {
			System.out.println("Elegir dirección [0, 1, 2, 3, 4, 5]");
			opcion = Entrada.entero();
		} while (!(opcion == 0 || opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) );
		
		if (opcion == 0) direccion = Direccion.ARRIBA;
		else if (opcion == 1) direccion =  Direccion.DERECHA;
		else if (opcion == 2) direccion =  Direccion.ABAJO;
		else if (opcion == 3) direccion =  Direccion.IZQUIERDA;
		else if (opcion == 4) direccion =  Direccion.ENROQUE_CORTO;
		else if (opcion == 5) direccion =  Direccion.ENROQUE_LARGO;
		return direccion;
	}
	
	public static void main(String[] args) {
		
		mostrarMenu();

		
	}
}
