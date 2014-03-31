package name.jpthiery.xebia.mower;

import name.jpthiery.xebia.mower.model.Direction;
import name.jpthiery.xebia.mower.model.Mower;

public class Lawn {

	private static final Direction[] DIRECTIONS = Direction.values();

	private final int with;

	private final int height;

	public Lawn(int with, int height) {
		super();
		if (with <= 0) {
			throw new IllegalArgumentException(String.format("With %s must be positive value.", Integer.valueOf(with)));
		}
		if (height <= 0) {
			throw new IllegalArgumentException(String.format("Height %s must be positive value.", Integer.valueOf(with)));
		}
		this.with = with;
		this.height = height;
	}

	public void turnRight(Mower mower) {
		if (mower == null) {
			throw new IllegalArgumentException("mower can't be null.");
		}
		Direction initialDirection = mower.getDirection();

		int initOrdinal = initialDirection.ordinal();
		int targetOrdinal = 0;
		if (initOrdinal < DIRECTIONS.length - 1) {
			targetOrdinal = initOrdinal + 1;
		}
		Direction res = DIRECTIONS[targetOrdinal];
		mower.setDirection(res);
	}

	public void turnLeft(Mower mower) {
		if (mower == null) {
			throw new IllegalArgumentException("mower can't be null.");
		}
		Direction initialDirection = mower.getDirection();

		int initOrdinal = initialDirection.ordinal();
		int targetOrdinal = DIRECTIONS.length - 1;
		if (initOrdinal > 0) {
			targetOrdinal = initOrdinal - 1;
		}
		Direction res = DIRECTIONS[targetOrdinal];
		mower.setDirection(res);
	}

	@SuppressWarnings("boxing")
	public void goAhead(Mower mower) {
		if (mower == null) {
			throw new IllegalArgumentException("mower can't be null.");
		}
		int xTarget = mower.getX();
		int yTarget = mower.getY();
		Direction direction = mower.getDirection();
		switch (direction) {
		case N:
			yTarget++;
			break;
		case E:
			xTarget++;
			break;
		case S:
			yTarget--;
			break;
		case W:
			xTarget--;
			break;

		default:
			throw new UnsupportedOperationException(String.format("Unable to move from unknow direction %s.", direction));
		}

		if ((xTarget < 0 || xTarget >= with) || //
						(yTarget < 0 || yTarget >= height)) {
			throw new IllegalStateException(String.format("Mower %s can't go to the position (%s,%s), lawn size is (%s,%s).", mower, xTarget,
							yTarget, with, height));
		}

		mower.setX(xTarget);
		mower.setY(yTarget);
	}

	public int getWith() {
		return with;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public String toString() {
		return "Lawn [with=" + with + ", height=" + height + "]";
	}

}
