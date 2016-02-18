package Explorando;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

public class BT {
	private BTConnection btc;
	
	private String connected = "Connected";
	private String waiting = "Waiting...";
	private String closing = "Closing...";
	
	private DataInputStream dis;
	private DataOutputStream dos;
	
	public BT(){
		System.out.println(waiting);
		btc = Bluetooth.waitForConnection();
		System.out.println(connected);
		dis = btc.openDataInputStream();
		dos = btc.openDataOutputStream();
		
	}
	
	public boolean RecibeInit (){
		try {
			String n = dis.readUTF();
			System.out.println(n);
//			return false;
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
	public boolean RecibePush (ArrayList<Posicio> mapa){
		try {
			System.out.println("Entra Push");
			String n ="";
			if(dis.available()!=0){
				n = dis.readUTF();
			}
			System.out.println(n);
			if(n.equals("push")){
				System.out.println("Recibido push");
				
//				dos.writeUTF("xml");
				String s = ("|"+mapa.get(1).x+","+mapa.get(1).y+","+mapa.get(1).estat+"|"+mapa.get(2).x+","+mapa.get(2).y+","+mapa.get(2).estat+"|"+mapa.get(3).x+","+mapa.get(3).y+","+mapa.get(3).estat)+"|"+mapa.get(4).x+","+mapa.get(4).y+","+mapa.get(4).estat+"|";
				dos.writeUTF(s);
				dos.flush();
				dis.close();
				dos.close();
//				Thread.sleep(100); // wait for data to drain
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
