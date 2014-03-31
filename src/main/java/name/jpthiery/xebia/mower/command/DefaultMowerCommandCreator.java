package name.jpthiery.xebia.mower.command;


public class DefaultMowerCommandCreator implements MowerComandCreator {


	public DefaultMowerCommandCreator() {
		super();
	}

	@Override
	public MowerCommand createCommand(char charCommand) {
		switch (charCommand) {
		case 'D':
			return new TurnRightCommand();
		case 'G':
			return new TurnLeftCommand();
		case 'A':
			return new GoAheadCommand();
		default:
			throw new IllegalArgumentException(String.format("Command %s not supported.", Character.valueOf(charCommand)));
		}
	}

}
