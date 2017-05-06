package creatingPlates;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Random;

import constants.Constants;
import plates.IShape;

public class Factory implements IFactory {

	private static Factory instance;
	private ArrayList<Class<?>> classes;
	private ArrayList<Color> colors;
	private int level;
	private int length;
	private int width;
	private Random rand;
	
	private Factory() {
		classes = new ArrayList<Class<?>>(classLoader.ClassLoader.getInstance()
				.loadClasses());
		width = Constants.getInstance().getWidth();
		length = Constants.getInstance().getLength();
		colors = new ArrayList<Color>(getColors());
		level = getLevel() * 3;
		rand = new Random();
	}

	public static Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	@Override
	public IShape getNewPlate() {
		int chosenColor = rand.nextInt(level);
		int chosenShape = rand.nextInt(classes.size());
		IShape shape = null;
		try {
			shape = (IShape) classes.get(chosenShape).getDeclaredConstructor(int.class, int.class, Color.class).newInstance(length, width, colors.get(chosenColor));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return shape;
	}
	
	private ArrayList<Color> getColors() {
		ArrayList<Color> col = new ArrayList<Color>();
		col.add(Color.BLUE);
		col.add(Color.BLACK);
		col.add(Color.CYAN);
		col.add(Color.MAGENTA);
		col.add(Color.GREEN);
		col.add(Color.ORANGE);
		col.add(Color.YELLOW);
		col.add(Color.PINK);
		col.add(Color.WHITE);
		return col;
	}

	private int getLevel() {
		String levelString = new String();
		//levelString = controller.getlevel();
		switch(levelString) {
		case "Medium":
			return 2;
		case "Hard":
			return 3;
		default:
			return 1;
		}
	}
}
