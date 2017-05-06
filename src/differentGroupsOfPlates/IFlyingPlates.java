package differentGroupsOfPlates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import plates.IShape;

public interface IFlyingPlates {

	/**
	 * checks plates under critical level
	 * 
	 * @return delete these plates from it and return them
	 */
	ArrayList<IShape> getUnusedPlates();

	void addPlate(IShape plate);

	/**
	 * we call this function to check if they reach any stack
	 * 
	 * @return
	 */
	ArrayList<IShape> getPlates();

	/**
	 * plates that are added to stacks must be removed from flying
	 * 
	 * @param plates
	 */
	void removePlates(ArrayList<IShape> plates);

	/**
	 * increment all plates inside this container
	 */
	void moveAllPlates();

	/**
	 * draw all flying plates
	 * 
	 * @param g
	 */
	void draw(Graphics2D g);

}
