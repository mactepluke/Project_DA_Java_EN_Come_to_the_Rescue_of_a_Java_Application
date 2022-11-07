package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Anything that count the elements read during the analyse.
 * 
 * @author lucmetz
 *
 */
public interface IOccurrencesCounter {

	/**
	 * Alphabetically sorts the elements of the HashMap given as the class parameter
	 * after concatenating its keys and values as Strings and putting them in a new
	 * ArrayList.
	 * 
	 * @param symptoms a list of the elements that must be sorted
	 * @return sortedElements a TreeMap of the elements.
	 */
	public Map<String, Integer> runCountOccurrences(List<String> symptoms);
}