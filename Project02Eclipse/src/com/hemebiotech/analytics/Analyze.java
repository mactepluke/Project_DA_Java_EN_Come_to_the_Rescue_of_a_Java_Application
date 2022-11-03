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

		// "3-STEP ANALYZE USING 3 CLASSES (ReadSymptoms, SortOccurrences, Write Occurrences)
	public void runAnalyze() throws IOException	{
		HashMap<String, Integer> symptoms = null;
		ArrayList<String> sortedSymptoms = null;

		// 	1) READS SYMPTOMS LISTS AND LISTS OCCURRENCES
		//	Uses ReadSymptoms class to generate a new HashMap with that lists pairs of symptoms and their occurrences
			System.out.println("Reading file: " + sourceFilePath + "...");
			ReadSymptoms readSymptoms = new ReadSymptoms(sourceFilePath);
			symptoms = readSymptoms.runReadSymptoms();

		//	2) SORTS SYMPTOMS ALPHABETICALLY
		// 	Uses SortSymptoms class to sort the HashMap keys (symptoms) alphabetically and returns an ArrayList
		//	in which each entry is a concatenated String of the symptom and its occurrences in a more easy to write format
			System.out.println("Sorting symptoms occurrences...");
			SortOccurrences sortOccurrences = new SortOccurrences(symptoms);
			sortedSymptoms = sortOccurrences.runSortOccurrences();

		//	3) WRITES SORTED SYMPTOMS LIST WITH OCCURRENCES IN OUTPUT FILE
		// 	Uses WriteOccurrences class to write the above generated ArrayList into a filed of the specified path and name
			System.out.println("Writing file: " + targetFilePath + "...");
			WriteOccurrences writeOccurrences = new WriteOccurrences(targetFilePath, sortedSymptoms);
			writeOccurrences.runWriteOccurrences();
	}
}