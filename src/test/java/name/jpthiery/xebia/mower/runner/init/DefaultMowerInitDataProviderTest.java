package name.jpthiery.xebia.mower.runner.init;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import name.jpthiery.xebia.mower.Lawn;
import name.jpthiery.xebia.mower.command.MowerCommand;
import name.jpthiery.xebia.mower.model.Mower;

import org.junit.Test;


public class DefaultMowerInitDataProviderTest {
	

	@Test
	public void read_scenario_a_init_data() {
		List<String> content = Arrays.asList("5 5", "2 2 N", "DAA", "0 0 N", "DAGA");
		Iterator<String> iterator = content.iterator();
		
		DefaultMowerInitDataProvider provider = new DefaultMowerInitDataProvider(iterator);
		
		Lawn lawn = provider.getLawn();
		assertEquals(6, lawn.getWith());
		assertEquals(6, lawn.getHeight());
		
		List<Mower> mowers = provider.getMowers();
		assertNotNull(mowers);
		assertEquals(2, mowers.size());
		
		Mower mower = mowers.get(0);
		assertNotNull(mower);
		List<MowerCommand> commands = mower.getCommands();
		assertNotNull(commands);
		assertEquals(3, commands.size());
		 
		mower = mowers.get(1);
		assertNotNull(mower);
		commands = mower.getCommands();
		assertNotNull(commands);
		assertEquals(4, commands.size());
		
	}
	
}
