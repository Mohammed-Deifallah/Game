package player;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import plates.IShape;
import score.Score;

public interface IPlayer {

	/**
	 * move the player to the left move the player stacks to the left
	 */
	void moveLeft();

	/**
	 * move the player to the right move the player stacks to the right
	 */
	void moveRight();

	Score getScore();

	/**
	 * Calls the increaseByfunction of the Score class.
	 */
	void increaseScoreBy(int value);

	/**
	 * Calls the decreaseBy function of the Score class.
	 */
	void deccreaseScoreBy(int value);

	// /**
	// * Calls for both stacks checkScore function
	// * */
	// void checkStackScore();

	/**
	 * Calls his stacks getUnusedPlates function
	 * 
	 * @return ArrayList of plates that are removed due to score increase or
	 *         decrease It returns empty ArrayList if there is not unused plates
	 */
	ArrayList<IShape> getUnusedPlates();

	String getName();

	/**
	 * check all its stacks that can take this plate by calling function
	 * addPlate
	 * 
	 * @param plate
	 * @return true if plate is added to any of its stacks, false otherwise
	 */
	boolean addPlate(IShape plate);

	/**
	 * Draw the player Calls Draw function of his stacks
	 * 
	 * @param g
	 * @param image
	 */
	void draw(Graphics2D g);

	Point getCenter();
}
