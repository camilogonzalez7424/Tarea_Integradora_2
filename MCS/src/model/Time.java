package model;

public class Time{
    
    //Attributes

     private int minute;
     private int second;

    /** 
     * Constructor method of the time class.
     * @param minute, type int.
     * @param second, type int.
     */
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

     
     /** 
      * This method concatenates the minutes and seconds.
      * @return a message of type String
      */
     public String toString(){
		return minute +":"+second;
    }
    
    
    /** 
     * This method converts time from minutes to seconds.
     * @return totalSeconds of type int.
     */
    public int timeToSeconds(){
        int totalSeconds = 0;
        totalSeconds = (minute*60)+second;
        return totalSeconds;
    }
}