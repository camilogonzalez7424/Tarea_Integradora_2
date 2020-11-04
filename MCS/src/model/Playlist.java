package model;

public abstract class Playlist{
    //Constant
    public final static int MAX_PLAYLIST = 20;
    //attributes
    private String name;

    //relationships 
    private Genre playlistGenre;
    private Time playlistDuration;
    private Song[] songs;


    //Constructor
    public Playlist(String name) {
        this.name = name;
        this.playlistGenre = playlistGenre;
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

public void setPlaylistDuration(int minute, int second) {
    this.playlistDuration.setMinute(minute);
    this.playlistDuration.setSecond(second);
}

/*public String addSongtoplaylist(Song[] songs, User objuser){
    String message = "";
    boolean addSong = false;
    for (int i= 0; i < Mcs.MAX_POOL_SONG && !addSong; i++){

        if(songs[i] == null){
            addSong = true;

            songs[i] = objsong;
            message = "Se añadio correctamente";
        }
    }

    if(addSong == false){
        message = "No se pudo crear la cancion en la playlist";
    }
    return message;
}*/

}