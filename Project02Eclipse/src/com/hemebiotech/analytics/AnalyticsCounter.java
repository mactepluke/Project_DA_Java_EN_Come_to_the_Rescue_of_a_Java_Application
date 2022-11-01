package com.hemebiotech.analytics;

public class AnalyticsCounter {
	private static final String SOURCE_FILE_PATH = "symptoms.txt";
	private static final String TARGET_FILE_PATH = "result.out";

	public static void main(String args[]) throws Exception {

		Analyze newAnalyse = new Analyze(SOURCE_FILE_PATH, TARGET_FILE_PATH);
		
		try	{
			newAnalyse.runAnalyze();
		}
	
		catch	(Exception e)	{
			System.out.println("Analyze failed.");
		}
		
		finally	{
			System.out.println("Analyze successful.");
		}
	}
}
