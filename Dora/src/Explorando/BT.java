package Explorando;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.LinkedList;

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
	 * 
	 * @param mapa
	 * @return
	 */
	public boolean RecibePush (LinkedList<Posicio> mapa){
		try {
			String n ="";
			if(dis.available()!=0){
				n = dis.readUTF();
			}
			if(n.equals("push")){
				System.out.println("Recibido push");
				
//				dos.writeUTF("xml");
//				String s = ("|"+mapa.get(1).x+","+mapa.get(1).y+","+mapa.get(1).estat+"|"+mapa.get(2).x+","+mapa.get(2).y+","+mapa.get(2).estat+"|"+mapa.get(3).x+","+mapa.get(3).y+","+mapa.get(3).estat)+"|"+mapa.get(4).x+","+mapa.get(4).y+","+mapa.get(4).estat+"|";
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
