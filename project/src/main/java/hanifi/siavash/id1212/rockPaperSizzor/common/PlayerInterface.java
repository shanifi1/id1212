package hanifi.siavash.id1212.rockPaperSizzor.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface PlayerInterface extends Remote {
	public void updateActivePlayers(HashMap<String, Player> activePlayers) throws RemoteException;
}
