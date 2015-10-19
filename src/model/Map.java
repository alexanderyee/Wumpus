package model;

import java.util.Arrays;
import java.util.Random;

public class Map {
	private Room[][] grid;
	private Random r;

	public Map(Random r) {
		this.r = r;
		grid = new Room[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				grid[i][j] = new Room(Element.NOTHING);
			}
		}

		// generate wumpus
		int row = r.nextInt(10);
		int col = r.nextInt(10);

		grid[row % 10][col % 10] = new Room(Element.WUMPUS);
		for (int rowIndex = row - 1; rowIndex <= row + 1; rowIndex++) {
			for (int colIndex = col - 1; colIndex <= col + 1; colIndex++) {
				if (!(rowIndex == row && colIndex == col)) {
					grid[(rowIndex + 10) % 10][(colIndex + 10) % 10] = new Room(Element.BLOOD);
				}
			}
		}

		grid[(row + 2) % 10][col] = new Room(Element.BLOOD);
		grid[(row + 8) % 10][col] = new Room(Element.BLOOD);
		grid[row][(col + 2) % 10] = new Room(Element.BLOOD);
		grid[row][(col + 8) % 10] = new Room(Element.BLOOD);

		// generate slime pits
		int nPits = r.nextInt(2) + 3;
		while (nPits > 0) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			if (!((grid[row][col].getElement() == Element.PIT || grid[row][col].getElement() == Element.SLIME
					|| grid[row][col].getElement() == Element.BLOOD || grid[row][col].getElement() == Element.WUMPUS
					|| grid[row][col].getElement() == Element.GOOP))) {
				// can't place slime pits in same room as other slime
				// pits, slime, blood, wumpus, or goop.
				grid[row][col] = new Room(Element.PIT);
				grid[(row + 1) % 10][col].changeElement(Element.SLIME);
				grid[(row + 9) % 10][col].changeElement(Element.SLIME);
				grid[row][(col + 1) % 10].changeElement(Element.SLIME);
				grid[row][(col + 9) % 10].changeElement(Element.SLIME);
				nPits--;
			}
		}
		// generate hunter
		while (true) {
			row = r.nextInt(10);
			col = r.nextInt(10);
			if (grid[row][col].getElement() == Element.NOTHING) {
				grid[row][col].changeElement(Element.HUNTER);
				grid[row][col].makeVisible();
				break;
			}
		}
	}

	public Element getElement(int r, int c) {
		return grid[r][c].getElement();
	}
	public Element getSecondElement(int r, int c){
		return grid[r][c].getSecondElement();
	}
	public Room getRoom(int r, int c){
		return grid[r][c];
	}
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				result += "[" + grid[i][j].toString() + "] ";
			}
			result += "\n";
		}
		return result;
	}
}
