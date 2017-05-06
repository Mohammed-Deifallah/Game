package differentGroupsOfPlates;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import plateStates.DifferentPlateStates.PlateStates;
import plates.IShape;

public class Stack implements IStack {
	
	Point center;
	int numCollectToWin, criticalHieght, maxHieght;
	int length, hieght, scoreIncrease, numRemovedOnlose;
	BufferedImage im;
	ArrayList<IShape> container;

	public Stack(Point center, int maxHieght) {
		this.center = center;
		////// should be read from file
		this.length = 100;
		this.hieght = 170;
		this.numCollectToWin = 3;
		//////////////////////////////////
		try {
			im = ImageIO.read(super.getClass().getResource("/Accessories/letter-t-sign-shape.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.maxHieght = maxHieght;
		this.criticalHieght = this.center.y - this.hieght;
		this.scoreIncrease = 1;
		this.container = new ArrayList<>();
	}

	@Override
	public void moveLeft() {
		// TODO shift stack to the left
		this.center.x -= 3;
		for (IShape plate : container)
			plate.getCenter().x -= 3;
	}

	@Override
	public void moveRight() {
		// TODO shift stack right
		this.center.x += 3;
		for (IShape plate : container)
			plate.getCenter().x += 3;
	}

	@Override
	public UnusedPlates getUnusedPlates() {
		/*
		 * TODO unused plates either because height get to max height we remove
		 * half of plates by setting them unused or because there is
		 * numCollectToWin plates of same color and they will be removed or
		 * there is nothing of above happen so empty array is returned with flag
		 * false
		 */
		ArrayList<IShape> returnPLates = new ArrayList<>();
		if (checkWinplates()) {
			for (int i = 0; i < numCollectToWin; i++) {
				IShape plate = container.remove(container.size() - 1);
				criticalHieght += plate.getHeight();
				plate.setState(PlateStates.OUTSIDE);
				returnPLates.add(plate);
			}
			return new UnusedPlates(returnPLates, true, scoreIncrease);
		} else if (criticalHieght < maxHieght) {
			int size = container.size() / 2;
			for (int i = 0; i < size; i++) {
				IShape plate = container.remove(container.size() - 1);
				criticalHieght += plate.getHeight();
				plate.setState(PlateStates.OUTSIDE);
				returnPLates.add(plate);
			}
			return new UnusedPlates(returnPLates, true, -scoreIncrease);
		}
		return new UnusedPlates(returnPLates, false, 0);
	}

	private boolean checkWinplates() {
		if (container.size() < numCollectToWin)
			return false;
		int begin = container.size() - numCollectToWin, size = container.size();
		Color sameColor = container.get(begin).getColor();
		for (int i = begin; i < size; i++) {
			if (!container.get(i).getColor().equals(sameColor))
				return false;
		}
		return true;
	}

	@Override
	public Integer getCriticalHeight() {
		// TODO get the height of stack + height of plates
		return criticalHieght;
	}

	@Override
	public boolean addPlate(IShape plate) {
		Point point = plate.getConfidenceInterval();
		if (plate.getCenter().getY() != criticalHieght) {
			return false;
		} else if (center.getX() < point.getX() || center.getX() > point.getY()) {
			return false;
		}
		plate.setState(PlateStates.ON_STACK);
		container.add(plate);
		criticalHieght -= plate.getHeight();
		return true;
	}

	@Override
	public ArrayList<IShape> getPlates() {
		// TODO Auto-generated method stub
		return container;
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO draw stack that is hold by player image
		g.drawImage(im, (int) center.getX() - length / 2, (int) center.getY() - hieght, length, hieght, null);
		for (IShape plate : container) {
			plate.draw(g);
		}
	}

}
