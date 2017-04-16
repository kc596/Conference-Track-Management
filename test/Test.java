package test;

import tercept.conferencetrackmanagement.Scheduler;
import tercept.conferencetrackmanagement.util.*;

/**
 * The {@code Test} class to schedule an conference.
 * 
 * @author Kunal Chaudhary
 */

public class Test {
	public static void main(String[] args){
		InputParser in = new InputParser("input/input.txt");				// InputParser parses the input from input file
		OutputWriter out = new OutputWriter("output/output.txt");			// OutpurWriter writes the output to output file
		
		Scheduler scheduler = new Scheduler(in.getListOfTalksAsString());	// Scheduler - creates the required conference
		for(String s: scheduler.getSchedule())
			out.print(s);
		out.close();														// Closing the PrintWriter and releasing resource
	}
}