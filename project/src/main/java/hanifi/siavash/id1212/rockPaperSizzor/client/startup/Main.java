package hanifi.siavash.id1212.rockPaperSizzor.client.startup;

import java.io.IOException;
import java.rmi.Naming;

import hanifi.siavash.id1212.rockPaperSizzor.client.controller.Controller;
import hanifi.siavash.id1212.rockPaperSizzor.client.observer.ResultObserver;
import hanifi.siavash.id1212.rockPaperSizzor.client.view.InputHandler;
import hanifi.siavash.id1212.rockPaperSizzor.client.view.OutputHandler;
import hanifi.siavash.id1212.rockPaperSizzor.client.view.ResultPresenter;
import hanifi.siavash.id1212.rockPaperSizzor.common.LookupServiceInterface;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		try {
			int actionListenerPort = 5003;
			LookupServiceInterface serverController = (LookupServiceInterface) Naming.lookup("rmi://localhost:5008"+ "/rmi");
			OutputHandler outputHandler = new OutputHandler();
			ResultObserver resultObserver = new ResultPresenter(outputHandler);
			Controller controller = new Controller(serverController, actionListenerPort, resultObserver);
			new InputHandler(outputHandler, controller);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
