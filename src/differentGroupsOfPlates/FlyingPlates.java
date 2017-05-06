package differentGroupsOfPlates;

import java.awt.Graphics2D;
import java.util.ArrayList;

import plateStates.DifferentPlateStates.PlateStates;
import plates.IShape;

public class FlyingPlates implements IFlyingPlates {

	private ArrayList<IShape> container = new ArrayList<>();
	private Iterator iter;

	public FlyingPlates() {
		// TODO Auto-generated constructor stub
		container = new ArrayList<>();
		iter = new Iterator(container);
	}

	@Override
	public ArrayList<IShape> getUnusedPlates() {
		// TODO get plates that are unused now to send them to pool and remove
		// them from flying plates
		ArrayList<IShape> unusedPlates = iter.getUnusedPlates();
		// ArrayList<IShape> unusedPlates = new ArrayList<>();
		// for (IShape plate : container)
		// if (plate.getState().equals(PlateStates.OUTSIDE)) {
		// unusedPlates.add(plate);
		// container.remove(plate);
		// }
		return unusedPlates;
	}

	@Override
	public void addPlate(IShape plate) {
		// TODO add a plate to flying plates
		plate.setState(PlateStates.FLYING);
		container.add(plate);
	}

	@Override
	public ArrayList<IShape> getPlates() {
		// TODO return plates which is flying
		return container;
	}

	@Override
	public void removePlates(ArrayList<IShape> plates) {
		// TODO remove plates from flying container
		for (int i=0 ; i<plates.size() ; i++){
			container.remove(plates.get(i));
			i--;
		}
	}

	@Override
	public void draw(Graphics2D g) {
		// TODO draw all flying plates in GUI
		for (int i = 0; i < container.size(); i++) {
			container.get(i).draw(g);
		}
	}

	@Override
	public void moveAllPlates() {
		// TODO move all plates down
		for (IShape plate : container)
			plate.moveDown();
	}

}