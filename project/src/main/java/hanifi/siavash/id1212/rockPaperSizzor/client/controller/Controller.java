package hanifi.siavash.id1212.rockPaperSizzor.client.controller;

import java.io.IOException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.HashMap;

import hanifi.siavash.id1212.rockPaperSizzor.client.model.GameHandler;
import hanifi.siavash.id1212.rockPaperSizzor.client.net.PlayerCommunicator;
import hanifi.siavash.id1212.rockPaperSizzor.client.observer.ResultObserver;
import hanifi.siavash.id1212.rockPaperSizzor.common.Action;
import hanifi.siavash.id1212.rockPaperSizzor.common.Player;
import hanifi.siavash.id1212.rockPaperSizzor.common.LookupServiceInterface;

public class Controller {

	LookupServiceInterface serverController;
	PlayerCommunicator playerCommunicator;
	GameHandler gameHandler;

	public Controller(LookupServiceInterface serverController, int actionListenerPort, ResultObserver resultObserver) throws IOException {
		this.serverController = serverController;
		this.gameHandler = new GameHandler(resultObserver);
		this.playerCommunicator = new PlayerCommunicator(actionListenerPort, gameHandler);
	}

	public void joinGame(String username) throws RemoteException {
		String playerIp = playerCommunicator.getActionListenerIp();
		int playerPort = playerCommunicator.getActionListenerPort();
		Player player = new Player(username, playerIp, playerPort, gameHandler.getActivePlayerTracker());
		gameHandler.setCurrentPlayer(player);
		serverController.joinGame(player);
	}

	public void leaveGame() throws RemoteException {
		serverController.leaveGame(gameHandler.getCurrentPlayer());
	}

	public void performAction(int hand) throws UnknownHostException, IOException {
		Action action = new Action(gameHandler.getCurrentPlayer(), hand);
		HashMap<String, Player> activePlayers = gameHandler.getActivePlayers();
		playerCommunicator.broadcastAction(action, activePlayers);
	}

}
