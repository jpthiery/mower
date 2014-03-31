package name.jpthiery.xebia.mower.runner.init;

import java.util.List;

import name.jpthiery.xebia.mower.Lawn;
import name.jpthiery.xebia.mower.model.Mower;

public interface MowerInitDataProvider {

	Lawn getLawn();
	
	List<Mower> getMowers();
	
}
