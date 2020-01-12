package hanifi.siavash.id1212.rockPaperSizzor.common;

import java.io.Serializable;

public class Action implements Serializable{


	private static final long serialVersionUID = -2954654791201459503L;
	private Player player;
	private int action;
	
	public Action(Player player, int action) {
		this.player = player;
		this.action = action;
	}

	public Player getPlayer() {
		return this.player;
	}
	
	public int getAction() {
		return this.action;
	}
}
