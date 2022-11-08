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
	 * Writes the Map given as the class parameter in the specified file.
	 * 
	 * @param elements the Map containing the elements to be printed
	 * 
	 */
	public void runWriteOccurrences(Map<String, Integer> elements);
}