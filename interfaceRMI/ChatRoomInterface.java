package interfaceRMI;

import java.rmi.*;

public interface ChatRoomInterface extends Remote {
	
	public boolean connexion(String id, String password, ClientInterface client, String userName) throws RemoteException;

	public void seDeconnecter(ClientInterface client) throws RemoteException;

	public void notifierMessage(Message msg) throws RemoteException;

}
