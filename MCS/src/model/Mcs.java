package model;

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

         public boolean hasSong() {
             return numSong < MAX_POOL_SONG;
            }

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

public void updateRank(String name,int shareSong){
    User objsearch = findUser(name); //Solucionar el contador 
    objsearch.setCategory(shareSong);


}

    public String showSong(){
        String out1 ="";
        for (int i=0; i<MAX_POOL_SONG; i++){
         if(poolSong[i]!= null){
            out1+= poolSong[i].toString();
         }
    }		
    return out1;
}

public boolean hasPlaylist() {
    return numSong < MAX_PLAYLIST;
   }

   public void createPlaylist(String name, double score){
    boolean space = false;
    for(int i=0; i<MAX_PLAYLIST&& !space; i++){
        if(playlistSong[i] == null){
            playlistSong[i] = new Public(name,score);
            space = true;
            numPlaylist++;
        }

    }
}
//*********************************************************
public void createPlaylist(String name,String creatorUser){
    boolean space = false;
    for(int i=0; i<MAX_PLAYLIST&& !space; i++){
        if(playlistSong[i] == null){
            playlistSong[i] = new Restricted(name);
            space = true;
            numPlaylist++;
        }

    }
}
//**********************************************************
public void createPlaylist(String name){
    boolean space = false;
    for(int i=0; i<MAX_PLAYLIST&& !space; i++){
        if(playlistSong[i] == null){
            playlistSong[i] = new Private(name);
            space = true;
            numPlaylist++;
        }

    }
}

}