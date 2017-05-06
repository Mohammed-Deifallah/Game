package score;

import java.sql.Time;

public class Score implements IScore {

	int score;

	public Score() {
		score = 0;
	}

	public void increaseBy(int value) {	
		score += value;
	}

	public synchronized void decreaseBy(int value) {
		score -= value;
	}

	public Time getScoreTime() {
		return null;
	}

	public Integer getScoreValue() {
		return score;
	}
}
