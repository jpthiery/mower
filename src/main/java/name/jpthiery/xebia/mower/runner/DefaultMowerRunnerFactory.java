package name.jpthiery.xebia.mower.runner;

import name.jpthiery.xebia.mower.Lawn;
import name.jpthiery.xebia.mower.runner.init.MowerInitDataProvider;

public class DefaultMowerRunnerFactory implements MowerRunnerFactory {

	@Override
	public MowerRunner createRunner(MowerInitDataProvider mowerInitDataProvider) {
		Lawn lawn = mowerInitDataProvider.getLawn();
		DefaultMowerRunner res = new DefaultMowerRunner(lawn);
		return res;
	}

}
