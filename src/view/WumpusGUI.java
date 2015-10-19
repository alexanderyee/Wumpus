package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import model.Game;

public class WumpusGUI extends JFrame {
	
	public static void main(String[] args) {
		WumpusGUI window = new WumpusGUI();
		window.setVisible(true);
	}
	
	private TextView textPanel;
	private GraphicalView imagePanel;
	private Game game;
	private JTabbedPane tPane;
	
	public WumpusGUI() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocation(100, 30);
		game = new Game();
		imagePanel = new GraphicalView(game);
		textPanel = new TextView(game);
		tPane = new JTabbedPane();
		tPane.add("Images", imagePanel);
		tPane.add("Text", textPanel);
		add(tPane, BorderLayout.CENTER);
		game.addObserver(imagePanel);
		game.addObserver(textPanel);
	}
}
