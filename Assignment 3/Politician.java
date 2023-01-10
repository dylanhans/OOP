
public class Politician extends Person{
	//this one instance variable was required
	private String party;
	
	//this constructor was required, and needed to avoid privacy leaks
		public Politician(String name, Date birthday, String party) {
			super(name, birthday);
			this.party = party;
			
		}
		
		//this copy constructor was required
		public Politician(Politician newPolitician) {
			super(newPolitician.getName(), newPolitician.getBirthday());
			this.party = newPolitician.party;
			}
		
		//this clone method was required
		public Politician clone(){
			return (Politician) super.clone();
		}
		
		//this toString method was required
		public String toString() {
			return super.toString()+". They are a member of the "+this.party+" party.";
		}
		
		//this method was required
		public String personType() {
			return "politician";
		}
}
