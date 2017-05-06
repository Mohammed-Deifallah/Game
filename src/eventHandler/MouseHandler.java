package eventHandler;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import gui.Control;
import gui.Model;
import gui.View;
import gui.diffLevel;

public class MouseHandler implements MouseInputListener {

	Model guiModel;
	View guiView;
	Control guiControl;

	public MouseHandler(Model guiModel, View guiView , Control guiControl) {
		this.guiModel = guiModel;
		this.guiView = guiView;
		this.guiControl = guiControl;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(guiView.getBack())) {
			guiModel.setLevel((diffLevel) guiView.getDifficulity().getSelectedItem());
			guiView.doWithBack();
		} else if (e.getSource().equals(guiView.getOptionButton()))
			guiView.doWithOptionButton();
		else if (e.getSource().equals(guiView.getPlayButton())) {
			guiView.doWithPlayButton();
			guiControl.GameActionListeners();
			guiControl.playersActionListener();
		} else if (e.getSource().equals(guiView.getBack2()))
			guiView.doWithBack2();
		else if (e.getSource().equals(guiView.getPlayPause()))
			guiModel.doWithPlayPause();
		else if (e.getSource().equals(guiView.getLevelDown()))
			guiModel.levelDown();
		else if (e.getSource().equals(guiView.getLevelUp()))
			guiModel.levelUp();
		else if (e.getSource().equals(guiView.getMenuLoad()))
			guiModel.load();
		else if (e.getSource().equals(guiView.getSave()))
			guiModel.save();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
