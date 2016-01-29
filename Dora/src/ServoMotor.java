
	import lejos.nxt.Button;
	import lejos.nxt.SensorPort;

	import java.lang.Object;
	import lejos.nxt.I2CSensor;
	import lejos.nxt.UltrasonicSensor;
	import lejos.util.Delay;
	import lejos.nxt.TouchSensor;
	import lejos.nxt.Motor;
	
	public class ServoMotor {

		public static void main(String[] args) {
			UltrasonicSensor uS = new UltrasonicSensor(SensorPort.S1);
			TouchSensor tS = new TouchSensor(SensorPort.S2);
			ServoMotor m = new ServoMotor();
			
			
			

				
			while(!tS.isPressed()){
				//System.out.print(uS.getDistance()+": ");
				//System.out.println(uS.getUnits());


				if(Button.LEFT.isDown()){
					//Motor.A.backward();
					Motor.A.rotate(-90);
					
				}
				if(Button.RIGHT.isDown()){
					//Motor.A.forward();
					Motor.A.rotate(90);
				}
				
			}
			
			System.out.println(Motor.A.getTachoCount());
			Button.waitForAnyPress();
		}

	}





