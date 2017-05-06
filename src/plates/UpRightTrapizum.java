package plates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import plateStates.DifferentPlateStates.PlateStates;

public class UpRightTrapizum extends Trapizum {

	private int width, height;
	private PlateStates plateState;
	private Color color;

	public UpRightTrapizum(int width, int height, Color color) {
		super(width, height, color);
		this.width = width;
		this.height = height;
		this.color = color;
		this.plateState = PlateStates.ON_SHELF;
	}

	public UpRightTrapizum(UpRightTrapizum clone) {
		super(clone.getWidth(), clone.getHeight(), clone.getColor());
		this.width = clone.getWidth();
		this.height = clone.getHeight();
		this.color = clone.getColor();
	}

	@Override
	public void moveLeft() {
		// TODO move plate to the left by one
		this.center.x -= 1;
	}

	@Override
	public void moveDown() {
		// TODO move plate down by one
		this.center.y += 1;
	}

	@Override
	public void moveRight() {
		// TODO move plate to the left by one
		this.center.x += 1;
	}

	@Override
	public Integer getWidth() {
		// TODO get the width of the plate
		return this.width;
	}

	@Override
	public Integer getHeight() {
		// TODO get the height of the plate
		return this.height;
	}

	@Override
	public void setState(PlateStates plateState) {
		// TODO set the state of plate depending on it's current position in gui
		this.plateState = plateState;
	}

	@Override
	public PlateStates getState() {
		// TODO return current state of the plate
		return this.plateState;
	}

	@Override
	public Color getColor() {
		// TODO get the current color of this plate
		return this.color;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO draw the actual shape of trapizium in graphics
		// array for x-coordinates of trapizium
		int[] xpoints = new int[4];
		xpoints[0] = center.x - width / 2 + 10;
		xpoints[1] = center.x + width / 2 - 10;
		xpoints[2] = center.x + width / 2;
		xpoints[3] = center.x - width / 2;
		// array for y-coordinates of trapizium
		int[] ypoints = new int[4];
		ypoints[0] = center.y - height;
		ypoints[1] = center.y - height;
		ypoints[2] = center.y;
		ypoints[3] = center.y;
		// trapizium shape
		Polygon poly = new Polygon(xpoints, ypoints, 4);
		// save old color of graphics
		Color oldColor = g.getColor();
		// set color of graphics to color of the plate color
		g.setColor(color);
		// coloring plate
		g.fill(poly);
		// drawing the plate in gui
		g.draw(poly);
		// retraining old color of graphics
		g.setColor(oldColor);
	}

}
