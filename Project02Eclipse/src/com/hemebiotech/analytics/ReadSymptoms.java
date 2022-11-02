package com.hemebiotech.analytics;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;

public class ReadSymptoms {
	private String filePath;

	public ReadSymptoms(String filePath) {
		this.filePath = filePath;
	}

	// Reads the file and returns a HashMap with the symptom names as keys and their occurrences as values
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
			System.out.println("Cannot read file.");
		}
		return symptoms;
	}
}
