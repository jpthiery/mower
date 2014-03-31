package name.jpthiery.xebia.mower.runner;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import name.jpthiery.xebia.mower.model.Mower;
import name.jpthiery.xebia.mower.runner.init.DefaultMowerInitDataProvider;
import name.jpthiery.xebia.mower.runner.init.FileLineIterator;
import name.jpthiery.xebia.mower.runner.init.MowerInitDataProvider;

public class MowItNowRunner {

	private MowerRunnerFactory mowerRunnerFactory;

	private MowerInitDataProvider mowerInitDataProvider;
	
	private PrintStream out;

	public MowItNowRunner(MowerInitDataProvider mowerInitDataProvider, MowerRunnerFactory mowerRunnerFactory, PrintStream out) {
		super();
		if (mowerInitDataProvider == null) {
			throw new IllegalArgumentException("mowerInitDataProvider can't be null.");
		}
		if (mowerRunnerFactory == null) {
			throw new IllegalArgumentException("mowerRunnerFactory can't be null.");
		}
		if (out == null) {
			throw new IllegalArgumentException("out can't be null.");
		}
		
		this.mowerRunnerFactory = mowerRunnerFactory;
		this.mowerInitDataProvider = mowerInitDataProvider;
		this.out = out;
	}

	@SuppressWarnings("boxing")
	public List<Mower> run() {
		MowerRunner mowerRunner = mowerRunnerFactory.createRunner(mowerInitDataProvider);
		List<Mower> mowers = mowerInitDataProvider.getMowers();
		for (Mower mower : mowers) {
			mowerRunner.runMower(mower);
			out.println(String.format("%s %s %s", mower.getX(), mower.getY(), mower.getDirection()));
		}
		return mowers;
	}

	public static void main(String[] args) {
		if (args == null || args.length != 1) {
			System.err.println("Please, specify an input filename.");

		} else {
			Iterator<String> iterator = new FileLineIterator(args[0]);
			MowerInitDataProvider mowerInitDataProvider = new DefaultMowerInitDataProvider(iterator);
			MowerRunnerFactory mowerRunnerFactory = new DefaultMowerRunnerFactory();
			MowItNowRunner mowItNowRunner = new MowItNowRunner(mowerInitDataProvider, mowerRunnerFactory, System.out);
			mowItNowRunner.run();
		}
	}

}
