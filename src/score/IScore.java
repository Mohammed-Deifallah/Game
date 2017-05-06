package score;

import java.sql.Time;

public interface IScore {

	/**
	 * Increases the score by certain value
	 * Updates scoreTime
	 */
	void increaseBy(int value);

	/**
	 * Decreases the score by certain value
	 * Not Affect scoreTime
	 */
	void decreaseBy(int value);

	Time getScoreTime();

	Integer getScoreValue();
}
