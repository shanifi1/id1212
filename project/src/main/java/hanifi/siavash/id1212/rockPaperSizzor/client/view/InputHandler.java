package hanifi.siavash.id1212.rockPaperSizzor.client.view;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

import hanifi.siavash.id1212.rockPaperSizzor.client.controller.Controller;
import hanifi.siavash.id1212.rockPaperSizzor.common.Hands;

/**
 * @author Siavash
 * A class that handles the client console input.
 */
public class InputHandler {

	private boolean programRunning = true;
	private Scanner scanner = null;
	private OutputHandler outputHandler;
	private Controller controller = null;

	/**
	 * Creates an InputHandler 
	 * @param outputHandler a reference to the console output handler
	 * @param controller a reference to the controller
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 */
	public InputHandler (OutputHandler outputHandler, Controller controller) throws IOException, ClassNotFoundException, InterruptedException{
		this.programRunning = true;
		this.scanner = new Scanner(System.in);
		this.outputHandler = outputHandler;
		this.controller = controller;
		while(programRunning) {
			this.handleInput();
		}
	}

	/**
	 * Gets the next request from the client.
	 * @return the next request
	 */
	private String getNextInput() {
		return scanner.nextLine();
	}

	/**
	 * Handles client input while the client has not exited.
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws InterruptedException 
	 */
	private void handleInput() throws IOException, ClassNotFoundException, InterruptedException {
			String input = this.getNextInput();
			this.parseInput(input);
	}

	private void parseInput(String input) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		switch(input) {
		case "start":
			outputHandler.presentRequestUsernameMsg();
			String username = getNextInput();
			controller.joinGame(username);
			outputHandler.presentEnterActionMsg();
			break;
		case "rock":
			outputHandler.presentWaitForResultMsg();
			controller.performAction(Hands.ROCK);
			break;
		case "paper":
			outputHandler.presentWaitForResultMsg();
			this.controller.performAction(Hands.PAPER);
			break;
		case "sizzor":
			outputHandler.presentWaitForResultMsg();
			this.controller.performAction(Hands.SIZZOR);
			break;
		default:
			this.outputHandler.presentInvalidCommandMsg();
			break;
		}
	}



}
