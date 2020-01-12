package hanifi.siavash.id1212.rockPaperSizzor.client.view;

import java.util.HashMap;

import hanifi.siavash.id1212.rockPaperSizzor.client.model.RoundResult;

/**
 * @author Siavash
 */
public class OutputHandler {

	public void presentInvalidCommandMsg() {
		System.out.println("Invalid command");		
	}

	public void presentRoundResult(RoundResult roundResult) {
		HashMap<String, Integer> playerScore = roundResult.getPlayerScore();
		System.out.println("Round result:");
		for(String p : playerScore.keySet())
			System.out.println(p + " " + playerScore.get(p)); 
	}

	public void presentRequestUsernameMsg() {
		System.out.println("Enter username: ");
	}

	public void presentCurrentScore() {
		
	}

	public void presentEnterActionMsg() {
		System.out.println("Enter action{rock, paper, sizzor}: ");
	}

	public void presentWaitForResultMsg() {
		System.out.println("Wait for result.");
	}
	
}
