package Explorando;

import lejos.nxt.Button;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static void main(String[] args) {
		int x=0, y=0;
		LinkedList<Posicio> mapa = new LinkedList<>();
			BT bt = new BT();
			int entrat = 0;
			while(bt.RecibeInit()){}

			while(bt.RecibePush(mapa)){
				mapa.add(new Posicio(1,1,0)); //Posem la posició actual del robot com a 
				Queue<Integer> q = new Queue<Integer>();
				if(entrat == 0){
				for(int i = 1; i <= 8; i++){
					q = Robot.parsePosicion(i);
					x = (int) q.pop();
					y = (int) q.pop();
					mapa.add(new Posicio(x, y, Robot.FrontOcupat()));
					
					Robot.Girar(45);
					Robot.Parar();
					entrat = 1;
					q.clear();
				}
				}
			}
			
			Robot.Parar();
			Button.waitForAnyPress();
		
	}
	

}
