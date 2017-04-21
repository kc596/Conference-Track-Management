package kc596.conferencetrackmanagement.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Utility class to writer to output file.
 * 
 * @author Kunal Chaudhary
 */

public class OutputWriter{
	private PrintWriter writer = null;
	private final String outputFileLocation;

	/**
	 * Initializes the local variables and opens the output file.
	 *
	 * @param outputFileLocation is the location of file to write output to.
	 */
	public OutputWriter(String outputFileLocation){
		this.outputFileLocation = new File("").getAbsolutePath()+""+outputFileLocation;
		try{
			writer = new PrintWriter(outputFileLocation);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	/**
	 * function for writing some output to file.
	 */
	public void print(String s){
		writer.print(s);
	}

	/**
	 * closes the writer and release resources.
	 */
	public void close(){
		writer.close();
	}
}