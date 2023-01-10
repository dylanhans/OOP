
public class Politician extends Person{
	//this one instance variable was required
	private String party;
	
	//this constructor was required, and needed to avoid privacy leaks
		public Politician(String name, Date birthday, double difficulty, String party) {
			super(name, birthday, difficulty);
			this.party = party;
			
		}
		
		//this copy constructor was required
		public Politician(Politician newPolitician) {
			super(newPolitician.getName(), newPolitician.getBirthday(), newPolitician.getDifficulty());
			this.party = newPolitician.party;
			}
		
		//this clone method was required
		public Politician clone() {
			return new Politician(this);
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
