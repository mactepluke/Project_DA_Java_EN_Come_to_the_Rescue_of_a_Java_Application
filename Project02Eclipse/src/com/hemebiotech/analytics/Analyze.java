package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
		
		/** 
		 * This class is used to perform the analyze.
		 * 
		 * @author lucmetz
		 *
		 */
public class Analyze {
	private String sourceFilePath;
	private String targetFilePath;

		/** 
		 * @param sourceFilePath the path and name of the source file to analyze
		 * @param targetFilePath the path and name of the target file in which the analyze output is written
		 */
	public Analyze(String sourceFilePath, String targetFilePath) {
		this.sourceFilePath = sourceFilePath;
		this.targetFilePath = targetFilePath;
	}

		/** Performs the analyze in 3 steps using 3 classes (ReadSymptoms, SortOccurrences, Write Occurrences)
		 * 
		 * 	<ol>
		 *	<li> READS SYMPTOMS LISTS AND LISTS OCCURRENCES
		 * 	Uses ReadSymptoms class to generate a new HashMap with that lists pairs of symptoms and their occurrences</li>
		 * 
		 * 	<li> SORTS SYMPTOMS ALPHABETICALLY
		 *	Uses SortSymptoms class to sort the HashMap keys (symptoms) alphabetically and returns an ArrayList
		 *	in which each entry is a concatenated String of the symptom and its occurrences in a more easy to write format</li>
		 *
		 *	<li> WRITES SORTED SYMPTOMS LIST WITH OCCURRENCES IN OUTPUT FILE
		 * 	Uses WriteOccurrences class to write the above generated ArrayList into a filed of the specified path and name</li>
		 *	</ol>
		 * 
		 * @throws IOException If an I/O error occurs.
		 * 
		 */
	public void runAnalyze() throws IOException	{
		HashMap<String, Integer> symptoms = null;
		ArrayList<String> sortedSymptoms = null;


			System.out.println("Reading file: " + sourceFilePath + "...");
			ReadSymptoms readSymptoms = new ReadSymptoms(sourceFilePath);
			symptoms = readSymptoms.runReadSymptoms();

			System.out.println("Sorting symptoms occurrences...");
			SortOccurrences sortOccurrences = new SortOccurrences(symptoms);
			sortedSymptoms = sortOccurrences.runSortOccurrences();

			System.out.println("Writing file: " + targetFilePath + "...");
			WriteOccurrences writeOccurrences = new WriteOccurrences(targetFilePath, sortedSymptoms);
			writeOccurrences.runWriteOccurrences();
	}
}
