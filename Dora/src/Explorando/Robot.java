package Explorando;

import lejos.nxt.Motor;

public class Robot {
	//A = Derecha
	//C = Izquierda
	public static void Adelante() {
		Motor.A.forward();
		Motor.C.forward();
		
	}
	
	public static void Parar() {
		Motor.A.stop(true);
		Motor.C.stop(true);
		
	}
	
	
	//180
	public static void GirarIzq() {
		Motor.A.forward();
		Motor.C.backward();
		
	}
	public static void GirarDer() {
		Motor.A.backward();
		Motor.C.forward();
		
	}
	
}
