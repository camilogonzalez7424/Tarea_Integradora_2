package model;

public class Time{
     //Attributes

     private int minute;
     private int second;

     public Time(int minute, int second) {
         this.minute = minute;
         this.second = second;
     }

     public int getMinute() {
         return minute;
     }

     public void setMinute(int minute) {
         this.minute = minute;
     }

     public int getSecond() {
         return second;
     }

     public void setSecond(int second) {
         this.second = second;
     }

     public String toString(){
		return minute +":"+second;
	}
}