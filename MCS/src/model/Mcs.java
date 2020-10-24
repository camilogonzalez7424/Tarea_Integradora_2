package model;

public class Mcs{
    public final static int MAX_POOLSONG = 30;
    public final static int MAX_USER = 10;
    public final static int MAX_PLAYLIST = 20;
    private User[] user;
   // private Song[] poolSong;
   // private Playlist[] playlistSong;
   private int numUsers;    

    public Mcs(){

        user = new User[MAX_USER];
       // poolSong = new Song[MAX_POOLSONG];
       // playlistSong = new Playlist[MAX_PLAYLIST];
       numUsers = 0;
        }
        public boolean hasUser() {
            return numUsers < MAX_USER;
        }
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
}