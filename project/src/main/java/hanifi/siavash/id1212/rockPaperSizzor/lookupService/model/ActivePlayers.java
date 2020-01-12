package hanifi.siavash.id1212.rockPaperSizzor.lookupService.model;

import java.rmi.RemoteException;
import java.util.HashMap;

import hanifi.siavash.id1212.rockPaperSizzor.common.Player;

public class ActivePlayers {
	
	private HashMap<String, Player> activePlayers;
	
	public ActivePlayers() {
		this.activePlayers = new HashMap<String, Player>();
	}

	private void addActivePlayer(String username, Player player) {
		this.activePlayers.put(username, player);
	}
	
	public HashMap<String, Player> getActivePlayers(){
		return activePlayers;
	}

	public void newPlayerJoined(Player player) throws RemoteException {
		addActivePlayer(player.getUsername(), player);
		updatePlayers();
	}

	private void updatePlayers() throws RemoteException {
		for(String username:activePlayers.keySet())
			activePlayers.get(username).getPlayerInterface().updateActivePlayers(activePlayers);
	}


	public void playerLeftGame(Player player) {
	}
}
