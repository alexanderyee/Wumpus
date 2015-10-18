package model;

import java.util.Random;

public class Map {
	private Room[][] grid;
	private Random r;
	public Map(Random r){
		this.r = r;
	}
	public Element getElement(int r, int c){
		return grid[r][c].getElement();
	}
}
