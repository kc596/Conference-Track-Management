package tercept.conferencetrackmanagement;

/**
 * The {@code Track} represents track of a conference.
 * A track consist of a 2 sessions, Lunch and Networking event.
 * It is defined as a default class to prevent access from outside the package.
 * 
 * @author Kunal Chaudhary
 */

class Track {
	final Session morningSession, afternoonSession;

	/**
	 * Creates the sessions of the track.
	 */
	public Track(){
		this.morningSession = new Session("MORNING");
		this.afternoonSession = new Session("AFTERNOON");
	}
}