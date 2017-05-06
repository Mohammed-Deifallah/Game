package player;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import differentGroupsOfPlates.Stack;
import differentGroupsOfPlates.UnusedPlates;
import plates.IShape;
import score.Score;

public class Player implements IPlayer {

	private Point center = null;
	int length, hieght, minX, maxX;
	private Stack leftStack;

	private Stack rightStack;
	private Score score;
	private BufferedImage im = null;
	private String name;

	public Player(String name, Point center, int length, int hieght, int maxX, int minX, int maxY) {
		this.name = name;
		this.length = length;
		this.hieght = hieght;
		this.center = center;
		this.minX = minX;
		this.maxX = maxX;
		this.score = new Score();
		this.leftStack = new Stack(new Point((int) center.getX() - length / 2, (int) center.getY()), maxY);
		this.rightStack = new Stack(new Point((int) center.getX() + length / 2, (int) center.getY()), maxY);
	}

	public void setLeftStack(Stack leftStack) {
		this.leftStack = leftStack;
	}
	
	public void setRightStack(Stack rightStack) {
		this.rightStack = rightStack;
	}

	public void setImage(BufferedImage im) {
		this.im = im;
	}

	private boolean reachesLeftBoarder() {
		if (center.getX() - length / 2 <= minX)
			return true;
		return false;
	}

	private boolean reachesRightBoarder() {
		if (center.getX() + length / 2 >= maxX)
			return true;
		return false;
	}

	public Stack getLeftStack() {
		return leftStack;
	}

	public Stack getRightStack() {
		return rightStack;
	}

	public synchronized void setScore(Score score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void moveLeft() {
		if (!reachesLeftBoarder()) {
			leftStack.moveLeft();
			rightStack.moveLeft();
			center.x -= 3;
		}
	}

	@Override
	public void moveRight() {
		if (!reachesRightBoarder()) {
			leftStack.moveRight();
			rightStack.moveRight();
			center.x += 3;
		}
	}

	@Override
	public Score getScore() {
		return score;
	}

	@Override
	public void increaseScoreBy(int value) {
		score.increaseBy(value);
	}

	@Override
	public void deccreaseScoreBy(int value) {
		score.decreaseBy(value);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<IShape> getUnusedPlates() {
		ArrayList<IShape> ret = new ArrayList<>();
		UnusedPlates unused = leftStack.getUnusedPlates();
		if(unused.addScore())this.score.increaseBy(unused.getScoreIncrease());
		ret.addAll(unused.getUnusedPlates());
		unused = rightStack.getUnusedPlates();
		if(unused.addScore())this.score.increaseBy(unused.getScoreIncrease());
		ret.addAll(unused.getUnusedPlates());
		return ret;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(im, center.x - length / 2, center.y - hieght, length, hieght, null);
		leftStack.draw(g);
		rightStack.draw(g);
	}

	@Override
	public boolean addPlate(IShape plate) {
		if (leftStack.addPlate(plate))
			return true;
		else if (rightStack.addPlate(plate))
			return true;
		return false;
	}

	@Override
	public Point getCenter() {
		// TODO Auto-generated method stub
		return this.center;
	}
}
