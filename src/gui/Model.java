package gui;

import files.Files;
import loading.Load;
import saving.Save;

public class Model {

	private playPaused gamestate = playPaused.Play;
	private diffLevel level = diffLevel.Easy;
	private View guiView;
	private Control guiControl;
	

	public Control getGuiControl() {
		return guiControl;
	}

	public void setGuiControl(Control guiControl) {
		this.guiControl = guiControl;
	}

	public Model() {
	}

	public View getGuiView() {
		return guiView;
	}

	public void setGuiView(View guiView) {
		this.guiView = guiView;
	}

	public synchronized playPaused getGamestate() {
		return gamestate;
	}

	public void setGamestate(playPaused gamestate) {
		this.gamestate = gamestate;
	}

	public diffLevel getLevel() {
		return level;
	}

	public void setLevel(diffLevel level) {
		this.level = level;
	}

	public void doWithBtnHighScore() {
		// TODO go from option view to high score view
	}

	public void save() {
		// TODO save current state of a game
		Files.getInstance().createFiles();
		Save.getInstance().save(guiView, Files.getInstance().getPlayer1Place(), Files.getInstance().getPlayer2Place(),
				Files.getInstance().getPlayer1LeftStack(), Files.getInstance().getPlayer1RightStack(),
				Files.getInstance().getPlayer2LeftStack(), Files.getInstance().getPlayer1RightStack(),
				Files.getInstance().getUpLeftShelf(), Files.getInstance().getDownLeftShelf(),
				Files.getInstance().getUpRightShelf(), Files.getInstance().getDownRightShelf(),
				Files.getInstance().getFlying(), Files.getInstance().getPool(), Files.getInstance().getLevel());
	}

	public void load() {
		// TODO load a previous game
		guiView.doWithPlayButton();
		guiView.getCanvas().setPlayer1(Load.getInstance().loadPlayer1(Files.getInstance().getPlayer1Place()));
		guiView.getCanvas().setPlayer2(Load.getInstance().loadPlayer2(Files.getInstance().getPlayer2Place()));
		guiView.getCanvas().setUpLeftShelf(Load.getInstance().loadUpLeftShelf(Files.getInstance().getUpLeftShelf()));
		guiView.getCanvas().setDownLeftShelf(Load.getInstance().loadDownLeftShelf(Files.getInstance().getDownLeftShelf()));
		guiView.getCanvas().setUpRightShelf(Load.getInstance().loadUpRightShelf(Files.getInstance().getUpRightShelf()));
		guiView.getCanvas().setDownRightShelf(Load.getInstance().loadDownRightShelf(Files.getInstance().getDownRightShelf()));
		guiView.getCanvas().setFlying(Load.getInstance().loadFlying(Files.getInstance().getFlying()));
		guiView.getCanvas().getControl().setPool(Load.getInstance().loadPool(Files.getInstance().getPool()));
		getGuiControl().playersActionListener();
		getGuiControl().GameActionListeners();
	}

	public synchronized void doWithPlayPause() {
		// TODO action listener impl. for play paused button
		if (getGamestate().equals(playPaused.Play))
			setGamestate(playPaused.Pause);
		else {
			setGamestate(playPaused.Play);
		}
	}

	public void levelUp() {
		// TODO action listener impl. for level up button
		switch (getLevel()) {
		case Easy:
			setLevel(diffLevel.Medium);
			break;
		case Medium:
			setLevel(diffLevel.Hard);
			break;
		default:
			break;
		}
	}

	public void levelDown() {
		// TODO action listener impl. for level down button
		switch (getLevel()) {
		case Hard:
			setLevel(diffLevel.Medium);
			break;
		case Medium:
			setLevel(diffLevel.Easy);
			break;
		default:
			break;
		}
	}

}
