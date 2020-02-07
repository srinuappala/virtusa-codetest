package com.virtusa.codetest.databank;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DataBankTest {

	MetaData bank;

	@Before
	public void setUp() throws Exception {
		bank = new MetaData();
	}

	@Test
	public void validAssignmentTest() {
		bank.setAssignment("pish", "I");
		assertEquals(bank.getAssignment("pish"), "I");
	}

	@Test
	public void invalidAssignmentTest() {
		assertEquals(bank.getAssignment("gish"), null);
	}

	@Test
	public void validRomanFromStringTest() {
		bank.setAssignment("pish", "I");
		assertEquals(bank.getRomanFromString("pish pish"), "II");
	}

	@Test
	public void invalidRomanFromStringTest() {
		bank.setAssignment("pish", "I");
		assertEquals(bank.getRomanFromString("pish gish"), "");
	}

	@Test
	public void validCreditTest() {
		bank.setCredit("Gold", Double.valueOf(2.0));
		assertEquals(bank.getCredit("Gold"), Double.valueOf(2.0));
	}

	@Test
	public void invalidCreditTest() {
		assertEquals(bank.getCredit("Rubber"), null);
	}

}
