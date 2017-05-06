package gui;

import eventHandler.KeyboardHandler;
import eventHandler.MouseHandler;
import log4j.Log4j;

public class Control{

	Model guiModel ;
	View guiView ;
	
	public Control (Model guiModel,View guiView){
		this.guiModel = guiModel ;
		this.guiView = guiView ;
		guiModel.setGuiControl(this);
		addActions();		
	}

	
	private void addActions(){
		menuActionListeners();
		optionActionListeners();
		GameActionListeners();
		playersActionListener(); 
	}
	
	public Model getGuiModel() {
		return guiModel;
	}

	public View getView() {
		return guiView;
	}
	
	public void playersActionListener(){
		KeyboardHandler board = new KeyboardHandler(guiView);
		board.start();
	}
	
	
	public void menuActionListeners(){
		guiView.getPlayButton().addMouseListener(new MouseHandler(guiModel, guiView, this));
		guiView.getOptionButton().addMouseListener(new MouseHandler(guiModel, guiView, this));
		guiView.getMenuLoad().addMouseListener(new MouseHandler(guiModel, guiView, this));
		Log4j.getInstance().info("Adding listeners to menu");
	}
	
	public void optionActionListeners(){
		guiView.getBack().addMouseListener(new MouseHandler(guiModel, guiView, this));
		Log4j.getInstance().info("Adding listeners to option");
	}

	public void GameActionListeners(){
		guiView.getBack2().addMouseListener(new MouseHandler(guiModel, guiView, this));
		guiView.getPlayPause().addMouseListener(new MouseHandler(guiModel, guiView, this));
		guiView.getLevelDown().addMouseListener(new MouseHandler(guiModel, guiView, this));
		guiView.getLevelUp().addMouseListener(new MouseHandler(guiModel, guiView, this));
		guiView.getSave().addMouseListener(new MouseHandler(guiModel, guiView, this));
		Log4j.getInstance().info("Adding listeners to game");
	}
}
