package hanifi.siavash.id1212.rockPaperSizzor.common;

import java.io.Serializable;

public class Player implements Serializable{

	private static final long serialVersionUID = -6603101639938102108L;
	private String ip;
	private int port; 
	private String username;
	private PlayerInterface playerInterface;
	
	public Player(String username, String ip, int port, PlayerInterface playerInterface) {
		this.ip = ip;
		this.port = port;
		this.username = username;
		this.playerInterface = playerInterface;
	}
	
	public PlayerInterface getPlayerInterface() {
		return this.playerInterface;
	}
	
	public String getIp() {
		return this.ip;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public int getPort() {
		return this.port;
	}

}
