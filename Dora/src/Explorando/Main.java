package Explorando;

import lejos.nxt.Button;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clase Main, que efectúa la ejecución del Robot
 */
public class Main {
	
	public static void main(String[] args) {
		int x=0, y=0;
		LinkedList<Posicio> mapa = new LinkedList<>();
			BT bt = new BT();
			int entrat = 0;
			
			/**
			 * Función que mantiene el Robot en standby hasta que se recibe desde el PC una señal 
			 * de inicio "init"
			 */
			while(bt.RecibeInit()){}

			/**
			 * Funcionamiento lógico del Robot que se ejecuta cuando se recibe un init.
			 */
			while(bt.RecibePush(mapa)){
				mapa.add(new Posicio(1,1,0)); //Posem la posició actual del robot com a 
				Queue<Integer> q = new Queue<Integer>();
				
				/**
				 * Sólo queremos entrar en el modo de giro 1 vez
				 */
				if(entrat == 0){
					/**
					 * Bucle que gira el robot 8 veces
					 */
					for(int i = 1; i <= 8; i++){
						/**
						 * Bloque que mapea la posición de enfrente del Robot
						 */
						try {
							q = Robot.parsePosicion(i);
						} catch (ParseException e) {
							System.out.println(e.getMessage());
						}
						
						x = (int) q.pop();
						y = (int) q.pop();
						mapa.add(new Posicio(x, y, Robot.FrontOcupat()));
						
						/**
						 * Giramos el robot
						 */
						Robot.Girar(45);
						Robot.Parar();
						
						/**
						 * Flag para evitar que el robot gire más de 8 veces
						 */
						entrat = 1;
						
						/**
						 * Reseteamos la cola del parsing
						 */
						q.clear();
					}
				}
			}
			
			Robot.Parar();
			Button.waitForAnyPress();
		
	}
	

}
