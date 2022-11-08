package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is used to alphabetically count and sort elements that are being analyzed.
 * 
 * @author lucmetz
 *
 */
public class CountOccurrences implements IOccurrencesCounter {

	/**
	 * 
	 *         @See com.hemebiotech.analytics.IOccurrencesCounter#runCountOccurrences(List)
	 */
	public Map<String, Integer> runCountOccurrences(List<String> symptoms) {
		Map<String, Integer> sortedElements = new TreeMap<String, Integer>();

		System.out.println("Counting symptoms occurrences...");

		for (String symptom : symptoms) {

			if (sortedElements.containsKey(symptom)) {
				sortedElements.put(symptom, sortedElements.get(symptom) + 1);
			} else {
				sortedElements.put(symptom, 1);
			}
		}

		return sortedElements;
	}
}
