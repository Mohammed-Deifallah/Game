package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import classLoader.ClassLoader;
import log4j.Log4j;

public class View {

	private Model model;
	public Model getModel() {
		return model;
	}

	private JFrame gameFrame,menuFrame,optionFrame ;
	private JPanel panel ;
	private JButton MenuLoad,playButton,playPause,levelDown,levelUp,save,back,back2,optionButton;
	private JComboBox<diffLevel> difficulity;
	private DrawCanvas canvas ;
	private Label diffLabel ;
	private intro in ;
	private JLabel lblNewLabel,label2,player1Score,player2Score;
	

	public View(Model model){
		this.model = model;
		drawMenu();
		drawMenuButtons();
		drawOptionFrame();
		drawOptionButtons();
		newGame();
		model.setLevel((diffLevel) difficulity.getSelectedItem());
		model.setGuiView(this);
		Log4j.getInstance().info("game has begin with diffculity : " + difficulity.getSelectedItem().toString());
	}

	public JLabel getPlayer1Score() {
		return player1Score;
	}
	
	public JLabel getPlayer2Score() {
		return player2Score;
	}

	public JFrame getGameFrame() {
		return gameFrame;
	}

	public JFrame getMenuFrame() {
		return menuFrame;
	}

	public JFrame getOptionFrame() {
		return optionFrame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getMenuLoad() {
		return MenuLoad;
	}

	public JButton getPlayButton() {
		return playButton;
	}

	public JButton getPlayPause() {
		return playPause;
	}

	public JButton getLevelDown() {
		return levelDown;
	}

	public JButton getLevelUp() {
		return levelUp;
	}

	public JButton getSave() {
		return save;
	}

	public JButton getBack() {
		return back;
	}

	public JButton getBack2() {
		return back2;
	}

	public JButton getOptionButton() {
		return optionButton;
	}

	public JComboBox<diffLevel> getDifficulity() {
		return difficulity;
	}

	public DrawCanvas getCanvas() {
		return canvas;
	}

	public Label getDiffLabel() {
		return diffLabel;
	}

	public intro getIn() {
		return in;
	}

	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}

	public JLabel getLabel2() {
		return label2;
	}

	public void drawOptionFrame(){
		optionFrame = new JFrame();
		optionFrame.getContentPane().setBackground(SystemColor.textHighlight);
		optionFrame.setBounds(100, 100, 1311, 786+200);
		optionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		optionFrame.getContentPane().setLayout(null);
		optionFrame.setVisible(false);
		optionFrame.setResizable(false);
		Log4j.getInstance().info("OptionFrame has been drawn");
	}
	
	public void drawMenu(){
		menuFrame = new JFrame();
		menuFrame.getContentPane().setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		menuFrame.getContentPane().setBackground(SystemColor.textHighlight);
		menuFrame.setBounds(50, 50, 1311, 786+200);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuFrame.getContentPane().setLayout(null);
		menuFrame.setVisible(true);
		menuFrame.requestFocusInWindow();
		menuFrame.setResizable(false);
		Log4j.getInstance().info("Menuframe has been drawn");
	}

	public void drawGameFrame(){
		gameFrame = new JFrame();
		gameFrame.getContentPane().setBackground(SystemColor.textHighlight);
		gameFrame.setBounds(50, 50, 1311, 786+200);
		gameFrame.getContentPane().setLayout(null);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		gameFrame.setVisible(false);
		gameFrame.setResizable(false);
		Log4j.getInstance().info("Gameframe has been drawn");
	}

	public void drawCanvas(){
		canvas = new DrawCanvas(this) ;
		gameFrame.getContentPane().add(canvas);
	}
	
	public void newGame(){
		drawGameFrame();
		drawGamePanel();
		drawCanvas();
		drawGameButtons();
	}
	
	public void drawGamePanel(){
		panel = new JPanel();
		panel.setBackground(new Color(70, 130, 180));
		panel.setBounds(0, 0, 1311, 70);
		gameFrame.getContentPane().add(panel);
		panel.setLayout(null);
	}
	
	public void drawOptionButtons(){
		back = new JButton("");
		back.setIcon(new ImageIcon(super.getClass().getResource("/Accessories/left-arrow.png")));
		back.setForeground(new Color(60, 179, 113));
		back.setBackground(new Color(144, 238, 144));
		back.setBounds(571, 372, 74, 44);
		optionFrame.getContentPane().add(back);
		
		difficulity = new JComboBox();
		difficulity.addItem(diffLevel.Easy);
		difficulity.addItem(diffLevel.Medium);
		difficulity.addItem(diffLevel.Hard);
		difficulity.setBounds(609, 282, 159, 44);
		optionFrame.getContentPane().add(difficulity);
		
		diffLabel = new Label("Difficulity");
		diffLabel.setAlignment(Label.CENTER);
		diffLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		diffLabel.setBounds(446, 282, 113, 44);
		optionFrame.getContentPane().add(diffLabel);
		Log4j.getInstance().info("Components of option frame has been drawn");
	}

