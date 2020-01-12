package hanifi.siavash.id1212.rockPaperSizzor.client.net;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;

import hanifi.siavash.id1212.rockPaperSizzor.client.observer.ActionObserver;
import hanifi.siavash.id1212.rockPaperSizzor.common.Action;
import hanifi.siavash.id1212.rockPaperSizzor.common.Player;

public class PlayerCommunicator {
	
	private ActionSender actionSender;
	private Thread actionListenerThread;
	
	
	public PlayerCommunicator(int actionListenerPort, ActionObserver actionObserver) throws IOException {
		actionListenerThread = new ActionListener(actionListenerPort, actionObserver);
		actionListenerThread.start();
		this.actionSender = new ActionSender();
	}
	
	public String getActionListenerIp() {
		return (((ActionListener) actionListenerThread).getIp());
	}

	public int getActionListenerPort() {
		return ((ActionListener)actionListenerThread).getPort();
	}

	public void broadcastAction(Action action, HashMap<String, Player> activePlayers) throws UnknownHostException, IOException {
		actionSender.broadcast(action, activePlayers);
	}

}
