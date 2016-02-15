package Prova;
import java.io.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;

public class BTReceive {
	 public static void main(String [] args) throws Exception
	 {
	 String connected = "Connected";
	 String waiting = "Waiting...";
	 String closing = "Closing...";
	 
//	 M[0,0]=true;
	 
	 while (true)
	 {
	 LCD.drawString(waiting,0,0);
	 BTConnection btc = Bluetooth.waitForConnection();

	 LCD.clear();
	 LCD.drawString(connected,0,0);
	 DataInputStream dis = btc.openDataInputStream();
	 DataOutputStream dos = btc.openDataOutputStream();

//	 for(int i=0;i<100;i++) {
		 String n = dis.readUTF();
		 LCD.drawString(n, 7, 1);
//		 dos.writeInt(-n);
		 dos.writeInt(42);
		 dos.flush();
//	 }

	 dis.close();
	 dos.close();
	 Thread.sleep(100); // wait for data to drain
	 LCD.clear();
	 LCD.drawString(closing,0,0);
	 btc.close();
	 LCD.clear();
	 }
	 }
	} 

//public class BTReceive {
//  public static void main(String [] args) throws Exception {
//    String connected = "Connected";
//    String waiting = "Waiting...";
//    String closing = "Closing...";
//    TouchSensor tS = new TouchSensor(SensorPort.S1);
//    
//    while (!tS.isPressed()) {
//      LCD.drawString(waiting,0,0);
//      NXTConnection connection = Bluetooth.waitForConnection(); 
//      LCD.clear();
//      LCD.drawString(connected,0,0);
//
//      DataInputStream dis = connection.openDataInputStream();
//      DataOutputStream dos = connection.openDataOutputStream();
//
//      for(int i=0;i<100;i++) {
//        int n = dis.readInt();
//        LCD.drawInt(n,7,0,1);
//        dos.writeInt(-n);
//        dos.flush();
//      }
//      dis.close();
//      dos.close();
//
//      LCD.clear();
//      LCD.drawString(closing,0,0);
//
//      connection.close();
//      LCD.clear();
//    }
//  }
//}