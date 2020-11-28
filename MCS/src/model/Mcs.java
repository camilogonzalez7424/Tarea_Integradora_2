package model;

/**
 * Created by Camilo González
 * @since october 2020
 * @version 2.0
 */

public class Mcs{
    public final static int MAX_USER = 10; //Constant of maximum users.
    public final static int MAX_POOL_SONG = 30; //Constant of maximum songs.
    public final static int MAX_PLAYLIST = 20; //Constant of maximum playlist.

    //Attributes
    private int numUsers;  //Variable to validate the maximum number of users. 
    private int numSong;  //Variable to validate the maximum number of songs.
    private int numPlaylist; //Variable to validate the maximum number of playlists.

    //Relationship.
    private User[] user; //User arrays.
    private Song[] poolSong; //Song arrays.
    private Playlist[] playlistSong; //Playlist arrays.

    //Constructor
    
     /**
	 * Constructor method of the mcs class.
     * 
     * the user arrays and 
     * an attribute to keep track of the users in the application is initialized.
     * 
     * the song arrays 
     * and an attribute to keep track of the songs in the application is initialized.
     * 
     * the playlist arrays and 
     * an attribute to keep track of the playlists in the application is initialized.
	 */
    public Mcs(){

        user = new User[MAX_USER];
        poolSong = new Song[MAX_POOL_SONG];
        playlistSong = new Playlist[MAX_PLAYLIST];
       numUsers = 0;
       numSong = 0;
       numPlaylist = 0;
        }
        
        /**  
        * Method that lets me know if users can still be created. <br>
        * @return boolean that determines if there is space or not. 
        */
        public boolean hasUser() {
            return numUsers < MAX_USER;
        }
        /** 
         * Method that create an user. <br>
         * Pre: Must have space in the users array. <br>
         * @param userName User name
         * @param password User password
         * @param age User age
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
        * Method that displays the information of all created users. <br>
        * pre: there must be at least one user created in the user's array. <br>
        * @return String , with the information of all the users created so far.
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
        * Method that lets me know if songs can still be created. <br>
        * @return boolean that determines if there is space or not
        */
         public boolean hasSong() {
             return numSong < MAX_POOL_SONG;
            }

    
    /** 
     * Method that allows the user to create songs and add them directly to the song pool
     * pre: the pool of songs array must be declared. <br>
     * pos: <br>
     * @param title , type String
     * @param band , type String
     * @param date , type String 
     * @param minute , type int
     * @param second , type int
     * @param songGenre type String
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
 * This method searches for a specific user in the user array. <br>
 * pre: there must be at least one user created in the user's array. <br>
 * @param userName , type String
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
    return objSearch;
}

    /** 
    * Method that displays the names of all users created so far. <br>
    * pre: there must be at least one user created in the user's array. <br>
    * @return String , with the names of all the users created so far
    */
    public String findUsers(){
        String out = "";
        for(int i = 0; i<MAX_USER ; i++){
            if(user[i] != null){
                out += "("+(i+1)+")"+user[i].getUserName()+",";
        }
    }
    return out;
}

    /** 
    * Method that creates an arrangement with users able to access a certain restricted playlist. <br>
    * @param indexes location of users who can access a restricted playlist.
    * @return User[] an array of users who are able to access the restricted playlist.
    */
    public User[] restrictedUserArray(int[] indexes){
        User[] usersArray = new User[5];
        for(int i = 0; i<5; i++){
            usersArray[i] = user[indexes[i]];
    }
    return usersArray;
}

    /**
    * This method searches for a specific song in the songs array. <br>
    * pre: there must be at least one song created in the song's array. <br>
    * @param songName , type String.
    * @return Song 
    */
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
    /**
    *This method searches for a specific playlist in the playlist array. <br>
    * pre: there must be at least one playlist created in the playlist's array. <br>
    * @param playlistName , type String.
    * @return playlist.
    */
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
    * Method that updates the rank of each user. <br>
    * pre: there must be at least one user created in the user's array. <br>
    * @param name the user we want to update their rank. 
    */
    public void updateCategory(String name){
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
     * Method that displays the information of all songs created so far. <br>
     * pre: there must be at least one song in the song arrangement. <br>
     * @return String , with the information of all the songs created so far
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
    * Method that lets me know if playlist can still be created. <br>
    * @return boolean that determines if there is space or not
    */
    public boolean hasPlaylist() {
        return numSong < MAX_PLAYLIST;
    }


    /** 
    * Method that allows creating a playlist. <br>
    * pre: a playlist arrangement must be declared in order to save. <br>
    * @param name name of the playlist.
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
    * Method that allows creating a playlist. <br>
    * pre: a playlist arrangement must be declared in order to save. <br>
    * @param name the name of the playlist.
    * @param myUser array of users that create the playlist.
    */
    public void createPlaylist(String name, User[] myUser){
        boolean space = false; 
        for(int i=0; i<MAX_PLAYLIST&& !space; i++){
            if(playlistSong[i] == null){
                playlistSong[i] = new Restricted(name, myUser);
                space = true;
                numPlaylist++;
        }

    }
}

    /** 
    * Method that allows creating a playlist. <br>
    * pre: a playlist arrangement must be declared in order to save. <br>
    * @param name the name of the playlist
    * @param myUser user that create the playlist
    */
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

    /** 
    * Method that allows showing all the playlists created so far. <br>
    * pre: there must be at least one playlist in the playlist array. <br>
    * @return String , with all the information of each playlist
    */
    public String showPlaylists(){
        String out = "";
        for(int i = 0; i<MAX_PLAYLIST; i++){
            if(playlistSong[i] != null){
                out += playlistSong[i].playlistToString();
        }
        
    }
    
    return out;
}

/**
 * This method verifies what type of playlist it is and depending on that it verifies whether or not the user can enter songs. <br>
 * @param mySong , type String.
 * @param myPlaylist , type String. 
 * @param myUser , type String.
 * @param index , type String. 
 * @return a String with the corresponding message.
 */
public String addSongToPLaylist(String mySong, String myPlaylist, String myUser, int index){
   String menssage = "";
    Song objectSong = findSong(mySong);
  User objectUser = findUser(myUser);
  Playlist objecPlaylist = findPlaylist(myPlaylist);

 if(objecPlaylist instanceof Private){
     if(((Private)objecPlaylist).getMyUser().equals(objectUser)){
        objecPlaylist.addFromPool(objectSong);
        menssage = "¡Cancion añadida a la playlist!";
     }

     else{
            menssage = "¡Este usuario no tienen acceso!";
     }
     
 }
           
 else if(objecPlaylist instanceof Restricted){
     User[] restrictedName = ((Restricted)objecPlaylist).getMyUser1();
     boolean out = false;
     for(int i = 0;i<restrictedName.length && !out;i++){
        if(restrictedName[i].equals(user[index])){
            objecPlaylist.addFromPool(objectSong);
            out = true;
            menssage = "¡Cancion añadida a la playlist!";
        }else{
            menssage = "¡Este usuario no tienen acceso!"; 
        }
       
     }
}

  else{
      objecPlaylist.addFromPool(objectSong);
      menssage = "¡Cancion añadida a la playlist!";
    }

    return menssage;
}

/**
 * This method receives the data to rate a public playlist. also check if the playlist is public. <br>
 * pre: there must be at least one public playlist in the playlist arrangement. <br>
 * pos: send the data to another method to calculate the grade. <br>
 * @param score , type double.
 * @param namePlaylist , type String.
 */
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