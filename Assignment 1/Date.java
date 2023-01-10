public class Date {
//these 3 instance variables are required
private int day;
private int month;
private int year;

public Date(int day, int month, int year) {
	this.day = day;
	this.month = month;
	this.year = year;
}

public Date(Date otherDate) {
	this.day = otherDate.day;
	this.month = otherDate.month;
	this.year = otherDate.year;
}

public Date (String sDate){
    day = Integer.parseInt(sDate.substring(0, 2));
    month = Integer.parseInt(sDate.substring(3, 5));
    year = Integer.parseInt(sDate.substring(6));
}

public Date clone() {
	return new Date(this);
}


public int getDay() {
	return this.day;
}

public int getMonth() {
	return this.month;
}

public int getYear() {
	return this.year;
}

public void setDay(int day) {
	this.day = day;
}

public void setMonth(int month) {
	this.month = month;
}

public void setYear(int year) {
	this.year = year;
}

public boolean equals(Date date) {
	if(this.day==date.day && this.month==date.month && this.year==date.year)
		return true;
	else
		return false;
}

public String toString() {
	return day+", "+month+", "+year;
}



}
