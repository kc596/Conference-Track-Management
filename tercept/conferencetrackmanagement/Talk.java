package tercept.conferencetrackmanagement;

/**
 * The {@code Talk} class represents a Talk.
 * It is defined as a default class to prevent access from outside the package.
 * 
 * @author Kunal Chaudhary
 */

class Talk implements Comparable<Talk>{
	private Integer duration;								// duration of the talk in minutes
	private String title;									// title of the talk
	final boolean IS_LIGHTNING;								// true if talk's a lightning

	/**
	 * Initializes instance variables of Talk
	 *
	 * @param duration of the talk
	 * @param title of the talk
	 * @param lightning - true if its a lightning, false otherwise
	 */
	Talk(int duration, String title, boolean lightning){
		this.duration = duration;
		this.title = title;
		this.IS_LIGHTNING = lightning;
	}

	/**
	 * @return the duration of the talk
	 */
	public int getDuration(){
		return duration;
	}

	/**
	 * @return the title of the talk
	 */
	public String getTitle(){
		return title;
	}

	/**
	 * Compares two talks on the basis of talk duration.
	 *
	 * @return 	1 if duration of this talk is greater than other
	 * 			-1 if duration of this talk is less than other
	 *			0 if duration of both the talks are same
	 */
	public int compareTo(Talk other){
		return duration.compareTo(other.duration);
	}
}