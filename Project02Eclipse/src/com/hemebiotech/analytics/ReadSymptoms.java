package com.hemebiotech.analytics;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * This class is used to read the source file and put its elements into a
 * HashMap.
 * 
 * @author lucmetz
 *
 */
public class ReadSymptoms implements IsAReadSymptoms	{

	/** 
	 * @param filePath the path and name of the source file to read
	 * @return a HashMap of the line elements and their occurrences in the file
	 * 
	 * See {@link IsAReadSymptoms public ArrayList<String> runReadSymptoms(String filePath)}
	 */
	public ArrayList<String> runReadSymptoms(String filePath) {
		String symptom = null;
		ArrayList<String> symptoms = null;
		int count = 0;

		symptoms = new ArrayList<>();
		
		System.out.println("Reading file: " + filePath + "...");
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

			do {
				symptom = reader.readLine();
				if (symptom != null)	{
					symptoms.add(symptom);
					count++;
				}
			} while (symptom != null);
			System.out.println("Read " + count + " symptoms.");
		}
		
		catch (IOException e)	{
			e.printStackTrace();
		}
		return symptoms;
	}
}
