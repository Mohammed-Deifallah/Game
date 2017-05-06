package eventHandler;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import gui.View;
import gui.playPaused;

public class KeyboardHandler extends Thread {

	View guiView;
	private HashMap<String, Boolean> mapy = new HashMap<>(); 
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	private static final String MOVE_Left1 = "player1 move left";
	private static final String MOVE_Right1 = "player1 move right";
	private static final String MOVE_Left2 = "player2 move left";
	private static final String MOVE_Right2 = "player2 move right";
	private static final String PAUSE = "pause the game";
	private static final String MOVE_Left1_Released = "player1 move left RELEASED";
	private static final String MOVE_Left2_Released = "player2 move left RELEASED";
	private static final String MOVE_Right1_Released = "player1 move right RELEASED";
	private static final String MOVE_Right2_Released = "player2 move right RELEASED";
	private static final String PAUSE_Released = "pause the game RELEASED";

	Action LEFT1 = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Left1, true);
		}
	};

	Action LEFT2 = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Left2, true);
		}
	};

	Action RIGHT1 = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Right1, true);
		}
	};

	Action RIGHT2 = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Right2, true);
		}
	};

	Action SPACE = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(PAUSE, true);
		}
	};

	Action LEFT1_RELEASED = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Left1, false);
		}
	};

	Action LEFT2_RELEASED = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Left2, false);
		}
	};

	Action RIGHT1_RELEASED= new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Right1, false);
		}
	};

	Action RIGHT2_RELEASED = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(MOVE_Right2, false);
		}
	};

	Action SPACE_RELEASED = new AbstractAction() {
		public synchronized void actionPerformed(ActionEvent actionEvent) {
			mapy.put(PAUSE, false);
		}
	};
	@Override
	public void run() {
		while (true) {
			if(guiView.getModel().getGamestate().equals(playPaused.Play)){
				delay();
				playAll();
			}else{
				mapy.put(MOVE_Left1, false);
				mapy.put(MOVE_Left2, false);
				mapy.put(MOVE_Right1, false);
				mapy.put(MOVE_Right2, false);
				mapy.put(PAUSE, false);
			}
		}
	}

	public void playAll() {
		if(mapy.get(MOVE_Left1)){
		   	guiView.getCanvas().getPlayer1().moveLeft();
			guiView.getCanvas().repaint();
		}
		if(mapy.get(MOVE_Left2)){
			guiView.getCanvas().getPlayer2().moveLeft();
			guiView.getCanvas().repaint();
		}
		if(mapy.get(MOVE_Right1)){
			guiView.getCanvas().getPlayer1().moveRight();
			guiView.getCanvas().repaint();
		}
		if(mapy.get(MOVE_Right2)){
			guiView.getCanvas().getPlayer2().moveRight();
			guiView.getCanvas().repaint();
		}
		if(mapy.get(PAUSE)){
			// pause
		}
	}

	public KeyboardHandler(View guiView) {
		this.guiView = guiView;
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), MOVE_Left1);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), MOVE_Right1);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), PAUSE);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), MOVE_Left2);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), MOVE_Right2);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), MOVE_Left1_Released);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), MOVE_Right1_Released);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true), PAUSE_Released);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), MOVE_Left2_Released);
		this.guiView.getCanvas().getInputMap(IFW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), MOVE_Right2_Released);
		this.guiView.getCanvas().getActionMap().put(MOVE_Left1, LEFT1);
		this.guiView.getCanvas().getActionMap().put(MOVE_Right1, RIGHT1);
		this.guiView.getCanvas().getActionMap().put(MOVE_Left2, LEFT2);
		this.guiView.getCanvas().getActionMap().put(MOVE_Right2, RIGHT2);
		this.guiView.getCanvas().getActionMap().put(PAUSE, SPACE);
		this.guiView.getCanvas().getActionMap().put(MOVE_Left1_Released, LEFT1_RELEASED);
		this.guiView.getCanvas().getActionMap().put(MOVE_Left2_Released, LEFT2_RELEASED);
		this.guiView.getCanvas().getActionMap().put(MOVE_Right1_Released, RIGHT1_RELEASED);
		this.guiView.getCanvas().getActionMap().put(MOVE_Right2_Released, RIGHT2_RELEASED);
		this.guiView.getCanvas().getActionMap().put(PAUSE_Released, SPACE_RELEASED);
		mapy.put(MOVE_Left1, false);
		mapy.put(MOVE_Left2, false);
		mapy.put(MOVE_Right1, false);
		mapy.put(MOVE_Right2, false);
		mapy.put(PAUSE, false);
	}

	private void delay() {
		try {
			Thread.sleep(70);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

}
