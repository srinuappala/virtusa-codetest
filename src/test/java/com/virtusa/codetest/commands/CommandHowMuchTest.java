package com.virtusa.codetest.commands;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.virtusa.codetest.commands.impl.CommandHowMuch;
import com.virtusa.codetest.databank.MetaData;

public class CommandHowMuchTest {

	private final ByteArrayOutputStream out = new ByteArrayOutputStream();
	private MetaData db;

	@Before
	public void setUp() throws Exception {
		db = new MetaData();
		System.setOut(new PrintStream(out));
	}

	@After
	public void tearDown() throws Exception {
		System.setOut(null);
	}

	@Test
	public void test() {
		db.setAssignment("pish", "I");

		CommandHowMuch hmc = new CommandHowMuch(db, "pish pish");
		hmc.execute();

		assertEquals(out.toString().trim(), "pish pish is 2");
	}

}
