package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int dilatedPupilCount = 0;
	
	public static void main(String args[]) throws Exception {

		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;
		
		while (line != null) {
			i++;
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headacheCount++;
			}
			else if (line.equals("rash")) {
				rashCount++;
			}
			else if (line.equals("dilated pupils")) {
				dilatedPupilCount++;
			}

			line = reader.readLine();
		}
		
		FileWriter writer = new FileWriter ("result.out");
		PrintWriter printWriter = new PrintWriter (writer);
		printWriter.println("headache: " + headacheCount);
		printWriter.println("rash: " + rashCount);
		printWriter.println("dilated pupils: " + dilatedPupilCount);
		printWriter.close();
	}
}
