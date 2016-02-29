package Explorando;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

/**
 * Clase que representa la Conexión Bluetooth entre el Robot y el Ordenador
 * 
 *
 */
public class BT {
	
	private BTConnection btc;
	
	private String connected = "Connected";
	private String waiting = "Waiting...";
	private String closing = "Closing...";
	
	private DataInputStream dis;
	private DataOutputStream dos;
	
	/**
	 * Método Constructor que inicia la conexión y mantiene abierto un canal de datos.
	 */
	public BT(){
		System.out.println(waiting);
		btc = Bluetooth.waitForConnection();
		System.out.println(connected);
		dis = btc.openDataInputStream();
		dos = btc.openDataOutputStream();
		
	}
	
	/**
	 * Método RecibeInit, que registra false cuando se recibe la señal "init" desde el PC 
	 * @return	false: si se recibe "init"
	 * 			true:	si no se recibe "init"  		
	 */
	public boolean RecibeInit() {
		try {
			String n = dis.readUTF();
			if(n.equals("init")){
				System.out.println("Recibido init");
				return false;
			}
			else {
				return true;
			}
		} catch (IOException e) {
			return true;
		}
		
	}
	/**
	 * Método RecibePush, que controla la recepción de la señal "push" desde el PC. Cuando esto ocurre envía al PC una String con la LinkedList mapa parseada en forma de string.
	 * A continuación, cierra la conexión BT con el PC
	 * @param mapa		LinkedList con la información de la ocupación de las casillas colindantes al Robot
	 * @return			true: cuando no se recibe "push"
	 * 					false: cuando se recibe "push"
	 */
	public boolean RecibePush (LinkedList<Posicio> mapa){
		try {
			String n ="";
			if(dis.available()!=0){
				n = dis.readUTF();
			}
			if(n.equals("push")){
				System.out.println("Recibido push");
				
				String s = ("X="+mapa.get(1).x+"&"+"Y="+mapa.get(1).y+"&"+"V="+mapa.get(1).estat+
							"ñ"+"X="+mapa.get(2).x+"&"+"Y="+mapa.get(2).y+"&"+"V="+mapa.get(2).estat+
							"ñ"+"X="+mapa.get(3).x+"&"+"Y="+mapa.get(3).y+"&"+"V="+mapa.get(3).estat+
							"ñ"+"X="+mapa.get(4).x+"&"+"Y="+mapa.get(4).y+"&"+"V="+mapa.get(4).estat+
							"ñ"+"X="+mapa.get(5).x+"&"+"Y="+mapa.get(5).y+"&"+"V="+mapa.get(5).estat+
							"ñ"+"X="+mapa.get(6).x+"&"+"Y="+mapa.get(6).y+"&"+"V="+mapa.get(6).estat+
							"ñ"+"X="+mapa.get(7).x+"&"+"Y="+mapa.get(7).y+"&"+"V="+mapa.get(7).estat+
							"ñ"+"X="+mapa.get(8).x+"&"+"Y="+mapa.get(8).y+"&"+"V="+mapa.get(8).estat+
							"ñ"+"X="+mapa.get(0).x+"&"+"Y="+mapa.get(0).y+"&"+"V="+mapa.get(0).estat
							);
				
				dos.writeUTF(s);
				dos.flush();
				dis.close();
				dos.close();
				System.out.println(closing);
				btc.close();
				return false;
			}
			else {
				return true;
			}
		} catch (IOException e) {
			System.out.println("Excepción");
			return true;
		}
		
	}
}
