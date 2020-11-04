package model;

public class Song{
       
    //Attributes
    private String title;
    private String band;
    private String date;

    //Relationship

    private Time durationTime;
    private Genre songGenre;

    public Song(String title, String band,String date, Time durationTime, String songGenre) {
        this.title = title;
        this.band = band;
        this.date = date;
        this.durationTime = durationTime;
        this.songGenre = Genre.valueOf(songGenre);
    }

    /** 
     * @return String
     */
    public String getTitle() {
        return title;
    }

    
    /** 
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    
    /** 
     * @return String
     */
    public String getBand() {
        return band;
    }

    
    /** 
     * @param band
     */
    public void setBand(String band) {
        this.band = band;
    }

    public String getDate() {
        return date;
    }
   
    public void setDate(String date) {
        this.date = date;
    }
    
    /** 
     * @return durationTime
     */
    public Time getDurationTime() {
        return durationTime;
    }

    
    /** 
     * @param durationTime
     */
    public void setDurationTime(Time durationTime) {
        this.durationTime = durationTime;
    }

    
    /** 
     * @return songGenre
     */
    public Genre getSonGenre() {
        return songGenre;
    }

    
    /** 
     * @param songGenre
     */
    public void setSongGenre(Genre songGenre) {
        this.songGenre = songGenre;
    }

    public String toString(){
		return "****** Song ******\n"+
		"Title: "+ title + "\n"+
        "Artist: "+ band + "\n"+
        "Duration: "+ durationTime.toString() + "\n"+
		"Genre: "+ getSonGenre() + "\n";
	}

}