	public void drawGameButtons(){
		playPause = new JButton("");
		playPause.setBackground(new Color(255, 218, 185));
		playPause.setIcon(new ImageIcon(super.getClass().getResource("/Accessories/pause-play-button.png")));
		playPause.setBounds(0, 0, 249, 70);
		panel.add(playPause);
		
		levelDown = new JButton("");
		levelDown.setBounds(763, 0, 272, 70);
		panel.add(levelDown);
		levelDown.setIcon(new ImageIcon(super.getClass().getResource("/Accessories/down-arrow.png")));
		levelDown.setBackground(new Color(255, 218, 185));
		
		levelUp = new JButton("");
		levelUp.setBounds(514, 0, 250, 70);
		panel.add(levelUp);
		levelUp.setIcon(new ImageIcon(super.getClass().getResource("/Accessories/up-arrow.png")));
		levelUp.setBackground(new Color(255, 218, 185));
		
		save = new JButton("");
		save.setBounds(248, 0, 267, 70);
		panel.add(save);
		save.setIcon(new ImageIcon(super.getClass().getResource("/Accessories/save.png")));
		save.setBackground(new Color(255, 218, 185));
		
		back2 = new JButton("");
		back2.setIcon(new ImageIcon(super.getClass().getResource("/Accessories/left-arrow.png")));
		back2.setBackground(new Color(255, 218, 185));
		back2.setBounds(1034, 0, 270, 70);
		panel.add(back2);
		
		JLabel lblNewLabel = new JLabel("Player 1 :");
		lblNewLabel.setBackground(new Color(255, 218, 185));
		lblNewLabel.setForeground(new Color(255, 218, 185));
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblNewLabel.setBounds(346, 81, 125, 34);
		gameFrame.getContentPane().add(lblNewLabel);
		
		player1Score = new JLabel(canvas.getPlayer1().getScore().getScoreValue().toString());
		player1Score.setBackground(new Color(255, 218, 185));
		player1Score.setForeground(new Color(255, 218, 185));
		player1Score.setFont(new Font("MV Boli", Font.BOLD, 22));
		player1Score.setBounds(481, 81, 125, 34);
		gameFrame.getContentPane().add(player1Score);
		
		JLabel lblPlayer = new JLabel("PLayer 2 :");
		lblPlayer.setForeground(new Color(255, 218, 185));
		lblPlayer.setFont(new Font("MV Boli", Font.BOLD, 24));
		lblPlayer.setBackground(new Color(255, 218, 185));
		lblPlayer.setBounds(623, 81, 136, 34);
		gameFrame.getContentPane().add(lblPlayer);
		
		player2Score = new JLabel(canvas.getPlayer2().getScore().getScoreValue().toString());
		player2Score.setForeground(new Color(255, 218, 185));
		player2Score.setFont(new Font("MV Boli", Font.BOLD, 22));
		player2Score.setBackground(new Color(255, 218, 185));
		player2Score.setBounds(769, 81, 114, 34);
		gameFrame.getContentPane().add(player2Score);
		Log4j.getInstance().info("Components of Game frame has been drawn");
	}
	
	public void drawMenuButtons(){
		playButton = new JButton("PLAY");
		playButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		playButton.setBackground(new Color(255, 0, 51));
		playButton.setBounds(453, 230, 310, 64);
		menuFrame.getContentPane().add(playButton);

		MenuLoad = new JButton("Load");
		MenuLoad.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		MenuLoad.setBackground(new Color(255, 0, 51));
		MenuLoad.setBounds(453, 324, 310, 64);
		menuFrame.getContentPane().add(MenuLoad);

		optionButton = new JButton("OPTION");
		optionButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		optionButton.setBackground(new Color(255, 51, 0));
		optionButton.setBounds(453, 412, 310, 64);
		menuFrame.getContentPane().add(optionButton);
		
		
		label2 = new JLabel("");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setIcon(new ImageIcon(super.getClass().getResource("/Accessories/path-small.png")));
		label2.setBounds(453, 85, 310, 119);
		menuFrame.getContentPane().add(label2);
		
		lblNewLabel = new JLabel("Copy rights @ abdelrhman , ahmed , mohamed (2017)");
		lblNewLabel.setForeground(new Color(0, 102, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(431, 674, 358, 33);
		menuFrame.getContentPane().add(lblNewLabel);
		Log4j.getInstance().info("Components of Menu frame has been drawn");
	}
	
	
	public void doWithBack(){
		// TODO return from option view to menu view 
		Log4j.getInstance().info("transfering from option view to menu view");
		getMenuFrame().setBounds(getOptionFrame().getBounds());
		getOptionFrame().setVisible(false);
		getMenuFrame().setVisible(true);
		getMenuFrame().requestFocusInWindow();
	}
	
	public void doWithBack2(){
		// TODO return from game view to menu view
		Log4j.getInstance().info("transfering game view to menu view");
		getMenuFrame().setBounds(getGameFrame().getBounds());
		getGameFrame().dispose();
		getMenuFrame().setVisible(true);
		getMenuFrame().requestFocusInWindow();
	}
	
	public void doWithOptionButton(){
		// TODO action listener impl. for option button
		Log4j.getInstance().info("transfering menu view to option view");
		getOptionFrame().setBounds(getMenuFrame().getBounds());
		getMenuFrame().setVisible(false);
		getOptionFrame().setVisible(true);
		getOptionFrame().requestFocusInWindow();
	}
	
	public void doWithPlayButton(){
		// TODO action listener impl. for play button
		Log4j.getInstance().info("transfering menu view to game view : A new game started");
		ClassLoader.getInstance().loadClasses();
		newGame();
		getGameFrame().setBounds(getMenuFrame().getBounds());
		getMenuFrame().setVisible(false);
		getGameFrame().setVisible(true);
		getGameFrame().requestFocusInWindow();
	}
	
}
