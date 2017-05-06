package differentGroupsOfPlates;

import java.util.ArrayList;

import plateStates.DifferentPlateStates.PlateStates;
import plates.IShape;

public class Iterator {
	private ArrayList<IShape> unused, container;

	public Iterator(ArrayList<IShape> container) {
		unused = new ArrayList<>();
		this.container = container;
	}

	public ArrayList<IShape> getUnusedPlates() {
		for (int i = 0; i < container.size(); i++) {
			if (container.get(i).getState().equals(PlateStates.OUTSIDE)) {
				unused.add(container.get(i));
				container.remove(i);
				i--;
			}
		}
		return unused;
	}
}