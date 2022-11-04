package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Anything that read the results from the source file.
 * 
 * @author lucmetz
 *
 */
public interface IsAReadSymptoms	{

	/**
	 * Reads the file and returns a HashMap with its lines text content as keys and
	 * the occurrences of redundant lines in the file as corresponding values.
	 * 
	 * @param filePath the path and name of the source file to read
	 * @return a HashMap of the line elements and their occurrences in the file
	 */
	public ArrayList<String> runReadSymptoms(String filePath);
}