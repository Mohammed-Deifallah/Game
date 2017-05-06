package player;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class player1Decorator implements playerDecorator{

	BufferedImage im ;
	Player player1;
	
	public player1Decorator(Player player1) {
		this.player1 = player1;
	}
	
	@Override
	public void attachImage() {
		try {
			im = ImageIO.read(super.getClass().getResource("/Accessories/player.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		player1.setImage(im);
	}

}
