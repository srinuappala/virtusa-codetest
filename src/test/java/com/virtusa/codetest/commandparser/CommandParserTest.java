package com.virtusa.codetest.commandparser;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.virtusa.codetest.commands.IGalaxyCommand;
import com.virtusa.codetest.commands.impl.CommandAssignment;
import com.virtusa.codetest.commands.impl.CommandCreditAssign;
import com.virtusa.codetest.commands.impl.CommandHowMany;
import com.virtusa.codetest.commands.impl.CommandHowMuch;
import com.virtusa.codetest.commands.impl.CommandUnknown;

public class CommandParserTest {

	@Test
	public void inputReturnsAssignmentCommandTest() {
		InputDataParser cp = new InputDataParser();
		IGalaxyCommand command = cp.getCommand("pish is I");

		assertTrue(command instanceof CommandAssignment);
	}

	@Test
	public void inputReturnsCreditAssignCommandTest() {
		InputDataParser cp = new InputDataParser();
		IGalaxyCommand command = cp.getCommand("pish Iron is 10 Credits");

		assertTrue(command instanceof CommandCreditAssign);
	}

	@Test
	public void inputReturnsHowMuchCommandTest() {
		InputDataParser cp = new InputDataParser();
		IGalaxyCommand command = cp.getCommand("how much is pish ?");

		assertTrue(command instanceof CommandHowMuch);
	}

	@Test
	public void inputReturnsHowManyCommandTest() {
		InputDataParser cp = new InputDataParser();
		IGalaxyCommand command = cp.getCommand("how many Credits is pish Iron ?");

		assertTrue(command instanceof CommandHowMany);
	}

	@Test
	public void inputReturnsUnknownCommandTest() {
		InputDataParser cp = new InputDataParser();
		IGalaxyCommand command = cp
				.getCommand("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");

		assertTrue(command instanceof CommandUnknown);
	}

	@Test
	public void inputReturnsMultipleCommandsTest() {
		ArrayList<String> queries = new ArrayList<String>();
		queries.add("pish is I");
		queries.add("pish Iron is 10 Credits");
		queries.add("how much is pish ?");
		queries.add("how many Credits is pish Iron ?");
		queries.add("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");

		InputDataParser cp = new InputDataParser();
		ArrayList<IGalaxyCommand> commands = cp.getCommandsFromFile(queries);

		assertTrue(commands.get(0) instanceof CommandAssignment);
		assertTrue(commands.get(1) instanceof CommandCreditAssign);
		assertTrue(commands.get(2) instanceof CommandHowMuch);
		assertTrue(commands.get(3) instanceof CommandHowMany);
		assertTrue(commands.get(4) instanceof CommandUnknown);
	}

}
