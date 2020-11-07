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
 * @param theSong
 */
public void addFromPool(Song theSong){
    boolean out=false;
    for(int i =0; i<MAX_PLAYLIST && out!=true; i++){
        if(songs[i] ==null){
            songs[i]= theSong;
            out=true;
            System.out.println("La cancion fue añadida exitosamente");
        }

    }

}


/** 
 * @return Genre[]
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
 * @param allSongsGenre
 * @return String
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
 * @return int
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
 * @param newSecondsTotal
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
         "** Genre: "+ changeGenrePlaylist(playlistAllGenre()) + "\n"+
         "******************************\n";

    return out;
}

}