package loading;

import java.io.File;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;

import differentGroupsOfPlates.FlyingPlates;
import differentGroupsOfPlates.IPlatesPool;
import differentGroupsOfPlates.PlatesPool;
import differentGroupsOfPlates.Shelf;
import differentGroupsOfPlates.Stack;
import gui.diffLevel;
import player.Player;

public class Load {

	private static Load instance;

	private Load() {

	}

	public static Load getInstance() {
		if (instance == null) {
			instance = new Load();
		}
		return instance;
	}

	// public GameState load() {
	// return null;
	// }

	public Player loadPlayer1(File player1) {
		Player player;
		try {
			Scanner in = new Scanner(player1);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			player = (Player) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return player;
	}

	public Player loadPlayer2(File player2) {
		Player player;
		try {
			Scanner in = new Scanner(player2);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			player = (Player) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return player;
	}

	public Shelf loadUpLeftShelf(File upleftshelf) {
		Shelf shelf;
		try {
			Scanner in = new Scanner(upleftshelf);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			shelf = (Shelf) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return shelf;
	}

	public Shelf loadDownLeftShelf(File downleftshelf) {
		Shelf shelf;
		try {
			Scanner in = new Scanner(downleftshelf);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			shelf = (Shelf) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return shelf;
	}

	public Shelf loadUpRightShelf(File uprightshelf) {
		Shelf shelf;
		try {
			Scanner in = new Scanner(uprightshelf);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			shelf = (Shelf) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return shelf;
	}

	public Shelf loadDownRightShelf(File downrightshelf) {
		Shelf shelf;
		try {
			Scanner in = new Scanner(downrightshelf);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			shelf = (Shelf) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return shelf;
	}

	public Stack loadPlayer1RightStack(File stack) {
		Stack s;
		try {
			Scanner in = new Scanner(stack);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			s = (Stack) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return s;
	}

	public Stack loadPlayer2LeftStack(File stack) {
		Stack s;
		try {
			Scanner in = new Scanner(stack);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			s = (Stack) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return s;
	}

	public Stack loadPlayer2RightStack(File stack) {
		Stack s;
		try {
			Scanner in = new Scanner(stack);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			s = (Stack) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return s;
	}

	public Stack loadPlayer1LeftStack(File stack) {
		Stack s;
		try {
			Scanner in = new Scanner(stack);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			s = (Stack) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return s;
	}

	public FlyingPlates loadFlying(File flying) {
		FlyingPlates f;
		try {
			Scanner in = new Scanner(flying);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			f = (FlyingPlates) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return f;
	}

	public IPlatesPool loadPool(File pool) {
		PlatesPool p;
		try {
			Scanner in = new Scanner(pool);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			p = (PlatesPool) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return p;
	}
	public diffLevel loadLevel(File level) {
		diffLevel l;
		try {
			Scanner in = new Scanner(level);
			XStream xstream = new XStream();
			String temp = in.useDelimiter("\\Z").next();
			l = (diffLevel) xstream.fromXML(temp);
			in.close();
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return l;
	}
}