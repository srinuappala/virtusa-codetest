package com.virtusa.codetest.commands;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.virtusa.codetest.commands.impl.CommandUnknown;

public class CommandUnknownTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(out));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}

	@Test
	public void test() {
		CommandUnknown uc = new CommandUnknown();
		uc.execute();

		assertEquals(out.toString().trim(), "I have no idea what you are talking about");
	}

}
