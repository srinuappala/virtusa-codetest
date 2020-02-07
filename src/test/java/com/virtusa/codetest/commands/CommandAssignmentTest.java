package com.virtusa.codetest.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.virtusa.codetest.commands.impl.CommandAssignment;
import com.virtusa.codetest.databank.MetaData;

public class CommandAssignmentTest {

	private MetaData db;

	@Before
	public void setUp() throws Exception {
		db = new MetaData();
	}

	@Test
	public void test() {
		CommandAssignment ac = new CommandAssignment(db, "pish", "I");
		ac.execute();
		assertEquals(db.getAssignment("pish"), "I");
	}
}
