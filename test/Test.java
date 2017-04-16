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
		InputParser in = new InputParser("input/input.txt");
		OutputWriter out = new OutputWriter("output/output.txt");
		Scheduler scheduler = new Scheduler(in.getListOfTalksAsString());
		for(String s: scheduler.getSchedule()){
			System.out.print(s);
		}
		out.close();
	}
}