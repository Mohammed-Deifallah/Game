package constants;

public class Constants {

	private static Constants instance;
	private String filePath;
	private int width;
	private int length;
	
	
	private Constants() {
		width = 20;
		length = 50;
		filePath = "bin/plates";
		read();
	}
	
	public static Constants getInstance() {
		if (instance == null) {
			instance = new Constants();
		}
		return instance;
	}
	
	private void read() {
		
	}
	
	public String getFilePath() {
		return filePath;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getWidth() {
		return width;
	}
	
}