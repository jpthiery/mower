package name.jpthiery.xebia.mower.runner;

import java.util.Iterator;
import java.util.List;

import name.jpthiery.xebia.mower.Lawn;
import name.jpthiery.xebia.mower.command.MowerCommand;
import name.jpthiery.xebia.mower.model.Mower;

public class DefaultMowerRunner implements MowerRunner {

	private final Lawn lawn;

	public DefaultMowerRunner(Lawn lawn) {
		super();
		if (lawn == null) {
			throw new IllegalArgumentException("lawn can't be null.");
		}
		this.lawn = lawn;
	}

	@Override
	public void runMower(Mower mower) {
		if (mower == null) {
			throw new IllegalArgumentException("mower can't be null.");
		}
		List<MowerCommand> commands = mower.getCommands();
		if (commands != null) {
			Iterator<MowerCommand> itCommand = commands.iterator();
			while (itCommand.hasNext()) {
				MowerCommand command = itCommand.next();
				command.execute(lawn, mower);
			}
		}
	}

}
