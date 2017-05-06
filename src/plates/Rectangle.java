package plates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import plateStates.DifferentPlateStates.PlateStates;

public class Rectangle extends Parallelogram {

	private int width, height;
	private PlateStates plateState;
	private Color color;

	public Rectangle(int width, int height, Color color) {
		super(width, height, color);
		this.width = width;
		this.height = height;
		this.color = color;
		this.plateState = PlateStates.ON_SHELF;
	}

	public Rectangle(Rectangle clone) {
		super(clone.getWidth(), clone.getHeight(), clone.getColor());
		this.width = clone.getWidth();
		this.height = clone.getHeight();
		this.color = clone.getColor();
	}

	@Override
	public void moveLeft() {
		this.center.x -= 1;
	}

	@Override
	public void moveDown() {
		this.center.y += 1;
	}

	@Override
	public void moveRight() {
		this.center.x += 1;
	}

	@Override
	public Integer getWidth() {
		return this.width;
	}

	@Override
	public Integer getHeight() {
		return this.height;
	}

	@Override
	public void setState(PlateStates plateState) {
		this.plateState = plateState;
	}

	@Override
	public PlateStates getState() {
		return this.plateState;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public void draw(Graphics2D g) {
		int x[] = new int[5];
		int y[] = new int[5];
		int parity1, parity2;
		for (int i = 0; i < x.length - 1; i++) {
			parity1 = (i <= 1) ? -1 : 1;
			parity2 = (i == 1 || i == 2) ? 1 : 0;
			x[i] = center.x + width / 2 * parity1;
			y[i] = center.y - height * parity2;
		}
		/*
		 * x[0] = x[1] = center.x - width/2, x[2] = x[3] = center.x + width/2
		 * y[0] = y[3] = center.y, y[1] = y[2] = center.y + height 0 lower left,
		 * 1 upper left, 2 upper right, 3 lower right
		 */
		// The last point must equal the first point to have a closed shape
		x[4] = x[0];
		y[4] = y[0];

		Polygon poly = new Polygon(x, y, 4);
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
