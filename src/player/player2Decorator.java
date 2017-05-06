package player;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class player2Decorator implements playerDecorator{

	BufferedImage im ;
	Player player2;
	
	public player2Decorator(Player player2) {
		this.player2 = player2;
	}
	
	@Override
	public void attachImage() {
		try {
			im = ImageIO.read(super.getClass().getResource("/Accessories/player2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		player2.setImage(im);
	}

}
