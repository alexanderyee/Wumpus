package view;

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
import javax.swing.Timer;

import model.Direction;
import model.Game;

public class GraphicalView extends JPanel implements Observer {
	private Game game;
	private Image blood, goop, ground, slime, pit, hunter, wumpus;
	private Direction direction;
	private int X, Y;
	private Timer timer;

	public GraphicalView(Game game) {
		this.game = game;
		X = game.getPoint().x;
		Y = game.getPoint().y;
		try {
			hunter = ImageIO.read(new File("./images/TheHunter.png"));
			ground = ImageIO.read(new File("./images/Ground.png"));
			blood = ImageIO.read(new File("./images/Blood.png"));
			goop = ImageIO.read(new File("./images/Goop.png"));
			slime = ImageIO.read(new File("./images/Slime.png"));
			pit = ImageIO.read(new File("./images/SlimePit.png"));
			wumpus = ImageIO.read(new File("./images/Wumpus.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}

	@Override
	public void update(Observable o, Object arg) {
		game = (Game) o;
		direction = (Direction) arg;
		drawAnimatedBoard();
	}

	private void drawAnimatedBoard() {
		timer = new Timer(40, new DrawTimerListener());
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		// Draw background image 100 times
		for (int r = 0; r < 500; r += 50)
			for (int c = 0; c < 500; c += 50)
				g2.drawImage(ground, r, c, null);

		System.out.println(X + " " + Y);
		g2.drawImage(hunter, X, Y, null);
	}

	class DrawTimerListener implements ActionListener {
		private int tic = 0;

		@Override
		public void actionPerformed(ActionEvent e) {

			tic++;
			if (tic >= 25) {
				timer.stop();
				return;
			}
			if (direction == Direction.EAST)
				X += 2;
			else if (direction == Direction.WEST)
				X -= 2;
			else if (direction == Direction.WEST)
				X -= 2;
			else if (direction == Direction.SOUTH)
				Y += 2;
			else
				Y -= 2;

			repaint();
		}

	}

}
