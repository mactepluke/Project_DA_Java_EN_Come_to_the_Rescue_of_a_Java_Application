package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteOccurrences {
	String targetFilePath;
	ArrayList<String> elements;

	public WriteOccurrences(String targetFilePath, ArrayList<String> elements) {
		this.targetFilePath = targetFilePath;
		this.elements = elements;
	}

	// Writes the String elements from the ArrayList one line at a time in the specified file
	public void runWriteOccurrences() throws IOException {

		try {
			FileWriter writer = new FileWriter("result.out");
			PrintWriter printWriter = new PrintWriter(writer);

			for (String element : elements) {
				printWriter.println(element);
			}

			printWriter.close();
		}

		catch (IOException e) {
			System.out.println(e);
			System.out.println("Analyze failed.");
			System.exit(-1);
		}
	}
}
