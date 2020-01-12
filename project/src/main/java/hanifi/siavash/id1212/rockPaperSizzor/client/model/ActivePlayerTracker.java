package hanifi.siavash.id1212.rockPaperSizzor.client.model;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import hanifi.siavash.id1212.rockPaperSizzor.common.Player;
import hanifi.siavash.id1212.rockPaperSizzor.common.PlayerInterface;

public class ActivePlayerTracker  extends UnicastRemoteObject implements PlayerInterface, Serializable  {
	
	private static final long serialVersionUID = 8493046065330269265L;
	HashMap<String, Player> activePlayers;
	
	public ActivePlayerTracker() throws RemoteException {
		super();
		this.activePlayers = new HashMap<String, Player>();
	}

	public boolean activePlayersHavePerformedAction(PlayerActionTracker playerActionTracker) {
		HashMap<String, Integer> playerAction = playerActionTracker.getPlayerAction();
		if(playerAction.size() == activePlayers.size())
			return true;
		else
			return false;
		
	}

	public HashMap<String, Player> getActivePlayers() {
		return this.activePlayers;
	}

	@Override
	public void updateActivePlayers(HashMap<String, Player> activePlayers) throws RemoteException {
		this.activePlayers = activePlayers;
	}

}
