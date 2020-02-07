/*
 * 
 */
package com.virtusa.codetest.commands.impl;

import com.virtusa.codetest.commands.IGalaxyCommand;
import com.virtusa.codetest.databank.MetaData;

/*
 * The AssignmentCommand class executes the commands like  ex: "pish is I"
 * 
 */
public class CommandAssignment implements IGalaxyCommand {

	private String word;
	private String meaning;
	private MetaData metaData;

	public CommandAssignment(MetaData metaData, String word, String meaning) {
		this.word = word;
		this.meaning = meaning;
		this.metaData = metaData;
	}

	@Override
	public void execute() {
		try {
			metaData.setAssignment(word, meaning);
		} catch (Exception e) {
			System.out.println("Exception while AssignmentCommand execution !!" + e.getMessage());
		}
	}

}
