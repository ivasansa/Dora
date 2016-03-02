package Explorando;

import java.util.Queue;

import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;

/**
* Clase Piloto que maneja las acciones del Robot: Parar, GirarIzq y FrontOcupat
* El ServoMotor A corresponde a la rueda Derecha y el ServoMotor C a la rueda Izquierda
*/
public class Robot {
	/**
	 * Declaración de un DiferentialPilot, que contiene las implementaciones de girar y parar; y el Sensor de Ultrasonidos
	 */
	static DifferentialPilot pilot = new DifferentialPilot(2.5f, 4.4f, Motor.A, Motor.C, true);
	static UltrasonicSensor uS = new UltrasonicSensor(SensorPort.S2);

	/**
	 * Método Parar(), que para el Robot
	 */
	public static void Parar() {
		pilot.stop();
	}

	/**
	 * Método Girar, que hace girar
	 * @param n 	Número de grados a mover. Números positivos giran hacia la izquierda, números negativos hacia la derecha
	 */
	public static void Girar(int n) {
		pilot.rotate(n);
	}
	
	/**
	 * Método FrontOcupat, que mira si la posición de delante del robot está ocupada o no
	 * @return 		0: Si la posición está libre
	 * 				1: Si la posición está ocupada 
	 */
	public static int FrontOcupat(){
		if(uS.getDistance()>44){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	/**
	 * Método parsePosicion, que obtiene las coordenadas de la posición que a la que está apuntando el Robot
	 * @param i		Número de giro
	 * @return		q, que es una Queue con la coordenada x,y
	 */
	public static Queue<Integer> parsePosicion(int i) throws ParseException {
		int x=0,y=0;
		Queue<Integer> q = new Queue<Integer>();
		
		switch (i) {
		case 1:
			x=1;
			y=0;
			break;
		case 2:
			x=0;
			y=0;
			break;
		case 3:
			x=0;
			y=1;
			break;
		case 4:
			x=0;
			y=2;
			break;
		case 5:
			x=1;
			y=2;
			break;
		case 6:
			x=2;
			y=2;
			break;
		case 7:
			x=2;
			y=1;
			break;
		case 8:
			x=2;
			y=0;
			break;
		default:
			throw new ParseException("Error en el Parsing");
		}
		
		q.addElement(x);
		q.addElement(y);
		return q; 
	}
}
