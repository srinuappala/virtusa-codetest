package com.virtusa.codetest.commandparser;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.virtusa.codetest.commands.IGalaxyCommand;
import com.virtusa.codetest.commands.impl.CommandAssignment;
import com.virtusa.codetest.commands.impl.CommandCreditAssign;
import com.virtusa.codetest.commands.impl.CommandHowMany;
import com.virtusa.codetest.commands.impl.CommandHowMuch;
import com.virtusa.codetest.commands.impl.CommandUnknown;
import com.virtusa.codetest.config.PatternConstants;
import com.virtusa.codetest.databank.MetaData;

/*
 * The InputDatParser class is to parse the given input string(s) and returns a command
 * object or a set of command objects which executes and provide the end result
 *  
 */

public class InputDataParser {

	/*
	 * MetaData class is to store pattern assignment and credit assignment data,
	 * which will be used by the command objects during final output execution
	 */

	private MetaData metaData;

	public InputDataParser() {
		metaData = new MetaData();
	}

	/*
	 * This method returns a list of command objects for each command query
	 * 
	 * @param queries
	 */
	public ArrayList<IGalaxyCommand> getCommandsFromFile(ArrayList<String> queries) {
		ArrayList<IGalaxyCommand> commands = null;
		try {
			if (queries == null) {
				return new ArrayList<IGalaxyCommand>();
			}

			commands = new ArrayList<IGalaxyCommand>();
			for (int i = 0; i < queries.size(); i++) {
				IGalaxyCommand command = getCommand(queries.get(i));
				commands.add(command);
			}
		} catch (Exception e) {
			System.out.println("Exception while getCommandsFromFile method execution of InputDataParser class"
					+ e.getMessage());
		}
		return commands;
	}

	/*
	 * This method returns a command object corresponding to the input command
	 * query ex : Assignment,Credit etc.,
	 * 
	 * @param query
	 */
	public IGalaxyCommand getCommand(String query) {
		IGalaxyCommand command = null;

		// If input data is in the form : xxx is yyyyy then its Assignment

		try {
			if (query.matches(PatternConstants.ASSIGNMENT_PATTERN)) {
				Pattern p = Pattern.compile(PatternConstants.ASSIGNMENT_PATTERN);
				Matcher m = p.matcher(query);
				m.matches();
				String word = m.group(1).trim();
				String meaning = m.group(2).trim();
				command = new CommandAssignment(metaData, word, meaning);

				// If input data is in the form : xxx is yyyyy Credits/credits
				// its
				// Credit pattern to find out metal value
			} else if (query.matches(PatternConstants.CREDIT_PATTERN)) {
				Pattern p = Pattern.compile(PatternConstants.CREDIT_PATTERN);
				Matcher m = p.matcher(query);
				m.matches();
				String words = m.group(1).trim();
				String item = m.group(2).trim();
				String value = m.group(3).trim();
				command = new CommandCreditAssign(metaData, words, item, value);

				// If input data is in the form : how much is + the words , then
				// its
				// Howmuch pattern
			} else if (query.matches(PatternConstants.HOWMUCH_PATTERN)) {
				Pattern p = Pattern.compile(PatternConstants.HOWMUCH_PATTERN);
				Matcher m = p.matcher(query);
				m.matches();
				String words = m.group(1).trim();
				command = new CommandHowMuch(metaData, words);

				// If input data is in the form : how many C/credits is words
				// and
				// metal type, then its Howmany pattern.
				// We need to find out the values for the given words and the
				// metal
				// credits so that we can calculate
			} else if (query.matches(PatternConstants.HOWMANY_PATTERN)) {
				Pattern p = Pattern.compile(PatternConstants.HOWMANY_PATTERN);
				Matcher m = p.matcher(query);
				m.matches();
				String words = m.group(1).trim();
				String item = m.group(2).trim();
				command = new CommandHowMany(metaData, words, item);
			} else {
				command = new CommandUnknown();
			}
		} catch (Exception e) {
			System.out.println("Exception while executing the getCommand method of InputDataParser class "
					+ e.getMessage());
		}
		return command;
	}
}
