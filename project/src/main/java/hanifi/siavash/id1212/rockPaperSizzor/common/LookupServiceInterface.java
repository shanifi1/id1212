package hanifi.siavash.id1212.rockPaperSizzor.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LookupServiceInterface extends Remote {
	public void joinGame(Player player) throws RemoteException;
	public void leaveGame(Player player) throws RemoteException;
}
