import lejos.nxt.Button;
import lejos.nxt.SensorPort;

import java.lang.Object;
import lejos.nxt.I2CSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;
import lejos.nxt.TouchSensor;

public class UltraSound {

	public static void main(String[] args) {
		UltrasonicSensor uS = new UltrasonicSensor(SensorPort.S1);
		TouchSensor tS = new TouchSensor(SensorPort.S2);
		Delay d = new Delay();
		while(!tS.isPressed()){
			System.out.print(uS.getDistance()+": ");
			System.out.println(uS.getUnits());
			d.msDelay(1000);
		}
		System.out.println("Polsat");
		Button.waitForAnyPress();

	}

}





