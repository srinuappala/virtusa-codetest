/*
 * 
 */
package com.virtusa.codetest.commands.impl;

import com.virtusa.codetest.commands.IGalaxyCommand;
import com.virtusa.codetest.config.PatternConstants;
import com.virtusa.codetest.databank.MetaData;
import com.virtusa.codetest.roman.GalaxyRomanNumber;

/*
 * The HowManyCommand class executes the commands like
 * "how many Credits is pish Iron ?"
 *  
 */
public class CommandHowMany implements IGalaxyCommand {

	private String words;
	private String item;
	MetaData metaData;

	public CommandHowMany(MetaData metaData, String words, String item) {
		this.words = words;
		this.item = item;
		this.metaData = metaData;
	}

	@Override
	public void execute() {
		try {
			String roman = metaData.getRomanFromString(words);

			if (roman == "" || metaData.getCredit(item) == null) {
				System.out.println(PatternConstants.WRONG_COMMAND_MESSAGE);
				return;
			}

			if (GalaxyRomanNumber.isValidRomanNumber(roman)) {
				int arabic = GalaxyRomanNumber.romanNumberToArabic(roman);
				double value = Double.valueOf(metaData.getCredit(item));
				double finalValue = arabic * value;
				System.out.println(words + " " + item + " is " + finalValue + " Credits");
			} else {
				System.out.println(PatternConstants.WRONG_COMMAND_MESSAGE);
			}
		} catch (Exception e) {

			System.out.println("Exception while executing HowManyCommand execute method" + e.getMessage());
		}
	}
}
