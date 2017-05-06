package plates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public interface IShape {

	void moveLeft();

	void moveDown();

	void moveRight();

	Integer getWidth();

	Integer getHeight();

	void setState(plateStates.DifferentPlateStates.PlateStates plateState);
	
	plateStates.DifferentPlateStates.PlateStates getState();

	void setCoordinates(Point point);

	/**
	 * 
	 * @return the range of confidence interval
	 * from x1 to x2
	 * point (x1, x2)
	 */
	Point getConfidenceInterval();

	Color getColor();
	
	Point getCenter();
	
	/**
	 * Need to be implemented for every shape.
	 * @param g
	 */
	abstract void draw(Graphics2D g);
}
