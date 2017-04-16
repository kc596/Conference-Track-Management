package tercept.conferencetrackmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
/**
 * 
 * 
 * @author Kunal Chaudhary
 */

public class Scheduler {
	static final int MORNING_SESSION_MAX_DURATION = 180, AFTERNOON_SESSION_MAX_DURATION = 240;
	static final int TRACK_MAX_DURATION = 420;
	private int totalTalkDuration;
	private int numberOfTracks;
	private Track[] conference;

	public Scheduler(List<String> listOfTalksAsString){
		ArrayList<Talk> listOfTalks = parseListOfTalks(listOfTalksAsString);
		Collections.sort(listOfTalks, Collections.reverseOrder());
		
		numberOfTracks = (totalTalkDuration+(TRACK_MAX_DURATION-1))/TRACK_MAX_DURATION; 		// minimum number of tracks
		conference = new Track[numberOfTracks];													// creating the conference
		for(int i=0; i<numberOfTracks; i++)
			conference[i] = new Track(new Session("MORNING"), new Session("AFTERNOON"));

		while(!scheduleConference(listOfTalks)){
			numberOfTracks++;
			conference = new Track[numberOfTracks];
			for(int i=0; i<numberOfTracks; i++)
				conference[i] = new Track(new Session("MORNING"), new Session("AFTERNOON"));
		}
	}

	public ArrayList<String> getSchedule(){
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
				listOfTalks.add(new Talk(minutes, s.substring(0,i), false));
				totalTalkDuration += minutes;
			}
		}
		return listOfTalks;
	}

	private boolean scheduleConference(List<Talk> listOfTalks){
		boolean[] marked = new boolean[listOfTalks.size()];
		for(int index=0; index<listOfTalks.size(); index++){
			Talk t = listOfTalks.get(index);
			for(int i=0; i<numberOfTracks; i++){
				if(conference[i].morningSession.getFreeTime()>=t.getDuration()){
					conference[i].morningSession.addTalk(t);
					marked[index] = true;
					break;
				}
			}
		}

		for(int index=0; index<listOfTalks.size(); index++){
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

		for(int i=0; i<listOfTalks.size(); i++){
			if(!marked[i]) return false;
		}

		return true;
	}
}