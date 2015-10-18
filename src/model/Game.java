package model;

import java.util.Observable;
import java.util.Random;

public class Game extends Observable{
	private int row, col;
	public static int TILE_SIZE = 50;
	private Random r;
	public Game(Random r){
		this.r = r;
	}
	public Game(){
		r = new Random();
	}

}
