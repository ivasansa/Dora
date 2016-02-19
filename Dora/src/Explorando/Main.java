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
		 
		TouchSensor tS = new TouchSensor(SensorPort.S1);
		Delay d = new Delay();
		int x=0, y=0;
		int estat;
		ArrayList<Posicio> mapa = new ArrayList<>();
			BT bt = new BT();
			int entrat = 0;
			while(bt.RecibeInit()){
			
			}
//			Caca = tu
//			01 = ocupat
//			01=true&
			while(bt.RecibePush(mapa)){
				mapa.add(new Posicio(0,0,0)); //Posem la posició actual del robot com a 
				
				if(entrat == 0){
				for(int i = 1; i <= 4; i++){
					switch (i) {
					case 1:
						x=1;
						y=0;
						break;
					case 2:
						x=0;
						y=1;
						break;
					case 3:
						x=1;
						y=0;
						break;
					case 4:
						x=2;
						y=1;
						break;
					default:
						break;
					}
					estat = Robot.FrontOcupat();
//					System.out.println(estat);
					mapa.add(new Posicio(x, y, Robot.FrontOcupat()));
					
					
					Robot.GirarIzq();
					Robot.Parar();
					entrat = 1;
				}
				}
			}
			
			Robot.Parar();
			Button.waitForAnyPress();
		
	}
	

}
