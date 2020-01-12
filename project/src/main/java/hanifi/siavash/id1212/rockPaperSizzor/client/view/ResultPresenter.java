package hanifi.siavash.id1212.rockPaperSizzor.client.view;

import hanifi.siavash.id1212.rockPaperSizzor.client.model.RoundResult;
import hanifi.siavash.id1212.rockPaperSizzor.client.observer.ResultObserver;

public class ResultPresenter implements ResultObserver {
	
	private OutputHandler outputHandler;
	
	public ResultPresenter(OutputHandler outputHandler) {
		this.outputHandler = outputHandler;
	}
	
	@Override
	public void roundFinished(RoundResult roundResult) {
		outputHandler.presentRoundResult(roundResult);
		outputHandler.presentEnterActionMsg();
	}

}
