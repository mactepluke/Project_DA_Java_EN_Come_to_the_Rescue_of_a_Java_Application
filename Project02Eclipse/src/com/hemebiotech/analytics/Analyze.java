package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.HashMap;

public class Analyze {
	private String sourceFilePath;
	private String targetFilePath;
	
	public Analyze(String sourceFilePath, String targetFilePath) {
		this.sourceFilePath = sourceFilePath;
		this.targetFilePath = targetFilePath;
	}
		
	public void runAnalyze() throws IOException	{
		HashMap<String, Integer> symptoms = null;
		
		try {
			System.out.println("Reading file: " + sourceFilePath);
			ReadSymptoms readSymptoms = new ReadSymptoms(sourceFilePath);
			symptoms = readSymptoms.runReadSymptoms();
		}

		catch (IOException e) {
			System.out.println("Cannot read file.");
		}
/*
		try {
			System.out.println("Counting symptoms occurrences...");
			//countOccurrences();
		}

		catch (Exception e) {
			System.out.println("Error counting occurrences.");
		}
*/
		try {
			System.out.println("Writing file: " + targetFilePath);
			WriteOccurrences writeOccurrences = new WriteOccurrences(targetFilePath, symptoms);
			writeOccurrences.runWriteOccurrences();
		}

		catch (IOException e) {
			System.out.println("Error writing file: " + targetFilePath);
		}

	}

}