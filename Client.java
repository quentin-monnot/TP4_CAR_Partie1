import interfaceRMI.ChatRoomInterface;
import interfaceRMI.ClientInterface;
import interfaceRMI.Message;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class Client extends UnicastRemoteObject implements ClientInterface {

	String name;
	boolean connected;

	protected Client(String name) throws RemoteException {
		this.name = name;
		this.connected = false;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8317724371515567032L;

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Lancement du client");
		try {
			ChatRoomInterface r = (ChatRoomInterface) Naming.lookup("rmi://127.0.1.1/tp4_car_ChatRoom");
			System.out.println("Insérer nom de compte : ");
			String user = s.nextLine();
			System.out.println("Insérer mot de passe : ");
			String mdp = s.nextLine();
			System.out.println("Insérer pseudo : ");
			String name = s.nextLine();
			Client c = new Client(name);
			if (r.connexion(user, mdp, c, name)) {
				c.connected = true;
				while (true && c.connected) {
					System.out.println("Entrez votre message : ");
					String message = s.nextLine();
					switch (message) {
					case "disconnect":
						r.seDeconnecter(c);
						c.connected = false;
						System.out.println("Utilisateur déconnecté !");
						break;
					default:
						Message msg = new Message(message,name);
						r.notifierMessage(msg);
					}
				}
			} else {
				System.err.println("Nom de compte/Mot de passe invalide :");
			}
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void notification(String msg) throws RemoteException {
		System.out.println(msg);
	}
}
