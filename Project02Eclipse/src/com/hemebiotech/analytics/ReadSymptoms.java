package com.hemebiotech.analytics;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;

		/**
		 * This class is used to read the source file and put its elements into a HashMap.
		 * 
		 * @author lucmetz
		 *
		 */
public class ReadSymptoms {
	private String filePath;

		/**
		 * @param filePath the path and name of the source file to read
		 */
	public ReadSymptoms(String filePath) {
		this.filePath = filePath;
	}

		/** Reads the file and returns a HashMap with its lines text content as keys
		 *  and the occurrences of redundant lines in the file as corresponding values.
		 * 
		 * @return a HashMap of the line elements and their occurrences in the file
		 * @throws IOException If an I/O error occurs.
		 */
	public HashMap<String, Integer> runReadSymptoms() throws IOException {
		String symptom = null;
		HashMap<String, Integer> symptoms = new HashMap<>();
		int count = 0;

		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));

			do {
				symptom = reader.readLine();

				if (symptoms.containsKey(symptom)) {
					symptoms.put(symptom, symptoms.get(symptom) + 1);
					count++;
				} else {
					if (symptom != null)	{
						symptoms.put(symptom, 1);
						count++;
					}
				}
			} while (symptom != null);
			
			reader.close();
			System.out.println("Successfully read " + count + " symptoms.");
		}

		catch (IOException e) {
			System.out.println(e);
			System.out.println("Analyze failed.");
			System.exit(-1);
		}

		return symptoms;
	}
}
