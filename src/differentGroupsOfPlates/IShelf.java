package differentGroupsOfPlates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import plates.IShape;

public interface IShelf {

	/**
	 * @return the plate that finishes the plate
	 */
	IShape getUnusedPlates();

	/**
	 * checks if any plate finishes the shelf
	 * 
	 * @return
	 */
	boolean hasFinishedPlate();

	void addPlate(IShape plate);

	/**
	 * increment all plates inside this container
	 */
	void moveAllPlates();

	/**
	 * draw the shelf and the plates on it
	 * 
	 * @param g
	 */
	void draw(Graphics2D g);

	ArrayList<IShape> getPlates();
}
