package server;

import interfaceRMI.ChatRoomInterface;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {
	    try {
			LocateRegistry.createRegistry(1099);
			ChatRoomInterface cr = new ChatRoom() ; 
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/tp4_car_ChatRoom";
			Naming.rebind(url, cr);
			System.out.println("Serveur lancé");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
