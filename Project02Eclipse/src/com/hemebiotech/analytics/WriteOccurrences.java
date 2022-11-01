package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class WriteOccurrences {
	String targetFilePath;
	HashMap<String, Integer> symptoms;

	public WriteOccurrences(String targetFilePath, HashMap<String, Integer> symptoms) {
		this.targetFilePath = targetFilePath;
		this.symptoms = symptoms;
	}

	public void runWriteOccurrences() throws IOException {

		try {
			FileWriter writer = new FileWriter("result.out");
			PrintWriter printWriter = new PrintWriter(writer);

			for (String symptom : symptoms.keySet()) {
				printWriter.println(symptom + ": " + symptoms.get(symptom));
			}

			printWriter.close();
		}

		catch (IOException e) {

		}

	}

}
