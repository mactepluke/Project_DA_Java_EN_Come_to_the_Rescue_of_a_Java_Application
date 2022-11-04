package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;

/**
 * Anything that count the elements read during the analyse.
 * 
 * @author lucmetz
 *
 */
public interface IsACountOccurrences	{
	
	/**
	 * Alphabetically sorts the elements of the HashMap given as the class parameter
	 * after concatenating its keys and values as Strings and putting them in a new
	 * ArrayList.
	 * 
	 * @param symptoms an HashMap of the elements that must be sorted
	 * @return sortedElements a TreeMap of the elements.
	 */
	public Map<String, Integer> runCountOccurrences(ArrayList<String> symptoms);
}