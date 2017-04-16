package tercept.conferencetrackmanagement;

import java.util.List;
import java.util.ArrayList;

import tercept.conferencetrackmanagement.util.Time;

/**
 * The {@code Session} represents a session.
 * It is defined as a default class to prevent access from outside the package.
 * 
 * @author Kunal Chaudhary
 */

class Session {
	final boolean IS_MORNING_SESSION, IS_AFTERNOON_SESSION;
	final int START_TIME;
	private int freeTime;
	private ArrayList<Talk> talks;

	/**
	 * Initializes local variables and type of session.
	 *
	 * @param type of the session - "MORNING" or "AFTERNOON"
	 * @throws IllegalArgumentException if type of session is invalid.
	 */
	Session(String type){
		switch(type){
			case "MORNING":
				this.IS_MORNING_SESSION = true;
				this.IS_AFTERNOON_SESSION = false;
				this.START_TIME = 9*60;				// 9:00 AM
				this.freeTime = 3*60;				// 9:00 AM - 12:00 PM
				this.talks = new ArrayList<Talk>();
				break;

			case "AFTERNOON":
				this.IS_MORNING_SESSION = false;
				this.IS_AFTERNOON_SESSION = true;
				this.START_TIME = 12*60 + 1*60;		// 1:00 PM
				this.freeTime = 4*60;				// 1:00 PM - 4:00 PM or 5:00 PM
				this.talks = new ArrayList<Talk>();
				break;

			default: throw new IllegalArgumentException("Illegal type of session.");
		}
	}

	/** 
	 * Function to add a talk to session.
	 * 
	 * @throws RuntimeException if a talk of larger duration is added.
	 */
	public void addTalk(Talk t){
		if(t.getDuration()>freeTime)
			throw new RuntimeException("Duration of talk exceeds available time.");
		talks.add(t);
		freeTime -= t.getDuration();
	}

	/**
	 * @return the list of talks of this session.
	 */
	public List<Talk> getTalks(){
		return this.talks;
	}

	/**
	 * @return extra time in the session.
	 */
	public int getFreeTime(){
		return freeTime;
	}

	/**
	 * @return a String containing schedule of the session is given format.
	 */
	public String toString(){
		int start = START_TIME;
		String result = "";
		for(Talk t:talks){
			result += Time.minutesToDisplayTime(start);
			result += " "+t.getTitle()+" ";
			if(t.IS_LIGHTNING) result += "lightning\n";
			else result += t.getDuration()+"min\n";
			start += t.getDuration();
		}
		return result;
	}
}