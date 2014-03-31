package name.jpthiery.xebia.mower.runner.init;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import name.jpthiery.xebia.mower.Lawn;
import name.jpthiery.xebia.mower.command.DefaultMowerCommandCreator;
import name.jpthiery.xebia.mower.command.MowerComandCreator;
import name.jpthiery.xebia.mower.command.MowerCommand;
import name.jpthiery.xebia.mower.model.Direction;
import name.jpthiery.xebia.mower.model.Mower;

public class DefaultMowerInitDataProvider implements MowerInitDataProvider {

	private final List<Mower> mowers;

	private Lawn lawn;
	
	private MowerComandCreator charCommandConverter ;

	public DefaultMowerInitDataProvider(Iterator<String> iterator, MowerComandCreator charCommandConverter) {
		super();
		if (iterator == null) {
			throw new IllegalArgumentException("iterator can't be null.");
		}
		if (charCommandConverter == null) {
			throw new IllegalArgumentException("charCommandConverter can't be null.");
		}
		
		mowers = new LinkedList<>();
		this.charCommandConverter = charCommandConverter;
		String line = null;
		while (iterator.hasNext()) {
			if (lawn != null) {
				Mower mower = extractMower(iterator);
				mowers.add(mower);
			} else {
				line = iterator.next();
				String[] lanwParams = line.split(" ");
				if (lanwParams == null || lanwParams.length != 2) {
					throw new IllegalArgumentException("First line of input file must contain With and Height of lawn.");
				}
				int lawnWith = Integer.valueOf(lanwParams[0]).intValue()+1;
				int lawnHeight = Integer.valueOf(lanwParams[1]).intValue()+1;
				lawn = new Lawn(lawnWith, lawnHeight);
				
			}
		}
	}
	
	public DefaultMowerInitDataProvider(Iterator<String> iterator) {
		this(iterator, new DefaultMowerCommandCreator());
	}

	@Override
	public List<Mower> getMowers() {
		return new LinkedList<>(mowers);
	}

	@Override
	public Lawn getLawn() {
		return lawn;
	}

	private Mower extractMower(Iterator<String> it) {
		Mower res = new Mower();
		String line = null;
		if (it.hasNext()) {
			line = it.next();
			String[] positionAndDirection = line.split(" ");
			if (positionAndDirection == null || positionAndDirection.length != 3) {
				throw new IllegalArgumentException(String.format("Line %s isn't valid position and direction parameters for a mower", line));
			}
			res.setX(Integer.valueOf(positionAndDirection[0]).intValue());
			res.setY(Integer.valueOf(positionAndDirection[1]).intValue());
			res.setDirection(Direction.valueOf(positionAndDirection[2]));
			if (it.hasNext()) {
				line = it.next();
				List<MowerCommand> commands = new LinkedList<>();
				for (int i = 0; i < line.length(); i++) {
					char charCommand = line.charAt(i);
					MowerCommand mowerCommand = charCommandConverter.createCommand(charCommand);
					commands.add(mowerCommand);
				}
				res.setCommands(commands);
			} else {
				throw new IllegalArgumentException("No command define for the mower.");
			}
		} else {
			throw new IllegalArgumentException("No position define for the mower.");
		}
		return res;
	}

}
