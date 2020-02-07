package com.virtusa.codetest.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

	/*
	 * This method returns a list of test data as commands from a given input
	 * file
	 * 
	 * @param file
	 */
	public static ArrayList<String> readDataFile(String file) throws IOException {
		BufferedReader br = null;
		try {
			ArrayList<String> queries = new ArrayList<String>();
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					queries.add(line);
				}
			}
			return queries;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				throw e;
			}
		}
	}

}
