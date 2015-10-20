package tests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import model.Direction;
import model.Game;

//Alex Yee
public class GameTest {

	@Test
	public void test() {
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.NORTH);
		assertTrue(g.isWumpusNear());
		assertEquals(g.getMessage(), "You smell something foul");
		assertTrue(g.shootArrow(Direction.NORTH));
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "RIP Wumpus :(");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
		g.findHunter();
		g.getRow();
		g.getColumn();
		g.getPoint();

	}

	@Test
	public void test2() {
		Game g2 = new Game();
		Game g3 = new Game(new Random(), g2.map);
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.NORTH);
		assertTrue(g.isWumpusNear());
		assertEquals(g.getMessage(), "You smell something foul");
		g.moveHunter(Direction.NORTH);
		assertFalse(g.isWumpusNear());
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "The wumpus just ate you lol. GGs");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
		g.findHunter();
		g.getRow();
		g.getColumn();
		g.getPoint();

	}

	@Test
	public void test3() {

		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.SOUTH);
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.SOUTH);
		g.moveHunter(Direction.SOUTH);
		g.moveHunter(Direction.SOUTH);
		g.moveHunter(Direction.SOUTH);
		assertFalse(g.checkGameOver());
		assertEquals(g.getMessage(), "Wow, you definitely just fell into a slime pit. Nice. GGs");
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
	}

	@Test
	public void test5() {
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.NORTH);

		g.moveHunter(Direction.NORTH);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());

		assertTrue(g.shootArrow(Direction.WEST));
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "RIP Wumpus :(");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));

	}

	@Test
	public void test6() {
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.NORTH);
		assertTrue(g.isWumpusNear());
		assertEquals(g.getMessage(), "You smell something foul");
		g.moveHunter(Direction.EAST);
		assertFalse(g.shootArrow(Direction.SOUTH));
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "MISS! You lose. Git gud kid.");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
		g.findHunter();
		g.getRow();
		g.getColumn();
		g.getPoint();

	}

	@Test
	public void test4() {
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.NORTH);
		assertTrue(g.isWumpusNear());
		assertEquals(g.getMessage(), "You smell something foul");
		assertTrue(g.shootArrow(Direction.NORTH));
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "RIP Wumpus :(");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
		g.findHunter();
		g.getRow();
		g.getColumn();
		g.getPoint();

	}

	@Test
	public void test10() {
		Game g2 = new Game();
		Game g3 = new Game(new Random(), g2.map);
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.NORTH);
		assertTrue(g.isWumpusNear());
		assertEquals(g.getMessage(), "You smell something foul");
		g.moveHunter(Direction.NORTH);
		assertFalse(g.isWumpusNear());
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "The wumpus just ate you lol. GGs");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
		g.findHunter();
		g.getRow();
		g.getColumn();
		g.getPoint();

	}

	@Test
	public void test9() {

		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.SOUTH);
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.SOUTH);
		g.moveHunter(Direction.SOUTH);
		g.moveHunter(Direction.SOUTH);
		g.moveHunter(Direction.SOUTH);
		assertFalse(g.checkGameOver());
		assertEquals(g.getMessage(), "Wow, you definitely just fell into a slime pit. Nice. GGs");
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
	}

	@Test
	public void test8() {
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.NORTH);

		g.moveHunter(Direction.NORTH);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());

		assertTrue(g.shootArrow(Direction.WEST));
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "RIP Wumpus :(");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));

	}

	@Test
	public void test7() {
		Random r = new Random(69);
		Game g = new Game(r);
		g.map.toString();
		System.out.println(g.map.toStringDone());
		assertFalse(g.map.getRoom(7, 4).isVisible());
		g.moveHunter(Direction.WEST);

		g.moveHunter(Direction.WEST);
		assertTrue(g.getStatus());
		assertTrue(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		g.moveHunter(Direction.NORTH);
		assertTrue(g.isWumpusNear());
		assertEquals(g.getMessage(), "You smell something foul");
		g.moveHunter(Direction.EAST);
		assertFalse(g.shootArrow(Direction.SOUTH));
		assertFalse(g.getStatus());
		assertEquals(g.getMessage(), "MISS! You lose. Git gud kid.");
		assertFalse(g.checkGameOver());
		assertFalse(g.isWumpusNear());
		assertFalse(g.shootArrow(Direction.SOUTH));
		g.findHunter();
		g.getRow();
		g.getColumn();
		g.getPoint();

	}

}
