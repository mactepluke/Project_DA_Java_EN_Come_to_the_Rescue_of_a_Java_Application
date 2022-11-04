package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * This class is used to alphabetically sort elements that are being analyzed.
 * 
 * @author lucmetz
 *
 */
public class CountOccurrences implements IsACountOccurrences	{

	/** 
	 * @param symptoms an HashMap of the elements that must be sorted
	 * @return sortedElements a TreeMap of the elements.
	 * 
	 * See {@link IsACountOccurrences public Map<String, Integer> runCountOccurrences(ArrayList<String> symptoms)}
	 */
	public Map<String, Integer> runCountOccurrences(ArrayList<String> symptoms) {
		Map<String, Integer> sortedElements = new TreeMap<String, Integer>();

		System.out.println("Counting symptoms occurrences...");

		for (String symptom : symptoms) {

			if (sortedElements.containsKey(symptom)) {
				sortedElements.put(symptom, sortedElements.get(symptom) + 1);
			} else
				sortedElements.put(symptom, 1);
		}

		return sortedElements;
	}
}
