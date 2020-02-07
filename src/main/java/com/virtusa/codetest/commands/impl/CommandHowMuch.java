/*
 * 
 */
package com.virtusa.codetest.commands.impl;

import com.virtusa.codetest.commands.IGalaxyCommand;
import com.virtusa.codetest.config.PatternConstants;
import com.virtusa.codetest.databank.MetaData;
import com.virtusa.codetest.roman.GalaxyRomanNumber;

/*
 * The HowMuchCommand class executes the commands like
 * "how much is pish ?"
 *  
 */
public class CommandHowMuch implements IGalaxyCommand {

	private String words;
	private MetaData bank;

	public CommandHowMuch(MetaData bank, String words) {
		this.words = words;
		this.bank = bank;
	}

	@Override
	public void execute() {
		try {
			String roman = bank.getRomanFromString(words);

			if (roman == "") {
				System.out.println(PatternConstants.WRONG_COMMAND_MESSAGE);
				return;
			}

			if (GalaxyRomanNumber.isValidRomanNumber(roman)) {
				int arabic = GalaxyRomanNumber.romanNumberToArabic(roman);
				System.out.println(words + " is " + arabic);
			} else {
				System.out.println(PatternConstants.WRONG_COMMAND_MESSAGE);
			}
		} catch (Exception e) {
			System.out.println("Exception while executing HowMuchCommand execute method" + e.getMessage());
		}
	}
}
