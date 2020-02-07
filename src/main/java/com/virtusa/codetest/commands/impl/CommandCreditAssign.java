/*
 * 
 */
package com.virtusa.codetest.commands.impl;

import com.virtusa.codetest.commands.IGalaxyCommand;
import com.virtusa.codetest.config.PatternConstants;
import com.virtusa.codetest.databank.MetaData;
import com.virtusa.codetest.roman.GalaxyRomanNumber;

/*
 * The CreditAssignCommand class executes the commands like
 * "pish Iron is 10 Credits"
 * 
 */
public class CommandCreditAssign implements IGalaxyCommand {

	private String words;
	private String item;
	private String value;
	private MetaData metaData;

	public CommandCreditAssign(MetaData metaData, String words, String item, String value) {
		this.words = words;
		this.item = item;
		this.value = value;
		this.metaData = metaData;
	}

	@Override
	public void execute() {
		try {
			String roman = metaData.getRomanFromString(words);

			if (roman == "") {
				System.out.println(PatternConstants.WRONG_COMMAND_MESSAGE);
				return;
			}

			if (GalaxyRomanNumber.isValidRomanNumber(roman)) {
				int arabic = GalaxyRomanNumber.romanNumberToArabic(roman);
				int creditValue = Integer.parseInt(this.value);
				double finalValue = ((double) creditValue / arabic);
				metaData.setCredit(item, Double.valueOf(finalValue));
			} else {
				System.out.println(PatternConstants.WRONG_COMMAND_MESSAGE);
			}
		} catch (NumberFormatException e) {
			System.out.println("Exception while executing the CreditAssignCommand execute method " + e.getMessage());
		}
	}
}
