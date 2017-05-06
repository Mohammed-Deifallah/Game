package differentGroupsOfPlates;

import java.util.ArrayList;

import plates.IShape;

public interface IPlatesPool {

	/**
	 * return a plate that is found in the pool it calls getNewPlate of the
	 * factory
	 * 
	 * @return it
	 */
	IShape getPlate();

	/**
	 * add unused plates to the pool
	 * 
	 * @param plates
	 */
	void addUnusedPlates(ArrayList<IShape> plates);

	/**
	 * add unused plate to the pool
	 * 
	 * @param plate
	 */
	void addUnusedPlate(IShape plate);

}
