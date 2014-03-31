package name.jpthiery.xebia.mower.command;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class DefaultMowerCommandCreatorTest {
	
	private MowerComandCreator creator;
	
	@Before
	public void setup() {
		creator = new DefaultMowerCommandCreator();
	}

	@Test
	public void create_turn_right_command() {		
		MowerCommand command = creator.createCommand('D');
		assertTrue(command instanceof TurnRightCommand);
	}
	
	@Test
	public void create_turn_left_command() {		
		MowerCommand command = creator.createCommand('G');
		assertTrue(command instanceof TurnLeftCommand);
	}
	
	@Test
	public void create_go_ahead_command() {		
		MowerCommand command = creator.createCommand('A');
		assertTrue(command instanceof GoAheadCommand);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalide_y_command() {		
		creator.createCommand('Y');
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void invalide_a_command() {		
		creator.createCommand('a');
	}
	
}
