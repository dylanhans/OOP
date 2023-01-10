
public class Singer extends Person {
	//these two instance variables were required
	private String debutAlbum;
	private Date debutAlbumReleaseDate;
	
	//this constructor was required, and needed to avoid privacy leaks
	public Singer(String name, Date birthday, double difficulty, String debutAlbum, Date debutAlbumReleaseDate) {
		super(name, birthday, difficulty);
		this.debutAlbum = debutAlbum;
		this.debutAlbumReleaseDate = debutAlbumReleaseDate;
	}
	
	//this copy constructor was required
	public Singer(Singer newSinger) {
		super(newSinger.getName(), newSinger.getBirthday(), newSinger.getDifficulty());
		this.debutAlbum = newSinger.debutAlbum;
		this.debutAlbumReleaseDate = new Date(newSinger.debutAlbumReleaseDate);
		}
	
	//this clone method was required
	public Singer clone() {
		return new Singer(this);
	}
	
	//this toString method was required
	public String toString() {
		return super.toString()+". Their debut album was "+this.debutAlbum+", and it was released on "+this.debutAlbumReleaseDate.getDay()+" "+this.debutAlbumReleaseDate.getMonth()+", "+this.debutAlbumReleaseDate.getYear();
	}
	
	//this method was required
	public String personType() {
		return "singer";
	}

}
