package com.hemebiotech.analytics;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to read the source file and put its elements into an a list.
 * 
 * @author lucmetz
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	/**
	 *         @See com.hemebiotech.analytics.ISymptomReader#getSymptoms(String)
	 */
	public List<String> getSymptoms(String filePath) {
		String symptom = null;
		List<String> symptoms = null;
		int count = 0;

		symptoms = new ArrayList<>();

		System.out.println("Reading file: " + filePath + "...");

		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			do {
				symptom = reader.readLine();
				if (symptom != null) {
					symptoms.add(symptom.toLowerCase().trim());
					count++;
				}
			} while (symptom != null);
			System.out.println("Read " + count + " symptoms.");
		}

		catch (IOException e) {
			e.printStackTrace();
		}
		return symptoms;
	}
}
