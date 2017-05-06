package saving;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import gui.DrawCanvas;
import gui.View;
import player.Player;

public class Save {

	private static Save instance;

	private Save() {

	}

	public static Save getInstance() {
		if (instance == null) {
			instance = new Save();
		}
		return instance;
	}

	// public void save(GameState gameState) {
	//
	// }

	// Using Xstream to save the drawing of the plates, but a text file for
	// centers
	public synchronized void save(View view, File player1, File player2, File player1LeftPlates, File player1RightPlates,
			File player2LeftPlates, File player2RightPlates, File upLeftShelf, File downLeftShelf, File upRightShelf,
			File downRightShelf, File flying, File pool, File level) {
		saveObject(view.getModel().getLevel(), level);
		saveObject(view.getCanvas().getControl().getPool(), pool);
		savePlayers(view.getCanvas(), player1, player2);
		savePlayerPlates(view.getCanvas().getPlayer1(), player1LeftPlates, player1RightPlates);
		savePlayerPlates(view.getCanvas().getPlayer2(), player2LeftPlates, player2RightPlates);
		saveShelves(view.getCanvas(), upLeftShelf, downLeftShelf, upRightShelf, downRightShelf);
		saveObject(view.getCanvas().getFlying(), flying);
	}

	private void savePlayers(DrawCanvas canvas, File player1, File player2) {
		saveObject(canvas.getPlayer1(), player1);
		saveObject(canvas.getPlayer2(), player2);
	}

	private void savePlayerPlates(Player player, File playerLeftPlates, File playerRightPlates) {
		saveObject(player.getLeftStack(), playerLeftPlates);
		saveObject(player.getRightStack(), playerRightPlates);
	}

	private void saveShelves(DrawCanvas canvas, File upLeftShelf, File downLeftShelf, File upRightShelf,
			File downRightShelf) {
		saveObject(canvas.getUpLeftShelf(), upLeftShelf);
		saveObject(canvas.getDownLeftShelf(), downLeftShelf);
		saveObject(canvas.getUpRightShelf(), upRightShelf);
		saveObject(canvas.getDownRightShelf(), downRightShelf);
	}

	private void saveObject(Object plates, File file) {
		XStream xstream = new XStream(new StaxDriver());
		String s = xstream.toXML(plates);
		try {
			FileWriter file2 = new FileWriter(file);
			file2.write("");
			file2.write(s);
			file2.flush();
			file2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}