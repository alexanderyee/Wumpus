package model;

import java.awt.Point;
import java.util.Observable;
import java.util.Random;
//Alex Yee
public class Game extends Observable {
	private int row, col;
	public static int TILE_SIZE = 50;
	private Random r;
	public Map map;
	private boolean gameStatus;
	private String gameMessage;

	public Game(Random r) {
		this.r = r;
		map = new Map(r);
		findHunter();
		gameStatus = true;
		gameMessage = "";
	}

	public Game() {
		r = new Random();
		map = new Map(r);
		findHunter();
		gameStatus = true;
		gameMessage = "";
	}

	public Game(Random r, Map map) {
		this.r = r;
		this.map = map;
		findHunter();
		gameStatus = true;
		gameMessage = "";
	}
	public boolean getStatus(){
		return gameStatus;
	}
	public void moveHunter(Direction d) {
		if (gameStatus) {
			map.getRoom(row, col).changeElement(Element.NOTHING);
			map.getRoom(row, col).makeVisible();
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
			checkGameOver();
			isWumpusNear();
			setChanged();
			notifyObservers(d);

		}
	}

	public boolean checkGameOver() {
		if (map.getSecondElement(row, col) == Element.PIT) {
			gameStatus = false;
			gameMessage = "Wow, you definitely just fell into a slime pit. Nice. GGs";
		}

		return gameStatus;
	}

	public boolean shootArrow(Direction d) {
		if (gameStatus) {
			if (d == Direction.NORTH || d == Direction.SOUTH) {
				for (int i = 0; i < 10; i++) {
					if (map.getElement(i, this.col) == Element.WUMPUS) {
						gameStatus = false;
						gameMessage = "RIP Wumpus :(";
						setChanged();
						notifyObservers();
						return true;
					}
				}

			} else {
				for (int i = 0; i < 10; i++) {
					if (map.getElement(this.row, i) == Element.WUMPUS) {
						gameStatus = false;
						gameMessage = "RIP Wumpus :(";
						setChanged();
						notifyObservers();
						return true;
					}
				}
			}
		
		gameMessage = "MISS! You lose. Git gud kid.";
		gameStatus = false;
		setChanged();
		notifyObservers();
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

	public String getMessage() {
		
		return gameMessage;
	}

	public boolean isWumpusNear() {
		if (gameStatus) {
			if (map.getSecondElement(row, col) == Element.WUMPUS) {
				gameStatus = false;
				gameMessage = "The wumpus just ate you lol. GGs";
				return true;
			}
			for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
				for (int colIndex = col - 1; colIndex <= col + 1; colIndex++) {
					if (!(rowIndex == row && colIndex == col)) {
						if (map.getElement((rowIndex + 10) % 10, (colIndex + 10) % 10) == Element.WUMPUS) {
							gameMessage = "You smell something foul";
							return true;
						}
					}
				}
			}
			gameMessage = "";
		}
		return false;
	}
}
