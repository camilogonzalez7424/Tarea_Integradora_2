package model;

public class Mcs{
    public final static int MAX_POOL_SONG = 30;
    public final static int MAX_USER = 10;
    public final static int MAX_PLAYLIST = 20;
    private User[] user;
    private Song[] poolSong;
   // private Playlist[] playlistSong;
   private int numUsers;   
   private int numSong; 

    public Mcs(){

        user = new User[MAX_USER];
        poolSong = new Song[MAX_POOL_SONG];
       // playlistSong = new Playlist[MAX_PLAYLIST];
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

    public void addSongToPool(String title, String band,String date, int minute,int second, String genreSong){
        Time durationTime = new Time(minute,second);
        Genre songGenre = Genre.valueOf(genreSong);
        boolean space = false;
        for(int i=0; i<MAX_POOL_SONG && !space; i++){
            if(poolSong[i] == null){
                poolSong[i] = new Song(title,band,date,durationTime,songGenre); 
                space = true;
                numSong++;
            }

        }
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
}