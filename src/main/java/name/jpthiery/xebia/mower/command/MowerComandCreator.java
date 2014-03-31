package name.jpthiery.xebia.mower.command;

public interface MowerComandCreator {

	public abstract MowerCommand createCommand(char charCommand);

}