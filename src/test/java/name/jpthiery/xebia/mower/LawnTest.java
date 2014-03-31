package name.jpthiery.xebia.mower;

import static org.junit.Assert.assertEquals;
import name.jpthiery.xebia.mower.model.Direction;
import name.jpthiery.xebia.mower.model.Mower;

import org.junit.Before;
import org.junit.Test;

public class LawnTest {

	private Lawn lawn;

	@Before
	public void setup() {
		lawn = new Lawn(10, 10);
	}

	@Test
	public void mower_turn_right_from_north() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.N);

		lawn.turnRight(mower);

		assertEquals(Direction.E, mower.getDirection());
	}

	@Test
	public void mower_turn_right_from_east() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.E);

		lawn.turnRight(mower);

		assertEquals(Direction.S, mower.getDirection());
	}

	@Test
	public void mower_turn_right_from_sourth() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.S);

		lawn.turnRight(mower);

		assertEquals(Direction.W, mower.getDirection());
	}

	@Test
	public void mower_turn_right_from_west() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.W);

		lawn.turnRight(mower);

		assertEquals(Direction.N, mower.getDirection());
	}

	@Test
	public void mower_turn_left_from_north() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.N);

		lawn.turnLeft(mower);

		assertEquals(Direction.W, mower.getDirection());
	}

	@Test
	public void mower_turn_left_from_east() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.E);

		lawn.turnLeft(mower);

		assertEquals(Direction.N, mower.getDirection());
	}

	@Test
	public void mower_turn_left_from_sourth() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.S);

		lawn.turnLeft(mower);

		assertEquals(Direction.E, mower.getDirection());
	}

	@Test
	public void mower_turn_left_from_west() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.W);

		lawn.turnLeft(mower);

		assertEquals(Direction.S, mower.getDirection());
	}

	@Test
	public void mower_move_ahead_north() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.N);

		lawn.goAhead(mower);

		assertEquals(5, mower.getX());
		assertEquals(6, mower.getY());
	}
	
	@Test
	public void mower_move_ahead_east() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.E);
		
		lawn.goAhead(mower);
		
		assertEquals(6, mower.getX());
		assertEquals(5, mower.getY());
	}
	
	@Test
	public void mower_move_ahead_sourth() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.S);
		
		lawn.goAhead(mower);
		
		assertEquals(5, mower.getX());
		assertEquals(4, mower.getY());
	}
	
	@Test
	public void mower_move_ahead_west() {
		Mower mower = new Mower();
		defineMowerAtTheMiddle(mower);
		mower.setDirection(Direction.W);
		
		lawn.goAhead(mower);
		
		assertEquals(4, mower.getX());
		assertEquals(5, mower.getY());
	}
	
	@Test(expected=IllegalStateException.class)
	public void mower_move_outside_north_lawn() {
		Mower mower = new Mower();
		mower.setX(5);
		mower.setY(10);
		mower.setDirection(Direction.N);
		
		lawn.goAhead(mower);
	}
	
	@Test(expected=IllegalStateException.class)
	public void mower_move_outside_east_lawn() {
		Mower mower = new Mower();
		mower.setX(10);
		mower.setY(5);
		mower.setDirection(Direction.E);
		
		lawn.goAhead(mower);
	}
	
	@Test(expected=IllegalStateException.class)
	public void mower_move_outside_south_lawn() {
		Mower mower = new Mower();
		mower.setX(5);
		mower.setY(0);
		mower.setDirection(Direction.S);
		
		lawn.goAhead(mower);
	}
	
	@Test(expected=IllegalStateException.class)
	public void mower_move_outside_west_lawn() {
		Mower mower = new Mower();
		mower.setX(0);
		mower.setY(5);
		mower.setDirection(Direction.W);
		
		lawn.goAhead(mower);
	}

	private static void defineMowerAtTheMiddle(Mower mower) {
		mower.setX(5);
		mower.setY(5);
	}

}
