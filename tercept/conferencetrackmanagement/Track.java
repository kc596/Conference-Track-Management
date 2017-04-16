package tercept.conferencetrackmanagement;

/**
 * The {@code Track} represents track of a conference.
 * A track consist of a 2 sessions, Lunch and Networking event.
 * 
 * @author Kunal Chaudhary
 */

class Track {
	final Session morningSession, afternoonSession;
	public Track(Session morningSession, Session afternoonSession){
		this.morningSession = morningSession;
		this.afternoonSession = afternoonSession;
	}
}