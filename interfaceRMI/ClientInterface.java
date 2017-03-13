package interfaceRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {

	public void notification(String msg) throws RemoteException;
	
}