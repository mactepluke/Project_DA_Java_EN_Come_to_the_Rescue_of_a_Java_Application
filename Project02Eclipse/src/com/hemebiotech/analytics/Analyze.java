package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Analyze {
	private String sourceFilePath;
	private String targetFilePath;

	public Analyze(String sourceFilePath, String targetFilePath) {
		this.sourceFilePath = sourceFilePath;
		this.targetFilePath = targetFilePath;
	}

		// Method that performs the analyze in 3 steps by using 3 classes: ReadSymptoms, SortOccurrences and Write Occurrences
	public void runAnalyze() throws IOException {
		HashMap<String, Integer> symptoms = null;
		ArrayList<String> sortedSymptoms = null;

		// 1) Uses ReadSymptoms class to generate a new HashMap with that lists pairs of symptoms and their occurrences
		try {
			System.out.println("Reading file: " + sourceFilePath + "...");
			ReadSymptoms readSymptoms = new ReadSymptoms(sourceFilePath);
			symptoms = readSymptoms.runReadSymptoms();
		}

		catch (IOException e) {
			System.out.println("Cannot read file.");
			// WIP: exceptions management NEEDS TESTING
			//throw new RuntimeException(e);
			//e.printStackTrace();
			//System.exit(1);
		}

		// 3) Uses SortSymptoms class to sort the HashMap keys (symptoms) alphabetically and returns an ArrayList
		//in which each entry is a concatenated String of the symptom and its occurrences in a more easy to write format
		try {
			System.out.println("Sorting symptoms occurrences...");
			SortOccurrences sortOccurrences = new SortOccurrences(symptoms);
			sortedSymptoms = sortOccurrences.runSortOccurrences();
		}

		catch (Exception e) {
			System.out.println("Error sorting occurrences.");
		}

		// Uses WriteOccurrences class to write the above generated ArrayList into a filed of the specified path and name
		try {
			System.out.println("Writing file: " + targetFilePath + "...");
			WriteOccurrences writeOccurrences = new WriteOccurrences(targetFilePath, sortedSymptoms);
			writeOccurrences.runWriteOccurrences();
		}

		catch (IOException e) {
			System.out.println("Error writing file: " + targetFilePath);
		}
	}
}