package com.virtusa.codetest.roman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RomanNumberTest {

	@Test
	public void validRomanNumberTest1() throws Exception {
		assertTrue(GalaxyRomanNumber.isValidRomanNumber("I"));
	}

	@Test
	public void validRomanNumberTest2() throws Exception {
		assertTrue(GalaxyRomanNumber.isValidRomanNumber("MCMXLIV"));
	}

	@Test
	public void invalidRomanNumberTest() throws Exception {
		assertFalse(GalaxyRomanNumber.isValidRomanNumber("VV"));
	}

	@Test
	public void validRomanNumberToArabicTest1() throws Exception {
		assertEquals(GalaxyRomanNumber.romanNumberToArabic("I"), 1);
	}

	@Test
	public void validRomanNumberToArabicTest2() throws Exception {
		assertEquals(GalaxyRomanNumber.romanNumberToArabic("MCMXLIV"), 1944);
	}

	@Test
	public void invalidRomanNumberToArabicTest() throws Exception {
		assertEquals(GalaxyRomanNumber.romanNumberToArabic("VV"), -1);
	}

	@Test
	public void invalidRomanIIIVToArabicTest() throws Exception {
		assertEquals(GalaxyRomanNumber.romanNumberToArabic("IIIV"), -1);
	}

}
