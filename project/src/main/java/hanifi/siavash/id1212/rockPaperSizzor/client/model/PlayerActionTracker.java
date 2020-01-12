package hanifi.siavash.id1212.rockPaperSizzor.client.model;

import java.util.HashMap;
import java.util.Set;

import hanifi.siavash.id1212.rockPaperSizzor.common.Player;

public class PlayerActionTracker {
	private HashMap<String, Integer> playerAction;
	
	public PlayerActionTracker() {
		playerAction = new HashMap<String,Integer>();
	}

	public void newPlayerAction(Player player, int action) {
		playerAction.put(player.getUsername(), action);
	}
	
	public HashMap<String,Integer> getPlayerAction(){
		return this.playerAction;
	}

	public Set<String> getUsernameSet() {
		return playerAction.keySet();
	}

	public int getAction(String username) {
		return playerAction.get(username);
	}

	public void resetActions() {
		this.playerAction = new HashMap<String, Integer>();
	}
	
}
