package view;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import model.Game;

public class GraphicalView extends JPanel implements Observer {
	private Game game;
	public GraphicalView(Game game) {
		this.game = game;
	}

	@Override
	public void update(Observable o, Object arg) {
		
		
	}

}
