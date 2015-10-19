package tests;

import java.util.Random;

import org.junit.Test;

import model.Direction;
import model.Game;

public class GameTest {

	@Test
	public void test() {
		Random r = new Random();
		Game g = new Game(r);
		System.out.println(g.map.toString());
		
	}

}
