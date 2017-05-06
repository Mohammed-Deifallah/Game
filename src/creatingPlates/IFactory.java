package creatingPlates;

import plates.IShape;

public interface IFactory {

	/**
	 * Ashraf will implement factory as it depend on class loading
	 * 
	 * @return
	 */
	IShape getNewPlate();
}
