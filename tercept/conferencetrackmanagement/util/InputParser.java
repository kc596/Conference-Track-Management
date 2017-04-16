package tercept.conferencetrackmanagement.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Utility class to read schedule from input file.
 * 
 * @author Kunal Chaudhary
 */

public class InputParser {
	private final String inputFileLocation;
	private List<String> listOfTalks;
	private final Pattern INPUT_LINE_PATTERN = Pattern.compile("^(.+)\\s(\\d+)?\\s?((min)|(lightning))$");

	/**
	 * Initializes the set of local variables and parses list of talks.
	 *
	 * @param inputFileLocation is the location of file to read input from
	 * @throws RuntimeException if format of input is not same as required.
	 * @throws RuntimeException if some error occurs while reading or parsing.
	 */
	public InputParser(String inputFileLocation){
		this.inputFileLocation = new File("").getAbsolutePath()+inputFileLocation;
		listOfTalks = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputFileLocation));
			String line = reader.readLine();
			while(line!=null){
				Matcher match = INPUT_LINE_PATTERN.matcher(line);
				if(!match.find())
					throw new RuntimeException("Invalid input format!");	// error due to invalid format of talk
				listOfTalks.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());						// error that occurred while reading file
		}
	}

	/**
	 * @return a list of talks parsed from the input file.
	 */
	public List<String> getListOfTalksAsString(){
		return listOfTalks;
	}
}