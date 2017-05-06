package plates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import plateStates.DifferentPlateStates.PlateStates;

public abstract class Shape implements IShape{

	protected int width;
	protected int height;
	protected Color color;
	protected Point center;
	
	protected Shape(int width, int height, Color color) {
		this.width = width;
		this.height = height;
		this.color = new Color(color.getRGB());
		this.center = new Point(0, 0);
	}
	
	@Override
	public Point getConfidenceInterval() {
		int part = width / 4;
		return new Point(center.x - part, center.x + part);
	}

	@Override
	public Point getCenter(){
		return center;
	}
	
	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getHeight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setState(PlateStates plateState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PlateStates getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCoordinates(Point point) {
		// TODO Auto-generated method stub
		center = point; 
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
}
