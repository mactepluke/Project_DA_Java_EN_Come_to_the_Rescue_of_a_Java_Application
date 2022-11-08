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
	 * Alphabetically sorts the elements of the list given as the class parameter
	 * by generating a TreeMap with symptoms names as keys and their occurrences as values.
	 * 
	 * @param symptoms a list of the elements that must be sorted
	 * @return sortedElements a Map of the elements.
	 */
	public Map<String, Integer> runCountOccurrences(List<String> symptoms);
}