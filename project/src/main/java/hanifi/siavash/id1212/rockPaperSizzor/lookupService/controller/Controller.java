package hanifi.siavash.id1212.rockPaperSizzor.lookupService.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import hanifi.siavash.id1212.rockPaperSizzor.common.Player;
import hanifi.siavash.id1212.rockPaperSizzor.lookupService.model.ActivePlayers;
import hanifi.siavash.id1212.rockPaperSizzor.common.LookupServiceInterface;

public class Controller extends UnicastRemoteObject implements LookupServiceInterface{
	private static final long serialVersionUID = 1L;
	private ActivePlayers activePlayers;
	
	public Controller() throws RemoteException {
		super();
		this.activePlayers = new ActivePlayers();
	}

	@Override
	public void joinGame(Player player) throws RemoteException {
		activePlayers.newPlayerJoined(player);
	}

	@Override
	public void leaveGame(Player player) {
		activePlayers.playerLeftGame(player);
	}

}
