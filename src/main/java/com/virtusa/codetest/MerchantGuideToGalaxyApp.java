package com.virtusa.codetest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.virtusa.codetest.commandparser.InputDataParser;
import com.virtusa.codetest.commands.IGalaxyCommand;

/*
 * The MerchantGuideToGalaxyApp class is the main class to read the file content and 
 * executes the each command given in the test data
 */

public class MerchantGuideToGalaxyApp {

	public static void main(String[] args) {

		try {

			System.out.println("************** Merchant Galaxy START ******************* \n");

			final ArrayList<String> input = (ArrayList<String>) Files.readAllLines(Paths.get(ClassLoader
					.getSystemResource("testinput1.txt").toURI()));

			InputDataParser inputParser = new InputDataParser();
			ArrayList<IGalaxyCommand> commands = inputParser.getCommandsFromFile(input);

			for (IGalaxyCommand command : commands) {
				command.execute();
			}

			commands.clear();

			System.out.println("\n***************** Merchant Galaxy END *********************");

		} catch (IOException e) {

			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
