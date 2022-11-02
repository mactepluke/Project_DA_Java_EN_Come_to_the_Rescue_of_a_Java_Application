package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class SortOccurrences {
	HashMap<String, Integer> mapElements;

	public SortOccurrences(HashMap<String, Integer> mapElements) {
		this.mapElements = mapElements;
	}

	//Returns a sorted ArrayList of Strings created from the HashMap that contains the symptom names and their occurrences
	//WARNING: the mapping is lost at this level as the returned ArrayList contains only Stings. It is generated for writing/display purposes,
	//further operations on the symptoms should be performed using the unsorted HashMap only if needed so the data structure is not broken.
	public ArrayList<String> runSortOccurrences()	{
		ArrayList<String> sortedElements = new ArrayList<String>();
		
		for (String mapElement : mapElements.keySet()) {
			sortedElements.add(mapElement + ": " + mapElements.get(mapElement));
		}
		
		Collections.sort(sortedElements);
		
		return sortedElements;
	}
}