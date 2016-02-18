package Explorando;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import lejos.nxt.UltrasonicSensor;
import lejos.util.Delay;
import lejos.nxt.Button;
import lejos.nxt.Motor;
import Prova.BTReceive;
import Prova.button;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		TouchSensor tS = new TouchSensor(SensorPort.S1);
		Delay d = new Delay();
		int x=0, y=0;
		boolean estat;
		ArrayList<Posicio> mapa = new ArrayList<>();
			BT bt = new BT();
			boolean entrat = false;
			while(bt.RecibeInit()){
			
			}
			
			while(bt.RecibePush(mapa)){
				mapa.add(new Posicio(0,0,false)); //pos del robot
				
				if(!entrat){
				for(int i = 1; i <= 4; i++){
					switch (i) {
					case 1:
						x=0;
						y=1;
						break;
					case 2:
						x=-1;
						y=0;
						break;
					case 3:
						x=0;
						y=-1;
						break;
					case 4:
						x=1;
						y=0;
						break;
					default:
						break;
					}
					estat = Robot.FrontOcupat();
					mapa.add(new Posicio(x, y, Robot.FrontOcupat()));
					
//					System.out.println("i: "+i+" A: "+Motor.A.getTachoCount()+" C: "+Motor.C.getTachoCount());
					
					Robot.GirarIzq();
					Robot.Parar();
					entrat = true;
				}
				}
//				break;
			}
			
			Robot.Parar();
			Button.waitForAnyPress();
		
//		while(!tS.isPressed()){
//			if((Motor.A.getTachoCount() < 360) && (Motor.C.getTachoCount() < 360)){
//				Robot.GirarDer();
//				System.out.println("A: "+Motor.A.getTachoCount()+"B: "+Motor.C.getTachoCount());
//			}
//			else{
//				Robot.Parar();
//				
//			}
//		}
	}
	

}
