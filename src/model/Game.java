package model;

import java.awt.Point;
import java.util.Observable;
import java.util.Random;

public class Game extends Observable {
	private int row, col;
	public static int TILE_SIZE = 50;
	private Random r;
	public Map map;
	private boolean gameStatus;

	public Game(Random r) {
		this.r = r;
		map = new Map(r);
		findHunter();
		gameStatus = true;
	}

	public Game() {
		r = new Random();
		map = new Map(r);
		findHunter();
		gameStatus = true;
	}

	public Game(Random r, Map map) {
		this.r = r;
		this.map = map;
		findHunter();
		gameStatus = true;
	}

	public void moveHunter(Direction d) {
		if (gameStatus) {
			map.getRoom(row, col).changeElement(Element.NOTHING);
			if (d == Direction.NORTH)
				row--;
			if (d == Direction.EAST)
				col++;
			if (d == Direction.SOUTH)
				row++;
			if (d == Direction.WEST)
				col--;
			row = (row + 10) % 10;
			col = (col + 10) % 10;
			map.getRoom(row, col).changeElement(Element.HUNTER);
			map.getRoom(row, col).makeVisible();
			setChanged();
			notifyObservers(d);
			checkGameOver();
		}
	}

	public boolean checkGameOver() {
		if (map.getSecondElement(row,col) == Element.WUMPUS || map.getSecondElement(row, col) == Element.PIT)
			gameStatus = false;
		return gameStatus;
	}

	public boolean shootArrow(Direction d) {
		if (d == Direction.NORTH || d == Direction.SOUTH) {
			for (int i = 0; i < 10; i++) {
				if (map.getElement(i, this.col) == Element.WUMPUS){
					gameStatus = false;
					return true;
				}
			}

		} else {
			for (int i = 0; i < 10; i++) {
				if (map.getElement(this.row, i) == Element.WUMPUS){
					gameStatus = false;
					return true;
				}
			}
		}
		return false;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return col;
	}

	public void findHunter() { // finds hunter position after random generation
								// of map
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map.getElement(i, j) == Element.HUNTER) {
					this.row = i;
					this.col = j;
				}
			}
		}
	}

	public Point getPoint() {
		return new Point(col * TILE_SIZE, row * TILE_SIZE);
	}
}
