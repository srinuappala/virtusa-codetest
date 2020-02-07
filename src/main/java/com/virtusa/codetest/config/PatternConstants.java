package com.virtusa.codetest.config;

public final class PatternConstants {

	/*
	 * Pattern matching strings for each type of valid commands
	 */
	public static final String ASSIGNMENT_PATTERN = "^([a-z]+) is ([I|V|X|L|C|D|M])$";
	public static final String CREDIT_PATTERN = "^((?:[a-z]+ )+)([A-Z]\\w+) is (\\d+) [c|C]redits$";
	public static final String HOWMUCH_PATTERN = "^[h|H]ow much is ((?:[a-z]+ )+)\\?$";
	public static final String HOWMANY_PATTERN = "^[h|H]ow many [c|C]redits is ((?:[a-z]+ )+)([A-Z]\\w+) \\?$";
	public static final String ROMAN_NUMBER_VALIDATIOR = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";

	public static final String WRONG_COMMAND_MESSAGE = "I have no idea what you are talking about";

}
