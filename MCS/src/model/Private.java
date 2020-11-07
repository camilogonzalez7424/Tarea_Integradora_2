package model;

public class Private extends Playlist{

    //Relationship
    private User myUser;

    //Constructor
    public Private(String name, User myUser) {
        super(name);
        this.myUser = myUser;
    }

    //Getters and Setters

    public User getMyUser() {
        return myUser;
    }

    public void setMyUser(User myUser) {
        this.myUser = myUser;
    }

    @Override
    public String playlistToString(){
        String out = "";
        out ="********** Private Playlist **********\n"+
             "** Title: "+getName()+"\n"+
             "** Duration:"+ timeToFormat(updateDuration()) +"\n"+
             "** Genre:"+ changeGenrePlaylist(playlistAllGenre()) +"\n"+
             "** User: "+myUser.getUserName()+"\n"+
             "******************************\n";

            return out;
        }   
}