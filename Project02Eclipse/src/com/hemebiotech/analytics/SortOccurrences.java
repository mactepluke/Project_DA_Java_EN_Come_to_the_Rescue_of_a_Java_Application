package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

		/** 
		 * This class is used to alphabetically sort elements that are being analyzed.
		 * 
		 * @author lucmetz
		 *
		 */
public class SortOccurrences {
	private HashMap<String, Integer> mapElements;

		/** 
		 * @param mapElements an HashMap of the elements that must be sorted.
		 */
	public SortOccurrences(HashMap<String, Integer> mapElements) {
		this.mapElements = mapElements;
	}

		/** Alphabetically sorts the elements of the HashMap given as the class parameter
		 * after concatenating its keys and values as Strings and putting them in a new ArrayList.
		 * 
		 * @return	sortedElements a sorted ArrayList of Strings that concatenate the keys and the values of the HashMap contents
		 */
	public ArrayList<String> runSortOccurrences()	{
		ArrayList<String> sortedElements = new ArrayList<String>();
		
		for (String mapElement : mapElements.keySet()) {
			sortedElements.add(mapElement + ": " + mapElements.get(mapElement));
		}
		
		Collections.sort(sortedElements);
		
		return sortedElements;
	}
}
