package differentGroupsOfPlates;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import log4j.Log4j;
import plates.IShape;

public class Shelf implements IShelf{

	public static enum ShelfUpDown {
		UP, DOWN
	};

	public static enum ShelfLeftRight {
		LEFT, RIGHT
	};

	private int height, width;
	private Point center;
	private BufferedImage im;
	private ShelfLeftRight leftRight;
	private ArrayList<IShape> plates;

	public Shelf(Point center, int height, int width, ShelfLeftRight leftRight) {
		this.plates = new ArrayList<IShape>();
		this.height = height;
		this.width = width;
		this.center = center;
		this.leftRight = leftRight;
		try {
			im = ImageIO.read(super.getClass().getResource("/Accessories/prodLine.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log4j.getInstance().info("A " + leftRight.toString() + "has been built");
	}
	
	
	
	public int getHeight() {
		return height;
	}



	public int getWidth() {
		return width;
	}



	public Point getCenter() {
		return center;
	}



	public BufferedImage getIm() {
		return im;
	}



	public ShelfLeftRight getLeftRight() {
		return leftRight;
	}



	@Override
	public void addPlate(IShape plate) {
		
		switch (leftRight) {
		case LEFT:
			plate.setCoordinates(new Point(center.x-width/2+plate.getWidth()/2, center.y - height));
			break;
		case RIGHT:
			plate.setCoordinates(new Point(center.x+width/2-plate.getWidth()/2, center.y - height));
		default:
			break;
		}
		if(plates.isEmpty() || canPut(plate)){
			plates.add(plate);
			Log4j.getInstance().info("A plate has been added to " + leftRight.toString() + " shelf");
		}
	}
	
	private boolean canPut(IShape plate){
		IShape firstPlate = plates.get(plates.size()-1);
		switch (leftRight) {
		case LEFT:
			int begin = center.x - width/2 ;
			if (firstPlate.getCenter().x > begin+plate.getWidth()+firstPlate.getWidth()/2 + 70)
				return true;
			break;
		case RIGHT:
			begin = center.x + width/2 ;
			if (firstPlate.getCenter().x < begin-plate.getWidth()-firstPlate.getWidth()/2 - 70)
				return true;
			break;
		}
		return false;
	}

	@Override
	public IShape getUnusedPlates() {
		if (hasFinishedPlate()) {
			Log4j.getInstance().info("A plate has fallen from " + leftRight.toString() + " shelf");
			return plates.remove(0);
		}
		return  null;
	}

	@Override
	public boolean hasFinishedPlate() {
		if (!plates.isEmpty()) {
			IShape lastPlate = plates.get(0);
			switch (leftRight) {
			case LEFT:
				if (lastPlate.getCenter().getX()+lastPlate.getWidth() > center.getX() + 2*width / 3)
					return true;
				break;
			case RIGHT:
				if (lastPlate.getCenter().getX()-lastPlate.getWidth() < center.getX() - 2*width / 3)
					return true;
				break;
			}
		}
		return false;
	}
	
	@Override
	public ArrayList<IShape> getPlates() {
		// TODO Auto-generated method stub
		return plates;
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(im, (int) center.getX() - width / 2, (int) center.getY() - height, width, height, null);
		for(int i=0 ; i<plates.size() ; i++)
			plates.get(i).draw(g);
	}
		
	@Override
	public void moveAllPlates() {
		// TODO move all plates of shelf
		switch (leftRight) {
		case LEFT:
			for(IShape plate : plates)
				plate.moveRight();
			break; 
		case RIGHT:
			for(IShape plate : plates)
				plate.moveLeft();
			break; 
		}
	}

}
