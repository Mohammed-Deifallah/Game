package score;

import java.util.ArrayList;

import player.IPlayer;

public class ScoreController {

	private static ScoreController instance;
	
	private ScoreController() {
		
	}

	public static ScoreController getInstance() {
		if (instance == null) {
			instance = new ScoreController();
		}
		return instance;
	}
	
	public IPlayer getWinner(ArrayList<IPlayer> players) {
		return null;
	}
}
