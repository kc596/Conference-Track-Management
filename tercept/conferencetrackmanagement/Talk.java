package tercept.conferencetrackmanagement;

/**
 * The {@code Talk} class represents a Talk.
 * It is defined as a default class to prevent access from outside package.
 * 
 * @author Kunal Chaudhary
 */

class Talk implements Comparable<Talk>{
	private Integer duration;
	private String title;
	final boolean IS_LIGHTNING;

	Talk(int duration, String title, boolean lightning){
		this.duration = duration;
		this.title = title;
		this.IS_LIGHTNING = lightning;
	}

	public int getDuration(){
		return duration;
	}

	public String getTitle(){
		return title;
	}

	public int compareTo(Talk x){
		return duration.compareTo(x.duration);
	}
}