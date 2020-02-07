package com.virtusa.codetest.commands;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.virtusa.codetest.commands.impl.CommandCreditAssign;
import com.virtusa.codetest.databank.MetaData;

public class CommandCreditAssignTest {

	private MetaData db;

	@Before
	public void setUp() throws Exception {
		db = new MetaData();
	}

	@Test
	public void test() {
		db.setAssignment("pish", "I");

		CommandCreditAssign cac = new CommandCreditAssign(db, "pish pish", "Iron", "4");
		cac.execute();

		assertEquals(db.getCredit("Iron"), Double.valueOf(2.0));
	}

}
