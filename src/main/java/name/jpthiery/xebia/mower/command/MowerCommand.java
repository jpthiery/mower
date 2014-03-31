package name.jpthiery.xebia.mower.command;

import name.jpthiery.xebia.mower.Lawn;
import name.jpthiery.xebia.mower.model.Mower;

public interface MowerCommand {
	
	void execute(Lawn lawn, Mower mower);	
	
}
