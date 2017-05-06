package differentGroupsOfPlates;

import java.util.ArrayList;

import plates.IShape;

public class UnusedPlates {

	private ArrayList<IShape> plates;
	private Boolean bool;
	private Integer scoreIncrease;

	public UnusedPlates(ArrayList<IShape> plates, boolean bool, int scoreIncrease) {
		this.plates = new ArrayList<IShape>(plates);
		this.bool = bool;
		this.scoreIncrease = scoreIncrease;
	}

	public Boolean addScore() {
		return bool;
	}

	public Integer getScoreIncrease() {
		return scoreIncrease;
	}

	public ArrayList<IShape> getUnusedPlates() {
		return plates;
	}

}
