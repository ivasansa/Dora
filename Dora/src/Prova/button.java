package Prova;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;

import java.lang.Object;
import lejos.nxt.TouchSensor;


public class button {

	public static void main(String[] args) {
		TouchSensor tS = new TouchSensor(SensorPort.S1);
		while(!tS.isPressed()){
			System.out.println("No polsat");
			
		}
		System.out.println("Polsat");
		Button.waitForAnyPress();
	}

}
