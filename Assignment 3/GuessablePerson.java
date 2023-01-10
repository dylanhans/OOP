
public class GuessablePerson<T extends Person> implements Guessable, Cloneable{
	
	private T person;
	private double difficulty;
	
	public GuessablePerson(T person, double difficulty) {
		this.person = (T) person.clone();
		this.difficulty = difficulty;
	}

	@Override
	public int compareTo(Person param) {
		if((2021 - this.person.getBirthday().getYear()) < (2021 - param.getBirthday().getYear())) {
			return -1;
		}else if((2021 - this.person.getBirthday().getYear()) > (2021 - param.getBirthday().getYear())) {
			return 1;
		}else {
			return this.person.getName().compareTo(param.toString());
		}
	}

	
	public String startMessage() {
		return "Guess the birthday of the "+person.personType()+" "+person.getName();
	}


	public String closingMessage() {
		return "Congratulations! You were correct, "+person.toString();
	}


	public int getAwardedPointNumber() {
		double points = this.difficulty*100;
		return (int) points;
	}
	
	public GuessablePerson<T> clone() throws CloneNotSupportedException{
		return (GuessablePerson<T>) super.clone();
	}
	
	public T getPerson() {
		return person;
	}
		
}
