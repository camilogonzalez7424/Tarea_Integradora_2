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

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getDate() {
        return date;
    }
   
    public void setDate(String date) {
        this.date = date;
    }
    
    public Time getDurationTime() {
        return durationTime;
    }

    public void setDurationTime(Time durationTime) {
        this.durationTime = durationTime;
    }

    public Genre getSongGenre() {
        return songGenre;
    }

    public void setSongGenre(Genre songGenre) {
        this.songGenre = songGenre;
    }

    
    /** 
     * @return int
     */
    public int songDurationSong(){
        int durationInSeconds = getDurationTime().timeToSeconds();
        return durationInSeconds;
    }

    
    /** 
     * @return String
     */
    public String toString(){
		return "****** Song ******\n"+
		"Title: "+ title + "\n"+
        "Artist: "+ band + "\n"+
        "Duration: "+ durationTime.toString() + "\n"+
        "Genre: "+ songGenre+"\n"+
        "******************\n";
	}

}