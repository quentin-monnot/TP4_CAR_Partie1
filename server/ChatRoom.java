package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

import interfaceRMI.*;

public class ChatRoom extends UnicastRemoteObject implements ChatRoomInterface {
	HashMap<String, String> hm = new HashMap<String, String>();
	ArrayList<ClientInterface> cl = new ArrayList<ClientInterface>();

	protected ChatRoom() throws RemoteException {
		super();
		hm.put("Quentin", "123");
		hm.put("Sebastien", "456");
		hm.put("Jean", "789");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 3160082588394036332L;

	public boolean connexion(String id, String password, ClientInterface client, String nomUserChatRoom)
			throws RemoteException {
		if (hm.containsKey(id)) {
			if (hm.get(id).equals(password)) {
				if (client instanceof ClientInterface) {
					for (ClientInterface clientInterface : cl) {
						clientInterface.notification("Le client : " + nomUserChatRoom + " vient de se connecter");
					}
					cl.add((ClientInterface) client);
					return true;
				}

			}
		}
		return false;
	}

	public void notifierMessage(Message msg) throws RemoteException {
		for (ClientInterface clientInterface : cl) {
			clientInterface.notification(msg.getTime() + " -> " + msg.getExp() + " vous dit : " + msg.getMsg());
		}
	}

	public void seDeconnecter(ClientInterface client) throws RemoteException {
		if (cl.contains(client)) {
			cl.remove((ClientInterface) client);
		}
	}
}
