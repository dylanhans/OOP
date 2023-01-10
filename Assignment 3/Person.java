
public abstract class Person implements Cloneable{
	//these 3 instance variables are required
	private String name;
	private Date birthday;
	
	//While not "required" students will have needed to make this constructor
	//All methods needed to avoid privacy leaks
	public Person(String name, Date birthday){
		this.name = name;
		this.birthday = birthday.clone();
	}
	
	//this copy constructor was required, be sure that it avoids a privacy leak with the birthday variable
	public Person(Person newPerson){
		this.name = newPerson.name;
		this.birthday = newPerson.birthday.clone();
	}
	
	//this method was required, and should return a string in this exact format
	public String toString() {
		return (this.name + ", was born on "+this.birthday.getDay()+" "+this.birthday.getMonth()+", "+this.birthday.getYear());
	}
	
	//this abstract method was required
	public abstract String personType();
	
	public Person clone(){
	        try
	        {
	        	Person copy =
	                      (Person)super.clone( );
	            copy.birthday =
	                   (Date) birthday.clone( );
	            return copy;
	        }
	        catch(CloneNotSupportedException e)
	        {//This should not happen.
	            return null; //To keep compiler happy.
	        }
	}
	/*
	public int getAwardedPointNumber() {
		double points = this.difficulty*100;
		return (int) points;
		
	}
	
	//this abstract method was required
	//public abstract Person clone();
	
	//this method was required
	/*public String startMessage() {
		return "Guess the birthday of the "+this.personType()+" "+this.getName();
	}
	
	//this method was required
	public String closingMessage() {
		return "Congratulations! You were correct, "+this.toString();
	}*/
	
	//the following accessor methods were not required (though they were likely created and used). 
	//These are the ones that allowed me to complete this example assignment
	
	public String getName() {
		return this.name;
	}
	
	//note they needed to avoid a privacy leak when doing this
	public Date getBirthday(){
		return this.birthday.clone();
	}
	
	
}
