package tercept.conferencetrackmanagement.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Utility class to writer to output file.
 * 
 * @author Kunal Chaudhary
 */

public class OutputWriter{
	PrintWriter writer = null;
	final String outputFileLocation;

	public OutputWriter(String outputFileLocation){
		this.outputFileLocation = new File("").getAbsolutePath()+""+outputFileLocation;
		try{
			writer = new PrintWriter(outputFileLocation);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	public void print(String s){
		writer.print(s);
	}

	public void println(String s){
		writer.println(s);
	}

	public void close(){
		writer.close();
	}
}