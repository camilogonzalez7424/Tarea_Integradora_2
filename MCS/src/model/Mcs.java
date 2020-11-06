package model;

/**
 * Created by Camilo González
 * @since october 2020
 * @version 2.0
 */

public class Mcs{
    public final static int MAX_USER = 10; //Constant maximo de usuarios.
    public final static int MAX_POOL_SONG = 30; //Constant maximo de canciones.
    public final static int MAX_PLAYLIST = 20; //Constant maximo de playlist.

    private User[] user; //Array de usuario.
    private Song[] poolSong; //Array de canciones.
    private Playlist[] playlistSong; //Array de playlist.

   private int numUsers;  //Variable para validar el maximo de usuarios. 
   private int numSong;  //Variable para validar el maximo de canciones.
   private int numPlaylist; //Variable para validar el maximo de playlist.

    public Mcs(){

        user = new User[MAX_USER];
        poolSong = new Song[MAX_POOL_SONG];
        playlistSong = new Playlist[MAX_PLAYLIST];
       numUsers = 0;
       numSong = 0;
        }
        
        /** 
         * @return boolean
         */
        public boolean hasUser() {
            return numUsers < MAX_USER;
        }
        /** 
         * @param userName
         * @param password
         * @param age
         */
        public void createUser(String userName, String password, int age){
            boolean space = false;
            for(int i=0; i<MAX_USER && !space; i++){
                if(user[i] == null){
                    user[i] = new User(userName,password,age);
                    space = true;
                    numUsers++;
                }

            }
    }

    
         /** 
        * @return String
         */
        public String showUser(){
		    String out ="";
		    for (int i=0; i<MAX_USER; i++){
			    if(user[i]!= null){
				    out+= user[i].toString();
			    }
		    }		
         return out;
        }

         
         /** 
          * @return boolean
          */
         public boolean hasSong() {
             return numSong < MAX_POOL_SONG;
            }

    
    /** 
     * @param title
     * @param band
     * @param date
     * @param minute
     * @param second
     * @param songGenre
     */
    public void addSongToPool(String title, String band,String date, int minute,int second, String songGenre){
        Time durationTime = new Time(minute,second);
        boolean space = false;
        for(int i=0; i<MAX_POOL_SONG && !space; i++){
            if(poolSong[i] == null){
                poolSong[i] = new Song(title,band,date,durationTime,songGenre); 
                space = true;
                numSong++;
            }

        }
        
}


/** 
 * @param userName
 * @return User
 */
public User findUser(String userName){
    User objSearch=null;
    boolean findUs=false;
    for (int i=0;i<MAX_USER && !findUs;i++){
        if (user[i]!=null && user[i].getUserName().equalsIgnoreCase(userName)){
            objSearch=user[i];
            findUs=true;	
        }
    }
   // objSearch.setShareSong(objSearch.getShareSong()+1);
    return objSearch;
}

public Song findSong(String songName){
    Song objSearch=null;
    boolean findUs=false;
    for (int i=0;i<MAX_POOL_SONG && !findUs;i++){
        if (poolSong[i]!=null && poolSong[i].getTitle().equalsIgnoreCase(songName)){
            objSearch=poolSong[i];
            findUs=true;	
        }
    }
    return objSearch;
}

public Playlist findPlaylist(String playlistName){
    Playlist objSearch=null;
    boolean findUs=false;
    for (int i=0;i<MAX_PLAYLIST && !findUs;i++){
        if (playlistSong[i]!=null && playlistSong[i].getName().equalsIgnoreCase(playlistName)){
            objSearch=playlistSong[i];
            findUs=true;	
        }
    }
    return objSearch;
}

/** 
 * @param name
 */
public void updateRank(String name){
    User objsearch = findUser(name); 
    objsearch.setShareSong(objsearch.getShareSong()+1);

    if(objsearch.getShareSong() >=3 && objsearch.getShareSong() < 10){

        objsearch.setType(objsearch.convert("LITTLE_CONTRIBUTOR"));

    }else if(objsearch.getShareSong() >= 10 && objsearch.getShareSong() < 30){

        objsearch.setType(objsearch.convert("MILD_CONTRIBUTOR"));

    }else if(objsearch.getShareSong() >= 30) {

        objsearch.setType(objsearch.convert("STAR_CONTRIBUTOR"));
    }

}

    
    /** 
     * @return String
     */
    public String showSong(){
        String out1 ="";
        for (int i=0; i<MAX_POOL_SONG; i++){
         if(poolSong[i]!= null){
            out1+= poolSong[i].toString();
         }
    }		
    return out1;
}


/** 
 * @return boolean
 */
public boolean hasPlaylist() {
    return numSong < MAX_PLAYLIST;
   }

   
   /** 
    * @param name
    * @param score
    */
   public void createPlaylist(String name){
    boolean space = false;
    for(int i=0; i<MAX_PLAYLIST&& !space; i++){
        if(playlistSong[i] == null){
            playlistSong[i] = new Public(name);
            space = true;
            numPlaylist++;
        }

    }
}

/** 
 * @param name
 * @param creatorUser
 */
//*********************************************************
public void createPlaylist(String name, User[] myUser){
    boolean space = false;
    for(int i=0; i<MAX_PLAYLIST&& !space; i++){
        if(playlistSong[i] == null){
            playlistSong[i] = new Restricted(name,myUser);
            space = true;
            numPlaylist++;
        }

    }
}

/** 
 * @param name
 */
//**********************************************************
public void createPlaylist(String name,User myUser){
    boolean space = false;
    for(int i=0; i<MAX_PLAYLIST&& !space; i++){
        if(playlistSong[i] == null){
            playlistSong[i] = new Private(name,myUser);
            space = true;
            numPlaylist++;
        }

    }
}
public String showPlaylists(){
    String out = "";
    for(int i = 0; i<MAX_PLAYLIST; i++){
        if(playlistSong[i] != null){
           // playlistSong[i].changeGenrePlaylist(playlistAllGenre);
           // playlistSong[i].timeToFormat(playlistSong[i].updateDuration());
            out += playlistSong[i].playlistToString();
        }
        
    }
    
    return out;
}
public void addSongToPLaylist(String mySong, String myPlaylist){
  Song objectSong = findSong(mySong);
  Playlist objecPlaylist = findPlaylist(myPlaylist);
  if(objectSong !=null){
    objecPlaylist.setPlaylistDuration(objectSong.getDurationTime());
 }
  objecPlaylist.addFromPool(objectSong);
}

public void scorePublicPlaylist(double score, String namePlaylist){
    Playlist objecPlaylist = findPlaylist(namePlaylist);
    if(objecPlaylist!=null){
           if(objecPlaylist instanceof Public){
               Public scorePlaylist=(Public)objecPlaylist;

               scorePlaylist.setScore(score);
           }
       }
    

}

}