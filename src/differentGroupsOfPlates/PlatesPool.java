package differentGroupsOfPlates;

import java.util.ArrayList;

import creatingPlates.Factory;
import creatingPlates.IFactory;
import log4j.Log4j;
import plates.IShape;

public class PlatesPool implements IPlatesPool {

	private static IPlatesPool instance;
	private ArrayList<IShape> pool;
	private IFactory factory;
	
	private PlatesPool() {
		pool = new ArrayList<IShape>();
		factory = Factory.getInstance();
	}
	
	public static IPlatesPool getInstance() {
		if (instance == null) {
			instance = new PlatesPool();
		}
		return instance;
	}
	
	@Override
	public synchronized IShape getPlate() {
		if (pool.isEmpty()) {
			Log4j.getInstance().info("New plate is built");
			pool.add(factory.getNewPlate());
		}else
			Log4j.getInstance().info("A plate has been reused");
		return pool.remove(0);
	}

	@Override
	public synchronized void addUnusedPlates(ArrayList<IShape> plates) {
		for (IShape iShape : plates) {
			addUnusedPlate(iShape);
		}
	}

	@Override
	public synchronized void addUnusedPlate(IShape plate) {
		pool.add(plate);
	}

}
