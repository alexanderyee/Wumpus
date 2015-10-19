package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Game;

public class TextView extends JPanel implements Observer{
	private Game game;
	private String board;
	
	
	@Override
	public void update(Observable o, Object arg) {
		game = (Game) o;
		
		
	}

}
