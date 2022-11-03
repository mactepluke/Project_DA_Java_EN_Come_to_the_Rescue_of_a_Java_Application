package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

		/**
		 * This class is used to write the analyze output in the corresponding file.
		 * 
		 * @author lucmetz
		 *
		 */
public class WriteOccurrences {
	private String targetFilePath;
	private ArrayList<String> elements;

		/**
		 * 
		 * @param targetFilePath the path and name to the output file in which the elements will be written
		 * @param elements the ArrayList of String elements that will be written in the output file
		 */
	public WriteOccurrences(String targetFilePath, ArrayList<String> elements) {
		this.targetFilePath = targetFilePath;
		this.elements = elements;
	}

		/** Writes the String elements from the ArrayList given as the class parameter,
		 * one line at a time in the specified file.
		 * 
		 * @throws IOException If an I/O error occurs.
		 */
	public void runWriteOccurrences() throws IOException {

		try {
			FileWriter writer = new FileWriter(targetFilePath);
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
