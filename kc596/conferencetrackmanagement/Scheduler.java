package kc596.conferencetrackmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * The {@code Scheduler} schedules the talks and is the heart of the project.
 * 
 * @author Kunal Chaudhary
 */

public class Scheduler {

	static final int MORNING_SESSION_MAX_DURATION = 180, AFTERNOON_SESSION_MAX_DURATION = 240;
	static final int TRACK_MAX_DURATION = 420;
	private int totalTalkDuration;															// duration of all the talks combined
	private int numberOfTracks;																// number of tracks of the conference
	private Track[] conference;																// conference is an array of tracks


	/**
	 * Initializes the local variables and monitors the scheduling.
	 *
	 * @param listOfTalksAsString contains the list of talks in form of strings.
	 */
	public Scheduler(List<String> listOfTalksAsString){
		ArrayList<Talk> listOfTalks = parseListOfTalks(listOfTalksAsString);				// getting list of talks from list of string
		Collections.sort(listOfTalks, Collections.reverseOrder());							// sorting list of talks according to duration
		
		numberOfTracks = (totalTalkDuration+(TRACK_MAX_DURATION-1))/TRACK_MAX_DURATION; 	// minimum number of tracks
		conference = new Track[numberOfTracks];												// creating the conference
		for(int i=0; i<numberOfTracks; i++)
			conference[i] = new Track();													// initializing each track of conference

		while(!scheduleConference(listOfTalks)){											// while talks didn't adjust in current number of tracks
			numberOfTracks++;																// increase the number of tracks
			conference = new Track[numberOfTracks];											// creating the conference with new number of tracks
			for(int i=0; i<numberOfTracks; i++)
				conference[i] = new Track();												// initializing the created track of conference
		}
	}


	/**
	 * @return the Schedule of conference is form of list of strings.
	 */
	public List<String> getSchedule(){
		ArrayList<String> result = new ArrayList<String>();
		for(int i=1; i<=numberOfTracks; i++){
			result.add("Track "+i+":\n");
			result.add(conference[i-1].morningSession.toString());
			result.add("12:00PM Lunch\n");
			result.add(conference[i-1].afternoonSession.toString());
			result.add("05:00PM Networking Event\n\n");
		}
		return result;
	}


	/**
	 * Helper function for parsing a Talk from string
	 *
	 * @return a list containing all the talks
	 * @throws RuntimeException if duration of any talk exceeds the duration of session.
	 */
	private ArrayList<Talk> parseListOfTalks(List<String> listOfTalksAsString){
		ArrayList<Talk> listOfTalks = new ArrayList<Talk>();
		totalTalkDuration = 0;
		for(String s : listOfTalksAsString){
			if(s.charAt(s.length()-1)=='g'){
				listOfTalks.add(new Talk(5, s.substring(0, s.length()-10), true));
				totalTalkDuration += 5;
			} else {
				String minuteString = "";
				int i;
				for(i=s.length()-4; s.charAt(i)<='9' && s.charAt(i)>='0'; i--)
					minuteString = s.charAt(i)+minuteString;
				int minutes = Integer.parseInt(minuteString);
				if(minutes > AFTERNOON_SESSION_MAX_DURATION)
					throw new RuntimeException("Talk : \""+s+"\" exceeds the duration of session.");
				listOfTalks.add(new Talk(minutes, s.substring(0,i), false));
				totalTalkDuration += minutes;
			}
		}
		return listOfTalks;
	}


	/**
	 * Responsible for scheduling the conference.
	 * 
	 * @return true if a conference could be scheduled using current number of tracks else false
	 */
	private boolean scheduleConference(List<Talk> listOfTalks){
		boolean[] marked = new boolean[listOfTalks.size()];									// for keeping track of scheduled talks

		for(int index=0; index<listOfTalks.size(); index++){								// scheduling morning session
			Talk t = listOfTalks.get(index);
			for(int i=0; i<numberOfTracks; i++){
				if(conference[i].morningSession.getFreeTime()>=t.getDuration()){
					conference[i].morningSession.addTalk(t);
					marked[index] = true;
					break;
				}
			}
		}

		for(int index=0; index<listOfTalks.size(); index++){								// scheduling afternoon session
			if(marked[index]) continue;
			Talk t = listOfTalks.get(index);
			for(int i=0; i<numberOfTracks; i++){
				if(conference[i].afternoonSession.getFreeTime()>=t.getDuration()){
					conference[i].afternoonSession.addTalk(t);
					marked[index] = true;
					break;
				}
			}
		}

		for(int i=0; i<listOfTalks.size(); i++){											// if some talks left to be scheduled, return false
			if(!marked[i]) return false;
		}

		return true;																		// return true if scheduling successful
	}
}