package gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

import controller.Controller;
import differentGroupsOfPlates.FlyingPlates;
import differentGroupsOfPlates.Shelf;
import differentGroupsOfPlates.Shelf.ShelfLeftRight;
import log4j.Log4j;
import player.Player;
import player.playerBuilder;

public class DrawCanvas extends JPanel {

	private playerBuilder builder = new playerBuilder();
	private Player player1;
	private Player player2;
	private Shelf UpLeftShelf, upRightShelf, DownLeftShelf, DownRightShelf;
	private FlyingPlates flying;
	private Controller control;
	private View fatherView; 
	
	public View getFatherView() {
		return fatherView;
	}

	public FlyingPlates getFlying() {
		return flying;
	}

	public void setFlying(FlyingPlates flying) {
		this.flying = flying;
	}

	public playerBuilder getBuilder() {
		return builder;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public Shelf getUpLeftShelf() {
		return UpLeftShelf;
	}

	public Shelf getUpRightShelf() {
		return upRightShelf;
	}

	public Controller getControl() {
		return control;
	}

	public Shelf getDownLeftShelf() {
		return DownLeftShelf;
	}

	public Shelf getDownRightShelf() {
		return DownRightShelf;
	}
	
	public void setBuilder(playerBuilder builder) {
		this.builder = builder;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void setUpLeftShelf(Shelf upLeftShelf) {
		UpLeftShelf = upLeftShelf;
	}

	public void setUpRightShelf(Shelf upRightShelf) {
		this.upRightShelf = upRightShelf;
	}

	public void setDownLeftShelf(Shelf downLeftShelf) {
		DownLeftShelf = downLeftShelf;
	}

	public void setDownRightShelf(Shelf downRightShelf) {
		DownRightShelf = downRightShelf;
	}

	public void setControl(Controller control) {
		this.control = control;
	}

	public void setFatherView(View fatherView) {
		this.fatherView = fatherView;
	}

	public DrawCanvas(View fatherView) {
		this.fatherView = fatherView;
		this.setOpaque(false);
		this.setBounds(0, 126, 1295, 821);
		UpLeftShelf = new Shelf(new Point(275, 150), 35, 550, ShelfLeftRight.LEFT);
		upRightShelf = new Shelf(new Point(this.getWidth() - 275, 150), 35, 550, ShelfLeftRight.RIGHT);
		DownLeftShelf = new Shelf(new Point(200, 250), 35, 400, ShelfLeftRight.LEFT);
		DownRightShelf = new Shelf(new Point(this.getWidth() - 200, 250), 35, 400, ShelfLeftRight.RIGHT);
		player1 = builder.getPlayer1("player1", new Point(150, this.getHeight()), 130, 95, this.getWidth(), 0 , DownLeftShelf.getCenter().y);
		player2 = builder.getPlayer2("player2", new Point(this.getWidth() - 150, this.getHeight()), 130, 95,
				this.getWidth(), 0 , DownLeftShelf.getCenter().y );
		this.flying = new FlyingPlates();
		this.control = new Controller(this);
		Log4j.getInstance().info("Draw canvas has been drawn and class is populated");
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		player1.draw(g2);
		player2.draw(g2);
		UpLeftShelf.draw(g2);
		upRightShelf.draw(g2);
		DownLeftShelf.draw(g2);
		DownRightShelf.draw(g2);
		flying.draw(g2);
	}

}
