package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

/**
 * This class is used to write the analyze output in the corresponding file.
 * 
 * @author lucmetz
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	private String targetFilePath;

	/**
	 * 
	 * @param targetFilePath the path and name to the output file in which the
	 *                       elements will be written
	 */
	public WriteSymptomDataToFile(String targetFilePath) {
		this.targetFilePath = targetFilePath;
	}

	/**
	 *                 @See com.hemebiotech.analytics.ISymptomWriter#runWriteOccurrences(Map)
	 */
	public void runWriteOccurrences(Map<String, Integer> elements) {

		System.out.println("Writing file: " + targetFilePath + "...");

		try (FileWriter writer = new FileWriter(targetFilePath)) {
			PrintWriter printWriter = new PrintWriter(writer);

			for (Entry<String, Integer> entry : elements.entrySet()) {

				printWriter.println(entry.getKey() + ": " + entry.getValue());
			}

		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
