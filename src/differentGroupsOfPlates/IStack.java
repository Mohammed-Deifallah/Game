package differentGroupsOfPlates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import plates.IShape;

public interface IStack {

	/**
	 * move the stack to the left move its plates to the left
	 */
	void moveLeft();

	/**
	 * move the stack to the right move its plates to the right
	 */
	void moveRight();

	/**
	 * First it checks last n plates if they are of the same color Second it
	 * checks the cirticalHeight and the maximum height it can reach
	 * 
	 * @return ArrayList of plates that are removed due to score increase or
	 *         decrease It returns empty ArrayList if there is not unused plates
	 */
	UnusedPlates getUnusedPlates();

	/**
	 * @return the height of the stack + height of its plates
	 */
	Integer getCriticalHeight();

	/**
	 * First it checks plate height with its critical height
	 * 
	 * @return true if the plate is added
	 */
	boolean addPlate(IShape plate);

	/**
	 * Draw the Stack It also call draw function for all its used plates
	 * 
	 * @param g
	 */
	void draw(Graphics2D g);

	ArrayList<IShape> getPlates();
}
