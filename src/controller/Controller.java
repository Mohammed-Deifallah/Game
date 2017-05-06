package controller;

import java.util.ArrayList;

import differentGroupsOfPlates.FlyingPlates;
import differentGroupsOfPlates.IPlatesPool;
import differentGroupsOfPlates.PlatesPool;
import gui.DrawCanvas;
import gui.playPaused;
import plateStates.DifferentPlateStates.PlateStates;
import plates.IShape;

public class Controller extends Thread {

	DrawCanvas canvas;
	IPlatesPool pool;


	public void setPool(IPlatesPool pool) {
		this.pool = pool;
	}

	public Controller(DrawCanvas canvas) {
		this.canvas = canvas;
		pool = PlatesPool.getInstance();
		this.start();
	}

	public DrawCanvas getCanvas() {
		return canvas;
	}

	public IPlatesPool getPool() {
		return pool;
	}

	@Override
	public void run() {
		while (true) {
			if(canvas.getFatherView().getModel().getGamestate().equals(playPaused.Play)){
				switch (canvas.getFatherView().getModel().getLevel()) {
				case Easy:
					delayEasy();					
					break;
				case Medium:
					delayMedium();
					break;
				case Hard:
					delayHard();
					break;
				default:
					break;
				}
				checkPlayers();
				playFlying();
				playShelves();
				getOutSidePlates();
				canvas.repaint();
			}
		}
	}
	
	private synchronized void checkPlayers(){		
		ArrayList<IShape> flying =  canvas.getFlying().getPlates();
		for(int i=0 ; i<flying.size() ; i++){
			if(canvas.getPlayer1().addPlate(flying.get(i))){
				flying.remove(flying.get(i));
				i--;
			}
			else if(canvas.getPlayer2().addPlate(flying.get(i))){
				flying.remove(flying.get(i));
				i--;
			}
		}
		canvas.getPlayer1().getUnusedPlates();
		canvas.getPlayer2().getUnusedPlates();
	}

	private void delayEasy() {
		try {
		    Thread.sleep(10);                 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}

	private void delayMedium() {
		try {
		    Thread.sleep(5);                 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	private void delayHard() {
		try {
		    Thread.sleep(1);                 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	private synchronized void playFlying() {
		canvas.getFlying().moveAllPlates();
	}

	private synchronized void getOutSidePlates(){
		ArrayList<IShape> flying = canvas.getFlying().getPlates();
		for(int i=0 ; i<flying.size() ; i++){
			if(flying.get(i).getCenter().y > this.canvas.getHeight()){
				IShape unused = flying.get(i); 
				unused.setState(PlateStates.OUTSIDE);
				pool.addUnusedPlate(unused);
				flying.remove(unused);
				i--;
			}
		}
	}
	
	private synchronized void playShelves() {
		FlyingPlates flying = canvas.getFlying();
		canvas.getDownRightShelf().moveAllPlates();
		canvas.getDownRightShelf().addPlate(pool.getPlate());
		IShape unused = canvas.getDownRightShelf().getUnusedPlates();
		if (unused != null)
			flying.addPlate(unused);
		canvas.getDownLeftShelf().moveAllPlates();
		canvas.getDownLeftShelf().addPlate(pool.getPlate());
		unused = canvas.getDownLeftShelf().getUnusedPlates();
		if (unused != null)
			flying.addPlate(unused);
		canvas.getUpLeftShelf().moveAllPlates();
		canvas.getUpLeftShelf().addPlate(pool.getPlate());
		unused = canvas.getUpLeftShelf().getUnusedPlates();
		if (unused != null)
			flying.addPlate(unused);
		canvas.getUpRightShelf().moveAllPlates();
		canvas.getUpRightShelf().addPlate(pool.getPlate());
		unused = canvas.getUpRightShelf().getUnusedPlates();
		if (unused != null)
			flying.addPlate(unused);
		if(canvas.getFatherView().getPlayer1Score()!=null && canvas.getPlayer1().getScore().getScoreValue()!=0)canvas.getFatherView().getPlayer1Score().setText(String.valueOf(canvas.getPlayer1().getScore().getScoreValue()));
		if(canvas.getFatherView().getPlayer2Score()!=null && canvas.getPlayer2().getScore().getScoreValue()!=0)canvas.getFatherView().getPlayer2Score().setText(String.valueOf(canvas.getPlayer2().getScore().getScoreValue()));
	}
}
