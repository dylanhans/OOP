/*
 * Every class that implements this interface should have a toString method to return the name of the person, and the
 */
public interface Guessable extends Comparable<Person>{
	
	public String startMessage();
	
	public String closingMessage();
	
	public int getAwardedPointNumber();
	
}
