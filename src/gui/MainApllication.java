package gui;

import javax.swing.SwingUtilities;

public class MainApllication {

	public static void main(String args[]){
	
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new intro();
			}
			
		});
		long time = System.currentTimeMillis()/1000;
		while(System.currentTimeMillis()/1000-time < 10.5){
		}
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				View guiView;
				Model guiModel = new Model();
				guiView = new View(guiModel);
				Control guiControl = new Control(guiModel, guiView);
			}
		});
		
		
		
	}
	
}
