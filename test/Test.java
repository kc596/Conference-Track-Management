package test;

import tercept.conferencetrackmanagement.util.*;

/**
 * Test class to schedule an conference.
 * 
 * @author Kunal Chaudhary
 */

public class Test {
	public static void main(String[] args) throws Exception{
		InputParser in = new InputParser("input/input.txt");
		OutputWriter out = new OutputWriter("output/output.txt");

		for(String s : in.getListOfTalks()){
			out.println(s);
		}

		out.close();
	}
}