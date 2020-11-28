package model;

public abstract class Playlist{
    public final static int MAX_PLAYLIST = 20; //Constant

    //Attributes
    private String name;

    //Relationships 
    private Genre playlistGenre;
    private Time playlistDuration;
    private Song[] songs;


    //Constructor

    /**
     * Generic playlist constructor. <br>
     * @param name , name of the playlist
     */
    public Playlist(String name) {
        this.name = name;
        this.playlistGenre = Genre.UNKNOWN;
        this.playlistDuration = new Time(0,0);
        songs = new Song[MAX_PLAYLIST];

    }

//Getters and Setters

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public Genre getPlaylistGenre() {
    return playlistGenre;
}

public void setPlaylistGenre(Genre playlistGenre) {
    this.playlistGenre = playlistGenre;
}

public Time getPlaylistDuration() {
    return playlistDuration;
}

public void setPlaylistDuration(Time playlistDuration) {
   this.playlistDuration = playlistDuration;
}

public Song[] getSongs() {
    return songs;
}

public void setSongs(Song[] songs) {
    this.songs = songs;
}


/** 
 * this method receives the specific song and enters it in the song arrangement of the playlist. <br>
 * @param theSong , type Song.
 */
public void addFromPool(Song theSong){
    boolean out=false;
    for(int i =0; i<MAX_PLAYLIST && out!=true; i++){
        if(songs[i] ==null){
            songs[i]= theSong;
            out=true;
        }

    }

}


    /** 
    * Method that returns an array with the genres of all the songs stored in the playlist
    * pre:
    * @return Gender[] arrangement with all genres of songs from the playlist
    */
    public Genre[] playlistAllGenre(){
        Genre allSongsGenre[] = new Genre[MAX_PLAYLIST];
    
        for(int i = 0; i<MAX_PLAYLIST; i++){
            if(songs[i] != null){
                allSongsGenre[i] = songs[i].getSongGenre();
            }
        }
    return allSongsGenre;
}

    /** 
     * Method that updates the genre of the playlist without repeating genres. <br>
     * pre:
     * pos:
     * @param allSongsGenre genre arrangement of all songs in playlist
     * @return String , with the genres without repeating from the playlist
     */
    public String changeGenrePlaylist(Genre[] allSongsGenre){
        String out = "";
        boolean stop = false;
        if(allSongsGenre[0] == null){
            out = "UNKNOWN";
        }else{
            for(int i = 0; i<MAX_PLAYLIST; i++){
                for(int j = 0; j<MAX_PLAYLIST-1 && !stop; j++){
                    if(i != j){
                        if(allSongsGenre[i] == allSongsGenre[j]){
                            allSongsGenre[i] = null;

                    }  
                }  
            }     
        }
        for(int i = 0; i < MAX_PLAYLIST; i++){
            if(allSongsGenre[i] != null){
                out += allSongsGenre[i]+", ";
            }
        }
    }
    return out;
}


    /** 
    * Method that updates the playlist time
    * pre: song arrangement must be defined with at least one song
    * pos:
    * @return int , seconds of total playlist duration
    */
public int updateDuration(){
    int newSecondsTotal = 0;
    for(int i = 0; i < MAX_PLAYLIST; i++){
        if(songs[i] != null){
            newSecondsTotal += songs[i].songDurationSong();
        }
    }
    return newSecondsTotal;
}


/** 
 * method that receives the total of seconds and transforms them into minutes and seconds. <br>
 * @param newSecondsTotal , type int.
 * @return String
 */
public String timeToFormat(int newSecondsTotal){
    String out = "";
    int minutes = newSecondsTotal/60;
    int seconds = newSecondsTotal-(minutes*60);
    out = minutes+":"+seconds;
    return out;
}


/** 
 * Method that prints all the information of a playlist.
 * @return String
 */
public String playlistToString(){
    String out = "";
    out ="********** Playlist **********\n"+
         "** Title: "+name+"\n"+
         "** Duration:"+ timeToFormat(updateDuration())+ "\n"+
         "** Genre: "+ changeGenrePlaylist(playlistAllGenre());

    return out;
}

}