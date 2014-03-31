package name.jpthiery.xebia.mower.runner;

import name.jpthiery.xebia.mower.runner.init.MowerInitDataProvider;


public interface MowerRunnerFactory {

	MowerRunner createRunner(MowerInitDataProvider mowerInitDataProvider);
	
}
