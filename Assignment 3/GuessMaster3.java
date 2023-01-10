//They will have most likely needed to import the Arrays, Scanner, and Random classes to accomplish this task

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;

public class GuessMaster3{
	
	private HashSet<GuessablePerson<?>> people;
	private int numPoints;
	
	public GuessMaster3() {
		numPoints = 0;
		people = new HashSet<>(0);
	}
	
	//this method was required. They needed to avoid privacy leaks
	public <M extends Person> void addPerson(M person, double difficulty) {
		GuessablePerson<M> newPerson = new GuessablePerson(person.clone(), difficulty);
		people.add(newPerson);
	}
	
	public HashSet<GuessablePerson<?>> getPeople(){
		return people;
	}
	
	//this method is required and could be implemented in any number of ways. The students needed to create any of the methods they use within this method.
	//I have created an example solution here which uses all of the methods and variables they had to define (plus a few more)
	//So long as they defined all their methods without privacy leaks, and accomplished the goals of the task they should get full marks
	public void startGame(){
		System.out.println("Welcome! Let's start the game!");
		
		Scanner user;
		//scanner object for getting user input
		File myFile = new File("C:/Users/Kyle/eclipse-workspace/GuessMaster3/src/test2");
		try {
			user = new Scanner(new FileInputStream("C:/Users/Kyle/eclipse-workspace/GuessMaster3/src/test.txt"));
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
			user = null;
		}
		
		Iterator<GuessablePerson<? extends Person>> peopleIterator = people.iterator();
		
		//the following loop(s) could have been done any number of ways, but here is a simple version that students probably did something similar to
		//this while loop repeats until the user quits
		while( peopleIterator.hasNext()) {
			GuessablePerson<? extends Person> currPerson = peopleIterator.next();
			System.out.println(currPerson.startMessage());
			//boolean value for when the user guesses correctly
			boolean correct=false;
			
			//while loop to repeat guesses until the user is correct
			while(user.hasNext() && !correct) {
				String userInput = user.nextLine();
				if(userInput.equals("quit")) {
					user.close();
					System.exit(0);
				}else {
					//convert the users guess into a date object
					int result;
					try {
						Date dateGuessed = new Date(userInput);
						 result = dateGuessed.compareTo(currPerson.getPerson().getBirthday());
						 if (result==0){
								//display the closing message after the birthday is guessed
								System.out.println(currPerson.closingMessage());
								//Add the points won to the total number of points
								numPoints+=currPerson.getAwardedPointNumber();
								//display the number of points gained, and the total number of points
								System.out.println("You won "+currPerson.getAwardedPointNumber()+" points in this round. Your total number of points is "+numPoints);
								correct=true;
								peopleIterator.remove();
								System.out.println("There are now "+ people.size()+" people in the game");
							}else if(result==-1) {
								System.out.println("Incorrect. Try a later date");
							}
							else
								System.out.println("Incorrect. Try an earlier date");
					}catch(IncorrectDateException e){
						System.out.println(e.getMessage());
					}finally {
						System.out.println("If you would like to stop, type \"quit\" to exit.");
					}

				}
			}
		}
	}
	
	public static void main(String[] args){
		Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), "Liberal"); 
		Singer dion = new Singer("Celine Dion", new Date(30, 3, 1961), "La voix du bon Dieu", new Date(6, 11, 1981));
		Singer robertson = new Singer("Ed Robertson", new Date(25, 10, 1970), " Gordon", new Date(7, 28, 1992));
		GuessMaster3 gm = new GuessMaster3();
		gm.addPerson(trudeau, 0.25);
		gm.addPerson(dion, 0.5);
		gm.addPerson(robertson, 0.75);
		System.out.println("There are "+ gm.getPeople().size()+" people in the game");
		GuessablePerson<Politician> guessableTrudeau = new  GuessablePerson<>(trudeau, 0.25);
		System.out.println("The next output should be -1");
		System.out.println(guessableTrudeau.compareTo(dion));
		gm.startGame();
	}

	
}
