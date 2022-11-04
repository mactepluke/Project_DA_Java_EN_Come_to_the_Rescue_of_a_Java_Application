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
public class WriteOccurrences implements IsAWriteOccurrences	{
	private String targetFilePath;

		/**
		 * 
		 * @param targetFilePath the path and name to the output file in which the elements will be written
		 */
	public WriteOccurrences(String targetFilePath) {
		this.targetFilePath = targetFilePath;
	}

	/** 
	 * 
	 * @param elements the map containing the elements to be printed.
	 * 
	 * See {@link IsAWriteOccurrences public void runWriteOccurrences(Map<String, Integer> elements)}
	 */
	public void runWriteOccurrences(Map<String, Integer> elements)	{
		
		System.out.println("Writing file: " + targetFilePath + "...");
		
		try (FileWriter writer = new FileWriter(targetFilePath))	{
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
