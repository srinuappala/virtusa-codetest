/*
 * 
 */
package com.virtusa.codetest.commands.impl;

import com.virtusa.codetest.commands.IGalaxyCommand;
import com.virtusa.codetest.config.PatternConstants;

/*
 * The UnknownCommand class executes the commands that is not
 * recognized a valid command query
 * 
 */
public class CommandUnknown implements IGalaxyCommand {

	@Override
	public void execute() {
		System.out.println(PatternConstants.WRONG_COMMAND_MESSAGE);
	}

}
