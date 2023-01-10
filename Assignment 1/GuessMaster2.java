//They will have most likely needed to import the Arrays, Scanner, and Random classes to accomplish this task

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class GuessMaster2{
	
	private Person[] people;
	private int numPoints;
	private int numPeople;
	
	//this method was required. They needed to avoid privacy leaks
	public void addPerson(Person newPerson) {
		//this if-else statement handles the case where the array has not been initialized as there are no people
		if (numPeople==0){
			Person[] newPeople = {newPerson.clone()};
			this.people = newPeople;
			this.numPeople++;
		}else {
			Person[] newPeople = Arrays.copyOf(this.people, this.numPeople+1);
			newPeople[newPeople.length-1] = newPerson.clone();
			this.people = newPeople;
			this.numPeople++;
		}
		
	}
	
	//this method is required and could be implemented in any number of ways. The students needed to create any of the methods they use within this method.
	//I have created an example solution here which uses all of the methods and variables they had to define (plus a few more)
	//So long as they defined all their methods without privacy leaks, and accomplished the goals of the task they should get full marks
	public void startGame() {
		System.out.println("Welcome! Let's start the game!");
		//variable to keep track of when the user has quit
		boolean quitGame = false;
		//get random number for the Person to guess
		Random rdm = new Random();
		//scanner object for getting user input
		Scanner user = new Scanner(System.in);
		
		
		//the following loop(s) could have been done any number of ways, but here is a simple version that students probably did something similar to
		//this while loop repeats until the user quits
		while(!quitGame) {
			int index = rdm.nextInt(this.numPeople);
			Person currPerson = people[index];
			System.out.println(currPerson.startMessage());
			//boolean value for when the user guesses correctly
			boolean correct=false;
			
			//while loop to repeat guesses until the user is correct
			while(!correct) {
				String userInput = user.nextLine();
				if(userInput.equals("quit")) {
					user.close();
					System.exit(0);
				}else {
					//convert the users guess into a date object
					Date dateGuessed = new Date(userInput);
					//this loop could have been done in a variety of ways.
					if (dateGuessed.equals(currPerson.getBirthday())){
						//display the closing message after the birthday is guessed
						System.out.println(currPerson.closingMessage());
						//Add the points won to the total number of points
						numPoints+=currPerson.getAwardedPointNumber();
						//display the number of points gained, and the total number of points
						System.out.println("You won "+currPerson.getAwardedPointNumber()+" points in this round. Your total number of points is "+numPoints);
						correct=true;
					}else if(dateGuessed.getYear() > currPerson.getBirthday().getYear()) {
						System.out.println("Incorrect. Try an earlier year.");
					}else if(dateGuessed.getYear() <currPerson.getBirthday().getYear()) {
						System.out.println("Incorrect. Try a later year.");
					}else if(dateGuessed.getMonth() > currPerson.getBirthday().getMonth()) {
						System.out.println("Incorrect. Try an earlier month.");
					}else if(dateGuessed.getMonth() < currPerson.getBirthday().getMonth()) {
						System.out.println("Incorrect. Try a later month.");
					}else if(dateGuessed.getDay() > currPerson.getBirthday().getDay()) {
						System.out.println("Incorrect. Try an earlier day.");
					}else{
						System.out.println("Incorrect. Try a later day.");
					}
				
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		Politician trudeau = new Politician("Justin Trudeau", new Date(25, 12, 1971), 0.25, "Liberal"); 
		Singer dion = new Singer("Celine Dion", new Date(30, 3, 1961), 0.5, "La voix du bon Dieu", new Date(6, 11, 1981));
		Singer robertson = new Singer("Ed Robertson", new Date(25, 10, 1970), 0.75, " Gordon", new Date(7, 28, 1992));
		GuessMaster2 gm = new GuessMaster2();
		gm.addPerson(trudeau);
		gm.addPerson(dion);
		gm.addPerson(robertson);
		gm.startGame();
	}
	
}
