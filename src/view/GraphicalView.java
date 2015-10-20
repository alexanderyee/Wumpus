package view;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import model.Direction;
import model.Element;
import model.Game;
// Alex Yee
public class GraphicalView extends JPanel implements Observer {
	private Game game;
	private Image blood, goop, ground, slime, pit, hunter, wumpus, dark;
	private Direction direction;
	private int X, Y;
	private Timer timer;
	public static int TILE_SIZE = 50;
	private JTextArea jta;
	public GraphicalView(Game game) {
		this.game = game;
		X = game.getPoint().x%500;
		Y = game.getPoint().y%500;
		jta = new JTextArea();
		add(jta, BorderLayout.SOUTH);
		try {
			hunter = ImageIO.read(new File("./images/TheHunter.png"));
			ground = ImageIO.read(new File("./images/Ground.png"));
			blood = ImageIO.read(new File("./images/Blood.png"));
			goop = ImageIO.read(new File("./images/Goop.png"));
			slime = ImageIO.read(new File("./images/Slime.png"));
			pit = ImageIO.read(new File("./images/SlimePit.png"));
			wumpus = ImageIO.read(new File("./images/Wumpus.png"));
			dark = ImageIO.read(new File("./images/dark.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		game = (Game) o;
		direction = (Direction) arg;
		jta.setText(game.getMessage());
		drawAnimatedBoard();
	}

	private void drawAnimatedBoard() {
		
		timer = new Timer(40, new DrawTimerListener());
		timer.start();
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int r = 0; r < 500; r += 50)
			for (int c = 0; c < 500; c += 50)
				g2.drawImage(ground, r, c, null);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (!game.map.getRoom(i, j).isVisible())
					g2.drawImage(dark, j * TILE_SIZE, i * TILE_SIZE, null);
				else if (game.map.getSecondElement(i, j) == Element.BLOOD){
					g2.drawImage(blood, j * TILE_SIZE, i * TILE_SIZE, null);
				}
				else if (game.map.getSecondElement(i, j) == Element.SLIME)
					g2.drawImage(slime, j * TILE_SIZE, i * TILE_SIZE, null);
				else if (game.map.getSecondElement(i, j) == Element.GOOP)
					g2.drawImage(goop, j * TILE_SIZE, i * TILE_SIZE, null);
				else if (game.map.getSecondElement(i, j) == Element.PIT)
					g2.drawImage(pit, j * TILE_SIZE, i * TILE_SIZE, null);
				else if (game.map.getSecondElement(i, j) == Element.WUMPUS)
					g2.drawImage(wumpus, j * TILE_SIZE, i * TILE_SIZE, null);
				else if (game.map.getRoom(i, j).isVisible())
					g2.drawImage(ground, j * TILE_SIZE, i * TILE_SIZE, null);
			}

		}
		//System.out.println(X + " " + Y);
		g2.drawImage(hunter, X, Y, null);
		if (!game.getStatus()){
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					
					if (game.map.getSecondElement(i, j) == Element.BLOOD || game.map.getElement(i, j) == Element.BLOOD){
						g2.drawImage(blood, j * TILE_SIZE, i * TILE_SIZE, null);
					}
					else if (game.map.getSecondElement(i, j) == Element.SLIME || game.map.getElement(i, j) == Element.SLIME)
						g2.drawImage(slime, j * TILE_SIZE, i * TILE_SIZE, null);
					else if (game.map.getSecondElement(i, j) == Element.GOOP || game.map.getElement(i, j) == Element.GOOP)
						g2.drawImage(goop, j * TILE_SIZE, i * TILE_SIZE, null);
					else if (game.map.getSecondElement(i, j) == Element.PIT || game.map.getElement(i, j) == Element.PIT)
						g2.drawImage(pit, j * TILE_SIZE, i * TILE_SIZE, null);
					else if (game.map.getSecondElement(i, j) == Element.WUMPUS || game.map.getElement(i, j) == Element.WUMPUS)
						g2.drawImage(wumpus, j * TILE_SIZE, i * TILE_SIZE, null);
					
				}

			}
		}
			
	}

	class DrawTimerListener implements ActionListener {
		private int tic = 0;

		@Override
		public void actionPerformed(ActionEvent e) {

			tic++;
			if (tic > 25) {
				timer.stop();
				return;
			}
			if (direction == Direction.NORTH)
				Y-=2;
			else if (direction == Direction.EAST)
				X += 2;
			else if (direction == Direction.WEST)
				X -= 2;
			else if (direction == Direction.SOUTH)
				Y += 2;
			
			X= (X+500)%500;
			Y = (Y+500)%500;
			repaint();
		}

	}

}
