package hanifi.siavash.id1212.rockPaperSizzor.client.model;

import java.util.HashMap;

public class RoundResult {
	
	private HashMap<String, Integer> playerScore;
	
	public RoundResult(HashMap<String, Integer> playerScore) {
		this.playerScore = playerScore;
	}

	public HashMap<String, Integer> getPlayerScore() {
		return this.playerScore;
	}
	
	

}
