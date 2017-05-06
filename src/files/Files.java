package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Files {
	
	private static Files filesInst ;
	
	private String path;

	private Files() {
		path = System.getProperty("user.home");
	}

	public static Files getInstance(){
		if(filesInst==null)
			filesInst = new Files();
		return filesInst;
	}
	
	public void createFiles() {
		File[] data = new File(path).listFiles();
		for (File db : data) {
			if (db.getName().equals("Game")) {
				return;
			}
		}
		File game = new File(path + File.separator + "Game");
		game.mkdirs();
		createFile(game, "player1.xml");
		createFile(game, "player2.xml");
		createFile(game, "player1leftstack.xml");
		createFile(game, "player2leftstack.xml");
		createFile(game, "player1rightstack.xml");
		createFile(game, "player2rightstack.xml");
		createFile(game, "flying.xml");
		createFile(game, "upleftshelf.xml");
		createFile(game, "downleftshelf.xml");
		createFile(game, "uprightshelf.xml");
		createFile(game, "downrightshelf.xml");
		createFile(game, "pool.xml");
		createFile(game, "level.xml");
	}

	private void createFile(File game, String name) {
		try {
			FileWriter writer = new FileWriter(game.getAbsolutePath() + File.separator + name);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getFile(String name) {
		File[] data = new File(path).listFiles();
		for (File db : data) {
			if (db.getName().equals("Game")) {
				File[] data2 = db.listFiles();
				for (File d : data2) {
					if (d.getName().equals(name)) {
						return d;
					}
				}
			}
		}
		return null;
	}

	public File getFlying() {
		return getFile("flying.xml");
	}

	public File getPlayer1Place() {
		return getFile("player1.xml");
	}

	public File getPlayer2Place() {
		return getFile("player2.xml");
	}

	public File getPlayer1LeftStack() {
		return getFile("player1leftstack.xml");
	}

	public File getPlayer1RightStack() {
		return getFile("player1rightstack.xml");
	}

	public File getPlayer2LeftStack() {
		return getFile("player2leftstack.xml");
	}

	public File getPlayer2RightStack() {
		return getFile("player2rightstack.xml");
	}

	public File getUpLeftShelf() {
		return getFile("upleftshelf.xml");
	}

	public File getDownLeftShelf() {
		return getFile("downleftshelf.xml");
	}

	public File getUpRightShelf() {
		return getFile("uprightshelf.xml");
	}

	public File getDownRightShelf() {
		return getFile("downrightshelf.xml");
	}

	public File getPool() {
		return getFile("pool.xml");
	}

	public File getLevel() {
		return getFile("level.xml");
	}
}