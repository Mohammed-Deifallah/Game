package player;

import java.awt.Point;

import log4j.Log4j;

public class playerBuilder {

	public Player getPlayer1(String name,Point center,int length,int hieght,int maxX,int minX , int maxY){
		Player player1 = new Player(name, center, length, hieght, maxX, minX,maxY);
		playerDecorator play1dec = new player1Decorator(player1);
		play1dec.attachImage();
		Log4j.getInstance().info("Player 1 has been built");
		return player1;
	}

	public Player getPlayer2(String name,Point center,int length,int hieght,int maxX,int minX,int maxY){
		Player player2 = new Player(name, center, length, hieght, maxX, minX,maxY);
		playerDecorator play2dec = new player2Decorator(player2);
		play2dec.attachImage();
		Log4j.getInstance().info("Player 2 has been built");
		return player2;
	}
	
}
