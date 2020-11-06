package model;

public class Restricted extends Playlist{

    public static final int ACCESS= 5;

    //Attributes
    private User[] myUser1 = new User[ACCESS];

    //Constructor
    public Restricted(String name, User[] myUser1) {
        super(name);
        this.myUser1 = myUser1;
    }


    public User[] getMyUser1() {
        return myUser1;
    }

    public void setMyUser1(User[] myUser1) {
        this.myUser1 = myUser1;
    }

    public String myUsersName(){
        String names="";
        for(int i=0; i<ACCESS; i++){
            if(myUser1[i] != null){
                names+= myUser1[i].getUserName()+",";

            }

        }
        if(names.equals("") || names==null){
            names= "No se ha guardado nada";
        }
       return names;
    }

    @Override
    public String playlistToString(){
        String out = "";
        out ="********** Restricted Playlist **********\n"+
             "** Title: "+getName()+"\n"+
             "** Duration:"+ timeToFormat(updateDuration()) +"\n"+
             "** Genre:"+ changeGenrePlaylist(playlistAllGenre()) +"\n"+
             "** User: "+myUsersName()+"\n"+
             "******************************\n";

            return out;
        }

       
   
    
}