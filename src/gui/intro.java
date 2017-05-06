package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Panel;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class intro extends Thread{

	private JFrame frame;
	private JProgressBar progressBar;
	
	
	
	public intro(){
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.textInactiveText);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(intro.class.getResource("/Accessories/path.png")));
		lblNewLabel.setBounds(264, 139, 459, 341);
		panel.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setIndeterminate(true);
		progressBar.setBackground(new Color(255, 0, 0));
		progressBar.setStringPainted(true);
		progressBar.setBounds(264, 552, 459, 30);
		panel.add(progressBar);
		frame.setBackground(SystemColor.controlShadow);
		frame.setBounds(100, 100, 1090, 710);
		frame.setUndecorated(true);
		frame.setOpacity(0.9f);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		this.start();
	}

	@Override
	public void run(){
		long time = System.currentTimeMillis()/1000;
		while(System.currentTimeMillis()/1000-time < 10){
			progressBar.setValue((int)((double)(System.currentTimeMillis()/1000-time)*100.0/10));
		}
		frame.setVisible(false);
		frame.disable();
		frame.dispose();
		this.stop();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				intro ne = new intro();
			}
		});
	}
}
