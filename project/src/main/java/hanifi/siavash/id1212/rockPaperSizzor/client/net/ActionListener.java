package hanifi.siavash.id1212.rockPaperSizzor.client.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import hanifi.siavash.id1212.rockPaperSizzor.client.observer.ActionObserver;
import hanifi.siavash.id1212.rockPaperSizzor.common.Action;

public class ActionListener extends Thread{

	private ServerSocket serverSocket;
	private ActionObserver actionObserver; 
	
	public ActionListener(int port, ActionObserver actionObserver) throws IOException {
		this.actionObserver = actionObserver;
		this.serverSocket = new ServerSocket(port);
	}


	public String getIp() {
		//InetAddress inetAddress = serverSocket.getInetAddress();
		//return inetAddress.getHostAddress();
		return "localhost";
	}

	public int getPort() {
		return serverSocket.getLocalPort();
	}

	@Override
	public void run() {
		try {
			while(true) {
				Socket socket = serverSocket.accept();
				Action action = getAction(socket);
				actionObserver.playerActionOccurred(action);
				socket.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	private Action getAction(Socket socket) throws IOException, ClassNotFoundException {
		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		Action action = (Action) objectInputStream.readObject();
		objectInputStream.close();
		return action;	
	}
}
