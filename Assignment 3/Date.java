public class Date implements Comparable<Date>, Cloneable{
	
	private static class Months{
		
		private static int getDays(int month) {
			switch(month) {
				case(2):
					return 28;
				case(4):
					return 30;
				case(6):
					return 30;
				case(9):
					return 30;
				case(11):
					return 30;
				default:
					return 31;	
				}
		}
	}
	
	
//these 3 instance variables are required
private int day;
private int month;
private int year;

public Date(int day, int month, int year) {
	this.day = day;
	this.month = month;
	this.year = year;
}


public Date (String sDate) throws IncorrectDateException{
	int newDay = Integer.parseInt(sDate.substring(0, 2));
	int newMonth = Integer.parseInt(sDate.substring(3, 5));
	int newYear = Integer.parseInt(sDate.substring(6));
	
	if(sDate.length()!=10 || newDay<1 || newMonth<1 || newYear<1 || newDay>Months.getDays(newMonth)) {
		throw new IncorrectDateException(sDate);
	}else {
		day = newDay;
	    month = newMonth;
	    year = newYear;
	}
  
}

public Date clone(){
	try {
		return (Date) super.clone();
	} catch(CloneNotSupportedException e)
    {//This should not happen.
        return null; //To keep compiler happy.
    }	
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


public int compareTo(Date o) {
	if(this.equals(o))
		return 0;
	else if(year < o.year || year == o.year && this.getMonth( ) < o.getMonth( ) || year == o.year && month == o.month && day < o.day)
		return -1;
	else
		return 1;
}



}
