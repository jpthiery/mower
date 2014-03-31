package name.jpthiery.xebia.mower.model;

import java.util.List;

import name.jpthiery.xebia.mower.command.MowerCommand;

public class Mower {

	private int x;

	private int y;

	private Direction direction;

	private List<MowerCommand> commands;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<MowerCommand> getCommands() {
		return commands;
	}

	public void setCommands(List<MowerCommand> commands) {
		this.commands = commands;
	}

	@Override
	public String toString() {
		return "Mower [x=" + x + ", y=" + y + ", direction=" + direction + ", commands=" + commands + "]";
	}

}
