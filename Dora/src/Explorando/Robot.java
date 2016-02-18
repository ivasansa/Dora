package Explorando;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

public class Robot {
	//A = Derecha
	//C = Izquierda
	static DifferentialPilot pilot = new DifferentialPilot(2.5f, 4.4f, Motor.A, Motor.C, true);
	static UltrasonicSensor uS = new UltrasonicSensor(SensorPort.S2);
	public static void Adelante() {
		Motor.A.forward();
		Motor.C.forward();
	}
	public static void Parar() {
//		Motor.A.stop(true);
//		Motor.C.stop(true);
		pilot.stop();
	}
	//180
	public static void GirarIzq() {
//		while((Motor.A.getTachoCount() < 180) && (Motor.C.getTachoCount() > -180)){
//			Motor.A.forward();
//			Motor.C.backward();
//		}
		 pilot.rotate(90);
	}
	public static void GirarDer() {
		if((Motor.A.getTachoCount() < 360) && (Motor.C.getTachoCount() < 360)){
			Motor.A.backward();
			Motor.C.forward();
		}
	}
	public static boolean FrontOcupat(){
		if(uS.getDistance()>44){
			return false;
		}
		else{
			return true;
		}
	}
}
