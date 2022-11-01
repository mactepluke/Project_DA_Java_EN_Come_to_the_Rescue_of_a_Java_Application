package com.hemebiotech.analytics;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.HashMap;

public class ReadSymptoms {
	private String file;

	public ReadSymptoms(String file) {
		this.file = file;
	}

	public HashMap<String, Integer> runReadSymptoms() throws IOException {
		String line = null;
		HashMap<String, Integer> symptoms = new HashMap<>();

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));

			do {
				line = reader.readLine();

				if (symptoms.containsKey(line)) {
					symptoms.put(line, symptoms.get(line) + 1);
				} else {
					if (line != null)	{
						symptoms.put(line, 1);
					}
				}
			} while (line != null);
			
			reader.close();
		}

		catch (IOException e) {
			System.out.println("Cannot read file.");
		}
		return symptoms;
	}
}
