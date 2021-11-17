package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import javax.naming.OperationNotSupportedException;

public class MainApp {

	private static Torre torre = null;
	


	
	public static void mostrarTorre() {
		System.out.println("Torre:"+torre.toString());
	}
	private static void mostrarMenu() {
		int opcion = -1;
		char columnaInicial;
		Color colorInicial; 
		String menu = "Menu de la torre\n"
					+ "----------------\n"
				+ "  1: crear torre por defecto\n"
				+ "  2: crear torre de color\n"
				+ "  3: Mover\n"
				+ "  0: salir\n";
				
		do {
			System.out.println(menu);
			opcion = elegirOpcion();
			switch (opcion) {
			case 0: return;
			case 1: 
				crearTorreDefecto();
				mostrarTorre();
			break;
			case 2: 
				colorInicial = elegirColor();
				columnaInicial = elegirColumnaInicial();
				crearTorreColorColumna(colorInicial, columnaInicial);
				mostrarTorre();
			break;
			case 3: mover();
			break;
			
			}
		//	if (opcion==0) return; 
			
		} while (opcion  != 0);
//		elegirOpcion();
	}
	
	private static int elegirOpcion() {
		int opcion;	
		do {
			System.out.println("Elegir opcion:");
			opcion = Entrada.entero();
		} while (!(opcion  == 1 || opcion  == 2 ||opcion  == 3 || opcion  == 0) );
		return opcion;
	}
	
	private static void ejecutarOpcion(int opcion) {
		
	}
	
	private static void crearTorreDefecto() {
		torre = new Torre();
	}
	private static void crearTorreColor(Color color) {
		// menu elegir color?
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
		int direccion, pasos;
		
	
		//validacion
		System.out.println("¿Qué dirección?");
		mostrarMenuDirecciones();
		direccion = Entrada.entero();
		//validacion
		System.out.println("¿Cuantos pasos?");
		pasos = Entrada.entero();
		

		try {
			if (direccion == 0) {
				torre.mover(Direccion.ARRIBA,pasos);
			} else if (direccion == 1) {
				torre.mover(Direccion.DERECHA,pasos);
			} else if (direccion == 2) {
				torre.mover(Direccion.ABAJO,pasos);
			} else if (direccion == 3) {
				torre.mover(Direccion.IZQUIERDA,pasos);
			}
			System.out.println("\n------------------\nTorre:"+torre.toString());
			
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());	
		}		
	}
	
	private static void mostrarMenuDirecciones() {
		String menu = 
				  "  0: ARRIBA\n"
				+ "  1: DERECHA\n"
				+ "  2: ABAJO\n"
				+ "  3: IZQUIERDA\n";
		System.out.println(menu);
	}
	
	private static Direccion elegirDireccion() {
		int opcion;
		Direccion direccion = null;
		do {
			System.out.println("Elegir dirección [1, 2, 3, 4]");
			opcion = Entrada.entero();
		} while (!(opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4) );
		
		if (opcion == 1) direccion = Direccion.ARRIBA;
		else if (opcion == 2) direccion =  Direccion.ABAJO;
		else if (opcion == 3) direccion =  Direccion.IZQUIERDA;
		else if (opcion == 4) direccion =  Direccion.DERECHA;
		return direccion;
	}
	
	public static void main(String[] args) {
		Torre torreBlanca = new Torre(Color.BLANCO); // 1h
		Torre torreNegra = new Torre(Color.NEGRO); 
		//System.out.println(torreBlanca.toString()); 
		System.out.println(torreNegra.toString()); // 8h
		try {
			/*
			torreBlanca.mover(Direccion.ARRIBA, 2); // 1h → 3h
			System.out.println(torreBlanca.toString()); 
			torreBlanca.mover(Direccion.ARRIBA, 5); //3h → 8h
			System.out.println(torreBlanca.toString()); 
			torreBlanca.mover(Direccion.IZQUIERDA, 4);//8h → 8d
			System.out.println(torreBlanca.toString()); 
			torreBlanca.mover(Direccion.ABAJO, 3); // 8d → 5d
			System.out.println(torreBlanca.toString()); 
			torreBlanca.mover(Direccion.DERECHA, 1);  //5d  → 5e
			System.out.println(torreBlanca.toString()); 
			*/
			
			torreNegra.mover(Direccion.ARRIBA, 4);
			System.out.println(torreNegra.toString()); 
			torreNegra.mover(Direccion.ABAJO, 1);
			System.out.println(torreNegra.toString()); 
			torreNegra.mover(Direccion.DERECHA, 2);
			System.out.println(torreNegra.toString()); 
			torreNegra.mover(Direccion.ARRIBA, 2);
			System.out.println(torreNegra.toString()); 
			torreNegra.mover(Direccion.IZQUIERDA, 2);
			System.out.println(torreNegra.toString()); 
			
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage() );
		}
	//	mostrarMenu();
		
		
		/*
		Posicion posicion = new Posicion();
		Torre torre1, torre2 ;//new Torre(); 

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
		*/
//		elegirOpcion();
//		mostrarMenuDirecciones();
//		System.out.println(elegirDireccion());
		
	}
}
