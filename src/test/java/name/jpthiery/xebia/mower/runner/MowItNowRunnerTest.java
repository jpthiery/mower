package name.jpthiery.xebia.mower.runner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import name.jpthiery.xebia.mower.model.Direction;
import name.jpthiery.xebia.mower.model.Mower;
import name.jpthiery.xebia.mower.runner.init.DefaultMowerInitDataProvider;
import name.jpthiery.xebia.mower.runner.init.FileLineIterator;
import name.jpthiery.xebia.mower.runner.init.MowerInitDataProvider;

import org.junit.Test;


public class MowItNowRunnerTest {

	@Test
	public void acceptance_scenarioA() {
		
		Iterator<String> iterator = new FileLineIterator("src/test/resources/scenarioA.txt");		
		MowerInitDataProvider mowerInitDataProvider = new DefaultMowerInitDataProvider(iterator);
		MowerRunnerFactory mowerRunnerFactory = new DefaultMowerRunnerFactory();
		PrintStream out = mock(PrintStream.class);
		MowItNowRunner mowItNowRunner = new MowItNowRunner(mowerInitDataProvider, mowerRunnerFactory, out);
				
		List<Mower> result = mowItNowRunner.run();
		
		assertNotNull(result);
		assertEquals(2, result.size());
		
		Mower mower = result.get(0);
		assertEquals(1, mower.getX());
		assertEquals(3, mower.getY());
		assertEquals(Direction.N, mower.getDirection());
		
		mower = result.get(1);
		assertEquals(5, mower.getX());
		assertEquals(1, mower.getY());
		assertEquals(Direction.E, mower.getDirection());
		
		verify(out).println("1 3 N");
		verify(out).println("5 1 E");		
	}
	
}
