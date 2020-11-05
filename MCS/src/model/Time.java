package model;

public class Time{
     //Attributes

     private int minute;
     private int second;

     public Time(int minute, int second) {
         this.minute = minute;
         this.second = second;
     }

     
     /** 
      * @return int
      */
     public int getMinute() {
         return minute;
     }

     
     /** 
      * @param minute
      */
     public void setMinute(int minute) {
         this.minute = minute;
     }

     
     /** 
      * @return int
      */
     public int getSecond() {
         return second;
     }

     
     /** 
      * @param second
      */
     public void setSecond(int second) {
         this.second = second;
     }

     
     /** 
      * @return String
      */
     public String toString(){
		return minute +":"+second;
	}
}