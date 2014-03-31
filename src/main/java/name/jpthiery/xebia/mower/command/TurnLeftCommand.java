package name.jpthiery.xebia.mower.command;

import name.jpthiery.xebia.mower.Lawn;
import name.jpthiery.xebia.mower.model.Mower;

public class TurnLeftCommand implements MowerCommand {

	public TurnLeftCommand() {
		super();
	}

	@Override
	public void execute(Lawn lawn, Mower mower) {
		if (lawn == null) {
			throw new IllegalArgumentException("lawn can't be null.");
		}
		if (mower == null) {
			throw new IllegalArgumentException("mower can't be null.");
		}		
		lawn.turnLeft(mower);		
	}

}
