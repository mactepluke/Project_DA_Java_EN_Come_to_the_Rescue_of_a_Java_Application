package com.hemebiotech.analytics;

/**
 * This class uses the Analyze class to read a symptoms file, sort it
 * alphabetically and write the results in an output file in the form of a non
 * redundant symptoms list present in the source file, with their occurrences.
 * 
 * @author lucmetz
 *
 */
public class Analyze {
	private static final String SOURCE_FILE_PATH = "symptoms.txt";
	private static final String TARGET_FILE_PATH = "result.out";

	/**
	 * 
	 * @param args no use is made of this class arguments in the current
	 *             implementation
	 * @throws Exception
	 */
	public static void main(String args[]) {

		AnalyticsCounter newAnalyticsCounter = new AnalyticsCounter(SOURCE_FILE_PATH, TARGET_FILE_PATH);

		newAnalyticsCounter.runAnalyze();
		System.out.println("Analyze done.");
	}
}
