package Explorando;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;
import lejos.nxt.Motor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TouchSensor tS = new TouchSensor(SensorPort.S1);
		
		while(!tS.isPressed()){
			if((Motor.A.getTachoCount() < 360) && (Motor.C.getTachoCount() < 360)){
				Robot.GirarDer();
				System.out.println("A: "+Motor.A.getTachoCount()+"B: "+Motor.C.getTachoCount());
			}
			else{
				Robot.Parar();
				
			}
		}
	}
	

}