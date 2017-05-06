package plateStates;

public class DifferentPlateStates {

	public static enum PlateStates {
		OUTSIDE, ON_SHELF, FLYING, ON_STACK
	};

	private DifferentPlateStates() {

	}

	public static PlateStates getDataType(String type) throws Exception {
		PlateStates plateState = null;
		try {
			plateState = PlateStates.valueOf(type.toUpperCase());
		} catch (Exception e) {
			throw new Exception("Unknown Plate State.");
		}
		return plateState;
	}
}
