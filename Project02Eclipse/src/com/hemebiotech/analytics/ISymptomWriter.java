package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Anything that write the results in the target file.
 * 
 * @author lucmetz
 *
 */
public interface ISymptomWriter {

	/**
	 * Writes the String elements from the ArrayList given as the class parameter,
	 * one line at a time in the specified file.
	 * 
	 * @param elements the map containing the elements to be printed.
	 * 
	 */
	public void runWriteOccurrences(Map<String, Integer> elements);
}