package mps;

public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date(){
        day = 1;
        month = 1;
        year = 1000;
    }
    public Date(int y, int m, int d){
        this.year = y;
        this.month = m;
        this.day = d;
    }
    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }  
    public int getDay(){
        return day;
    }
    public void setYear(int year){
        if(year < 1000 || year > 9999)
            throw new IllegalArgumentException("Hey, this is an error! Try again.");
        this.year = year;
    }
    public void setMonth(int month){
        if(month < 1 || month > 12)
            throw new IllegalArgumentException("Hey, this is an error! Try again.");
        this.month = month;
    }
    public void setDay(int day){
        if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day > 31 ){
            throw new IllegalArgumentException("Hey, this is an error! Try again.");
        }
        else if((year % 4 == 0) && (day > 29)){
            throw new IllegalArgumentException("Hey, this is an error! Try again.");
        }
        else if((year % 4 != 0) && (day > 28)){
            throw new IllegalArgumentException("Hey, this is an error! Try again.");
        }
        this.day = day;
    }
    public String toString(){
        String formattedDate = String.format("%d/%02d/%02d", year, month, day);
        return formattedDate;
    }
    public void setDate(int year, int month, int day){
      this.year = year;
      this.month = month;
      this.day = day;
    }
}
