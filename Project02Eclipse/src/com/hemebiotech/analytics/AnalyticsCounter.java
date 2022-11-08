package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * This class is used to perform the analyze.
 * 
 * @author lucmetz
 *
 */
public class AnalyticsCounter {
	private String sourceFilePath;
	private String targetFilePath;

	/**
	 * @param sourceFilePath the path and name of the source file to analyze
	 * @param targetFilePath the path and name of the target file in which the
	 *                       analyze output is written
	 */
	public AnalyticsCounter(String sourceFilePath, String targetFilePath) {
		this.sourceFilePath = sourceFilePath;
		this.targetFilePath = targetFilePath;
	}

	/**
	 * Performs the analyze in 3 steps using 3 classes (ReadSymptoms,
	 * SortOccurrences, Write Occurrences)
	 * 
	 * <ol>
	 * <li>READS SYMPTOMS LISTS AND LISTS OCCURRENCES<br />
	 * Uses ReadSymptomDataFromFile class to generate a new ArrayList with with
	 * symptoms and their occurrences in a String format</li>
	 * 
	 * <li>COUNTS SYMPTOMS ALPHABETICALLY<br />
	 * Uses CountOccurrences class to sort the ArrayList alphabetically
	 * by generating a TreeMap which keys and values correspond to
	 * the symptoms names and occurrences, respectively</li>
	 *
	 * <li>WRITES SORTED SYMPTOMS LIST WITH OCCURRENCES IN AN OUTPUT FILE<br />
	 * Uses WriteSymptomDataToFile class to write the above generated map into a
	 * file of the specified path and name</li>
	 * </ol>
	 * 
	 */
	public void runAnalyze() {
		List<String> symptoms = null;
		Map<String, Integer> sortedSymptoms = null;

		ISymptomReader readSymptoms = new ReadSymptomDataFromFile();
		symptoms = readSymptoms.getSymptoms(sourceFilePath);

		IOccurrencesCounter countOccurrences = new CountOccurrences();
		sortedSymptoms = countOccurrences.runCountOccurrences(symptoms);

		ISymptomWriter writeSymptomDataToFile = new WriteSymptomDataToFile(targetFilePath);
		writeSymptomDataToFile.runWriteOccurrences(sortedSymptoms);
	}
}