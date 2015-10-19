package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicArrowButton;

import model.Direction;
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
	private JPanel controller;
	private JPanel controller2;
	private BasicArrowButton mUp;
	private BasicArrowButton mDown;
	private BasicArrowButton mLeft;
	private BasicArrowButton mRight;
	private BasicArrowButton sUp;
	private BasicArrowButton sDown;
	private BasicArrowButton sLeft;
	private BasicArrowButton sRight;
	private JLabel move;
	private JLabel shoot;
	
	public WumpusGUI() {
		this.setTitle("Hunt The Wumpus - Alex Yee");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(1000, 500);
		setLocation(100, 30);
		game = new Game();
		imagePanel = new GraphicalView(game);
		textPanel = new TextView(game);
		tPane = new JTabbedPane();
		tPane.add("Images", imagePanel);
		tPane.add("Text", textPanel);
		tPane.setSize(800,500);
		tPane.setLocation(200, 0);
		add(tPane);
		game.addObserver(imagePanel);
		game.addObserver(textPanel);
		
		setControllerLayout();
		add(controller);
		add(controller2);
	}
	private void setControllerLayout() {
		controller = new JPanel();
		controller.setLocation(0,300);
		controller.setSize(200,100);
		controller2 = new JPanel();
		controller2.setLocation(0, 400);
		controller2.setSize(200,100);
		BoxLayout bl = new BoxLayout(controller, BoxLayout.PAGE_AXIS);
		BoxLayout bl2 = new BoxLayout(controller2, BoxLayout.PAGE_AXIS);
		controller.setLayout(bl);
		controller2.setLayout(bl2);
		FlowLayout layout1 = new FlowLayout();
		JPanel jp1 = new JPanel();
		JPanel jp2 = new JPanel();
		JPanel jp3 = new JPanel();
		JPanel jp4 = new JPanel();
		JPanel jp5 = new JPanel();
		JPanel jp6 = new JPanel();
		JPanel jp7 = new JPanel();
		jp1.setLayout(layout1);
		jp2.setLayout(layout1);
		jp3.setLayout(layout1);
		jp4.setLayout(layout1);
		jp5.setLayout(layout1);
		jp6.setLayout(layout1);
		jp7.setLayout(layout1);
		move = new JLabel("Move");
		shoot = new JLabel("Shoot");
		// moving buttons
		mUp = new BasicArrowButton(BasicArrowButton.NORTH);
		mUp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.moveHunter(Direction.NORTH);
			}
			
		});
		mDown = new BasicArrowButton(BasicArrowButton.SOUTH);
		mDown.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.moveHunter(Direction.SOUTH);
			}
			
		});
		mLeft = new BasicArrowButton(BasicArrowButton.WEST);
		mLeft.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.moveHunter(Direction.WEST);
			}
			
		});
		mRight = new BasicArrowButton(BasicArrowButton.EAST);
		mRight.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.moveHunter(Direction.EAST);
			}
			
		});
		// shooting buttons
		sUp = new BasicArrowButton(BasicArrowButton.NORTH);
		sUp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.shootArrow(Direction.NORTH);
			}
			
		});
		sDown = new BasicArrowButton(BasicArrowButton.SOUTH);
		sDown.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.shootArrow(Direction.SOUTH);
			}
			
		});
		sLeft = new BasicArrowButton(BasicArrowButton.WEST);
		sLeft.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.shootArrow(Direction.WEST);
			}
			
		});
		sRight = new BasicArrowButton(BasicArrowButton.EAST);
		sRight.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				game.shootArrow(Direction.EAST);
			}
			
		});
		
		jp1.add(move);
		jp2.add(mUp);
		jp3.add(mLeft);
		jp3.add(mDown);
		jp3.add(mRight);
		jp4.add(shoot);
		jp5.add(sUp);
		jp6.add(sLeft);
		jp6.add(sDown);
		jp6.add(sRight);
		
		controller.add(jp1);
		controller.add(jp2);
		controller.add(jp3);
		controller2.add(jp4);
		controller2.add(jp5);
		controller2.add(jp6);
		controller2.add(jp7);
	}
}
