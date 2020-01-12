package hanifi.siavash.id1212.rockPaperSizzor.client.model;

import java.rmi.RemoteException;
import java.util.HashMap;

import hanifi.siavash.id1212.rockPaperSizzor.common.Action;
import hanifi.siavash.id1212.rockPaperSizzor.common.Hands;
import hanifi.siavash.id1212.rockPaperSizzor.common.Player;
import hanifi.siavash.id1212.rockPaperSizzor.common.PlayerInterface;
import hanifi.siavash.id1212.rockPaperSizzor.client.observer.ActionObserver;
import hanifi.siavash.id1212.rockPaperSizzor.client.observer.ResultObserver;

public class GameHandler implements ActionObserver {

	private ResultObserver resultObserver;
	private ActivePlayerTracker activePlayerTracker;
	private PlayerActionTracker playerActionTracker;
	private HashMap<String, Integer> playerScore;
	private Player player;

	public GameHandler(ResultObserver resultObserver) throws RemoteException {
		this.activePlayerTracker = new ActivePlayerTracker();
		this.playerActionTracker = new PlayerActionTracker();
		this.resultObserver = resultObserver;
		this.playerScore = new HashMap<String, Integer>();
	}


	private RoundResult calculateResult() {
		int [] hands = countHands();
		setScores(hands[0], hands[1], hands[2]);
		return new RoundResult(playerScore);
	}


	private int [] countHands() {
		int [] hands = {0,0,0};
		for(String username : playerActionTracker.getUsernameSet()) {
			switch(playerActionTracker.getAction(username)) {
			case 1:
				hands[0]++;
				break;
			case 2:
				hands[1]++;
				break;
			case 3:
				hands[2]++;
				break;
			default:
				break;
			}
		}
		return hands;
	}

	private void setScores(int nORocks, int nOPapers, int nOSizzors) {
		for(String username : playerActionTracker.getUsernameSet()) {
			switch(playerActionTracker.getAction(username)) {
			case Hands.ROCK:
				playerScore.put(username, nOSizzors);
				break;
			case Hands.PAPER:
				playerScore.put(username, nORocks);
				break;
			case Hands.SIZZOR:
				playerScore.put(username, nOPapers);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void playerActionOccurred(Action action) {
		Player player = action.getPlayer();
		int hand = action.getAction();
		playerActionTracker.newPlayerAction(player, hand);
		if(activePlayerTracker.activePlayersHavePerformedAction(playerActionTracker)) {
			RoundResult roundResult = calculateResult();
			resultObserver.roundFinished(roundResult);
			newRound();
		}
	}

	private void newRound() {
		this.playerScore = new HashMap<String, Integer>();
		this.playerActionTracker.resetActions();
	}


	public HashMap<String, Player> getActivePlayers() {
		return this.activePlayerTracker.getActivePlayers();
	}


	public void setCurrentPlayer(Player player) {
		this.player = player;
	}


	public Player getCurrentPlayer() {
		return this.player;
	}


	public PlayerInterface getActivePlayerTracker() {
		return this.activePlayerTracker;
	}


}
