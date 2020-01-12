package hanifi.siavash.id1212.rockPaperSizzor.client.net;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;

import hanifi.siavash.id1212.rockPaperSizzor.common.Action;
import hanifi.siavash.id1212.rockPaperSizzor.common.Player;

public class ActionSender {

	private void sendAction(Player player, Action action) throws UnknownHostException, IOException {
		Socket socket = new Socket(player.getIp(), player.getPort());
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		objectOutputStream.writeObject(action);
		objectOutputStream.close();
		socket.close();
	}
	
	public void broadcast(Action action, HashMap<String, Player> activePlayers) throws UnknownHostException, IOException {
		for(String username : activePlayers.keySet())
			sendAction(activePlayers.get(username), action);
	}

}
